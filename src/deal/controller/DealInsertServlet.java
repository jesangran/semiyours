package deal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import common.MyFileRenamePolicy;
import deal.model.service.DealService;
import deal.model.vo.Deal;
import deal.model.vo.DealAttachment;

@WebServlet("/insert.de")
public class DealInsertServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public DealInsertServlet() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      Deal deal = null;
      if (ServletFileUpload.isMultipartContent(request)) {
         int maxSize = 1024 * 1024 * 10;

         String root = request.getSession().getServletContext().getRealPath("/");// WebContent 까지의 절대경로

         String savePath = root + "DealImages/";

         MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
               new MyFileRenamePolicy());

         String dept1 = multiRequest.getParameter("dept1");
         String dept2 = multiRequest.getParameter("dept2");
         String dealTitle = multiRequest.getParameter("dealTitle");
         String dealContent = multiRequest.getParameter("dealContent");
               System.out.println(dealContent);
            dealContent = dealContent.replace("\r\n", "<br>");
         System.out.println(dealContent);
         int dealWriter = Integer.parseInt(multiRequest.getParameter("uno"));
         int price = Integer.parseInt(multiRequest.getParameter("price"));
         int dealType = Integer.parseInt(multiRequest.getParameter("dealType"));
         String dealLocal = multiRequest.getParameter("dealLocal");
         int dealCount = Integer.parseInt(multiRequest.getParameter("dealCount"));
         

         deal = new Deal(dealTitle,dealWriter, dealContent, dealCount, dept1, dept2, dealLocal, price, dealType);

         Enumeration<String> files = multiRequest.getFileNames();

         ArrayList<String> saveFile = new ArrayList<String>();
         ArrayList<String> originFile = new ArrayList<String>();

         while (files.hasMoreElements()) {
            String name = files.nextElement();
            if (multiRequest.getFilesystemName(name) != null) { 
               saveFile.add(multiRequest.getFilesystemName(name));
               originFile.add(multiRequest.getOriginalFileName(name));
            }
         }

         

         int result = 0;
         
         ArrayList<DealAttachment> fileList = new ArrayList<DealAttachment>();
         for (int i = saveFile.size() - 1; i >= 0; i--) {
            DealAttachment file = new DealAttachment();
            file.setDaPath(savePath);
            file.setDaOrigin(originFile.get(i));
            file.setDaChange(saveFile.get(i));
            if(i==saveFile.size() - 1) {
               file.setFileLevel(1);
               
            }else {
               file.setFileLevel(0);
               
            }
            fileList.add(file);
         }
         
         if (!saveFile.isEmpty()) {

            result = new DealService().insertDeal(deal, fileList);
         }

         
         int dNo = new DealService().getRecentDNo(); 
         if (result > 0) {
            request.setAttribute("msg", "물품이 등록되었습니다.");
            response.sendRedirect("detail.de?dealNo="+dNo);
            //+((ArrayList<Deal>)request.getAttribute("dList")).get().getDealNo()+1);
         } else {
            request.setAttribute("errorMsg", "물품 등록 중 에러가 발생했습니다.");
            request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
         }
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doGet(request, response);
   }

}