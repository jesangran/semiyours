package wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	public static String getSha512(String pwd) {
		String encPwd = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
		md.update(bytes);
		encPwd = Base64.getEncoder().encodeToString(md.digest());
		return encPwd;

	}
	
	@Override
	public String getParameter(String key) {
		
		String value="";
		if(key != null && (key.equals("loginPwd") ||key.equals("pwd1")||key.equals("pwd") ||key.equals("checkPwd") || key.equals("newPwd1"))) {
			value = getSha512(super.getParameter(key));
		}else {
			value = super.getParameter(key);
		}
		return value;
	}
	
	
	
}
