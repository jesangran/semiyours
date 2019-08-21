package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;
public class MemberService {

	public MemberService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int checkInfo(String info) {
		Connection conn= getConnection();
		int result = new MemberDao().checkInfo(conn,info);
		return result;
	}

	public int joinMember(Member member) {
		Connection conn= getConnection();
		int result = new MemberDao().joinMember(conn,member);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public Member loginMember(String email, String pwd) {
		Connection conn = getConnection();
		MemberDao mDao = new MemberDao();
		Member member =mDao.loginMember(conn, email, pwd);
		
		return member;
	}

	public int updateMember(Member mem) {
		Connection conn = getConnection();
		MemberDao mDao =new MemberDao();
		int result = mDao.updateMember(conn,mem);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public Member selectMember(int uno) {
		Connection conn = getConnection();
		MemberDao mDao = new MemberDao();
		Member member =mDao.selectMember(conn,uno);
		
		return member;
	}

	public int updatePwd(String uno, String pwd, String newPwd) {
		Connection conn = getConnection();
		int result = new MemberDao().updatePwd(conn,uno,pwd,newPwd);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int updatePwd(String email, String pwd) {
		Connection conn = getConnection();
		int result = new MemberDao().updatePwd(conn,email,pwd);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

}
