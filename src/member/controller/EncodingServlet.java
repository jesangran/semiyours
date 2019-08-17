package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import member.model.vo.Address;

@WebServlet("/encoding.juso")
public class EncodingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EncodingServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addr = request.getParameter("addr");
		String addrDetail = request.getParameter("addrDetail");
		Address address = new Address(addr,addrDetail);
		new Gson().toJson( address,response.getWriter());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
