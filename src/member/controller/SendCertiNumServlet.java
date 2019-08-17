package member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.MailAuth;
import member.model.vo.RandomNum;

@WebServlet("/sendCertiNum.me")
public class SendCertiNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SendCertiNumServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		Properties prop = System.getProperties();
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "587");

		Authenticator auth = new MailAuth();

		Session session = Session.getDefaultInstance(prop, auth);

		MimeMessage msg = new MimeMessage(session);
		
		String userEmail = request.getParameter("email");
		
		try {
			msg.setSentDate(new Date());

			msg.setFrom(new InternetAddress("meaningless@gmail.com", "YOURS"));
			InternetAddress to = new InternetAddress(userEmail);
			msg.setRecipient(Message.RecipientType.TO, to);
			msg.setSubject("인증코드 입니다.", "UTF-8");
			
			
			
			
			String num = new RandomNum().getKey(6,true);
			
	
			
			
			
			
			
		
			
			msg.setText("인증 코드 :"+num, "UTF-8");

			Transport.send(msg);
	
			response.setCharacterEncoding("UTF-8");
			
			System.out.println(num);
			response.getWriter().print(num);
			
			
		} catch (AddressException ae) {
			System.out.println("AddressException : " + ae.getMessage());
		} catch (MessagingException me) {
			System.out.println("MessagingException : " + me.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException : " + e.getMessage());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
