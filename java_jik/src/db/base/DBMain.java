package db.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class DBMain {

	public static void main(String[] args) {
		//MySQL 설치 시 port 번호를 수정하지 않았다면 3306
		String url = "jdbc:mysql://localhost:3306/test";
		String id = "root";
		String pw = "root";
		
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e){
			System.out.println("연결 실패");
		} catch (ClassNotFoundException e){
			System.out.println("드라이버를 찾을 수 없습니다.");
		}

		//insert문 예제
		/*
		//Statement를 이용한 예제
		String sql = "insert into member values('asdasd','pwasd','asd@naver.com',now())";
		Statement stmt = null;
		try{
			stmt = con.createStatement();
			stmt.execute(sql);
			System.out.println("회원 추가 성공!");
		} catch (SQLException e){
			System.out.println("예외 발생");
			e.printStackTrace();
		}
		*/
		//String sql = "쿼리";
		//예시 ?을 이용하여 값을 동적으로 변경
		/*String sql = "insert into member values(?,?,?,now())";
		PreparedStatement pstmt = null;
		try{
			pstmt = con.prepareStatement(sql);
			//?개수만큼 setxxx을 이용하여 바인딩 해야 함
			pstmt.setString(1, "qweqwe");
			pstmt.setString(2, "pwqwe");
			pstmt.setString(3, "qwe@naver.com");
			//쿼리가 적용된 행의 개수를 리턴.
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("예외 발생");
		}*/
		//update문 예제
		/*String sql = "update member set pw = ? where id = ?";
		PreparedStatement pstmt = null;
		try{
			pstmt = con.prepareStatement(sql);
			//?개수만큼 setxxx을 이용하여 바인딩 해야 함
			pstmt.setString(1, "newPw");
			pstmt.setString(2, "qweqwe");
			//쿼리가 적용된 행의 개수를 리턴.
			pstmt.executeUpdate();
			System.out.println("비번 수정 성공");
		}catch(SQLException e){
			System.out.println("예외 발생");
		}*/
		//delete문 예제
		/*String sql = "delete from member where id = ?";
		PreparedStatement pstmt = null;
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "qweqwe");
			pstmt.executeUpdate();
			System.out.println("회원 삭제 성공");
		}catch(SQLException e){
			System.out.println("예외 발생");
		}*/
		//select문 예제
		String sql = "select * from member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		try{
			pstmt = con.prepareStatement(sql);
			//쿼리에 ?가 있다면 pstmt.setXX을 통해 바인딩
			rs = pstmt.executeQuery();
			//검색된 행(레코드 만큼 반복)
			while(rs.next()){
				//검색 결과 첫번째 열이 id, 두번째 열이 pw이라고 가정
				//첫번째 열이 문자열이기 때문에 getString()을 이용
				//정수라면 getInt()
				String dbId = rs.getString(1);
				String dbPw = rs.getString(2);
				String dbEmail = rs.getString(3);
				Date dbRegeDate = rs.getDate(4);
				//System.out.println("ID : " + dbId + ", PW : " + dbPw
				//		+ ", EMAIL : " + dbEmail + ", 가입일 : " + dbRegeDate);
				Member member = new Member(dbId, dbPw, dbEmail, dbRegeDate);
				System.out.println(member);
				list.add(member);
			}
		} catch (SQLException e){
			System.out.println("예외 발생");
		}
	}
}
@Data
@AllArgsConstructor
class Member{
	String id, pw, email;
	Date regeDate;
}

