package customer.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import common.MyFileRenamePolicy;
import customer.model.service.QnaService;
import customer.model.vo.QnaAttachment;
import customer.model.vo.QnaVo;

@WebServlet("/insert.qna")
public class insertQna extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public insertQna() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		if (ServletFileUpload.isMultipartContent(request)) {
			// 전송파일 용량 제한 : 10MB로 지정
			int maxSize = 1024 * 1024 * 10;
			System.out.println(maxSize);
			// 파일 용량 확인
			String root = request.getSession().getServletContext().getRealPath("/");
			// Webcontentt까지의 절대 경로이다.

			// 파일 저장 경로 지정
			String savePath = root + "UploadImages/";
			System.out.println(savePath);
			// 경로 확인
			MultipartRequest multiRequest 
				= new MultipartRequest(
						request, savePath, maxSize, 
						"UTF-8", new MyFileRenamePolicy());
			System.out.println(multiRequest);

			// 문의유형
			String qType = multiRequest.getParameter("category");
			// 제목
			String qTitle = multiRequest.getParameter("title");
			// 내용
			String qcontent = multiRequest.getParameter("content");
			
			// 로그인시 로그인 정보(아이디 저장, 추후 병합이나 로그인 정도 확인 후, 추가할 예정
			int qWriter = 1;/* =((Member)request.getSession().getAttribute("loginUser")).getUserNo(); */
			/*
			 * System.out.println(writer); System.out.println(category);
			 * System.out.println(title); System.out.println(content);
			 */
			System.out.println(qcontent);
			QnaVo qBoard = new QnaVo();
			qBoard.setqType(qType);
			qBoard.setqTitle(qTitle);
			qBoard.setQcontent(qcontent);
			qBoard.setqWriter(qWriter);

			System.out.println(qBoard);
			// 입력 정보 확인 (유형, 제목, 내용,
			Enumeration<String> files = multiRequest.getFileNames();
			String saveFile = null; // 저장될 파일 이름
			String originFile = null; // 파일 원본 이름

			if (files.hasMoreElements()) {
				String name = files.nextElement();
				// 파일명은 있으나 파일이 없는 경우 // 오류를 방지한다.
				if (multiRequest.getFilesystemName(name) != null) { // 파일명은 있는데 내용물은 있는가?
					saveFile = multiRequest.getFilesystemName(name);
					originFile = multiRequest.getOriginalFileName(name);
				}
			}
			int result = 0;
			System.out.println("변경 이름 : " + saveFile);
			System.out.println("원래 이름 : " + originFile);
			if (saveFile != null) {
				// 단일 파일 업로드
				// 파일 정보를 DB에 저장
				QnaAttachment file = new QnaAttachment();
				file.setQaPath(savePath); // 파일 경로
				file.setQaOrigin(originFile); // 파일 원래 이름
				file.setQaChange(saveFile); // 파일 변경 이름
				// 게시글 + 파일 정보 DB 저장
				System.out.println("쿼리 가기 전");
				result = new QnaService().insertBoard(qBoard, file);
			} else {
				result = new QnaService().insertBoard(qBoard);
			}
			System.out.println(result);
			if (result > 0) {
				request.setAttribute("msg","문의 등록이 완료되었습니다.");
				// response.sendRedirect("customer_Go");
				response.sendRedirect("views/customer/ServiceCenter.jsp");
			} else {
				request.setAttribute("msg", "게시글 작성 에러");
				request.getRequestDispatcher("views/board/boardInsertForm.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
