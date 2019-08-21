package member.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;

import static common.JDBCTemplate.*;
public class MemberDao {
	private Properties prop = new Properties();	
	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int checkInfo(Connection conn,String info) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result =0;
		String query = prop.getProperty("checkInfo");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, info);
			pstmt.setString(2, info);
			rset =pstmt.executeQuery();
			if(rset.next()) {
				result=rset.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int joinMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result =0;
		String query  =prop.getProperty("joinMember");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getNickName());
			result=pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Member loginMember(Connection conn, String email, String pwd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query =prop.getProperty("loginMember");
		System.out.println(query);
		Member member = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, pwd);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member=new Member(
							rset.getInt(1),
							rset.getString(2),
							rset.getString(3),
							rset.getString(4),
							rset.getString(5),
							rset.getString(6),
							rset.getString(7),
							rset.getString(8),
							rset.getString(9).charAt(0),
							rset.getTimestamp(10),
							rset.getTimestamp(11),
							rset.getInt(12),
							rset.getString(13).charAt(0),
							rset.getDate(14)
				);
			}
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(member);
		return member ;
	}

	public int updateMember(Connection conn, Member mem) {
		PreparedStatement pstmt = null;
		int result =0;
		String query = prop.getProperty("updateMember");
	
		try {
			pstmt =conn.prepareStatement(query);
		
			pstmt.setString(1, mem.getAddress1());
			pstmt.setString(2, mem.getAddress2());
			pstmt.setString(3, mem.getSnsId());
			pstmt.setInt(4, mem.getUserNo());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Member selectMember(Connection conn, int uno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query =prop.getProperty("selectMember");
		Member member = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, uno);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member=new Member(
						rset.getInt(1),
						rset.getString(2),
						rset.getString(3),
						rset.getString(4),
						rset.getString(5),
						rset.getString(6),
						rset.getString(7),
						rset.getString(8),
						rset.getString(9).charAt(0),
						rset.getTimestamp(10),
						rset.getTimestamp(11),
						rset.getInt(12),
						rset.getString(13).charAt(0),
						rset.getDate(14)
				);
			}
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(member);
		return member ;
	}

	public int updatePwd(Connection conn, String uno, String pwd, String newPwd) {
		PreparedStatement pstmt = null;
		int result =0;
		String query = prop.getProperty("updatePwd");
	
		try {
			pstmt =conn.prepareStatement(query);
		
			pstmt.setString(1, newPwd);
			pstmt.setString(2, uno);
			pstmt.setString(3, pwd);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int updatePwd(Connection conn, String email, String pwd) {
		PreparedStatement pstmt = null;
		int result =0;
		String query = prop.getProperty("resetPwd");
	
		try {
			pstmt =conn.prepareStatement(query);
		
			pstmt.setString(1, pwd);
			pstmt.setString(2, email);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	
}
