package OracleEmployeeDBPrj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	public EmployeeDTO employeeInsert(String sno, String name, String job, String sdpt, String email){
		String sql = "insert into employee values (?, ?, ?, ?, ?)";
		int no = Integer.parseInt(sno);
		int dpt = Integer.parseInt(sdpt);
		
		try {
			conn = DBConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.setString(2, name);
			psmt.setString(3, job);
			psmt.setInt(4, dpt);
			psmt.setString(5, email);
			psmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("예외 발생" + e.getMessage());
		}
		
		return null;
	}
	
	public EmployeeDTO employeeChk(String sno, String name){
		String sql = "select jobgrade, department, email from employee where no = ? and name = ?";
		String job = null;
		int department = 0;
		String email = null;
		int no = Integer.parseInt(sno);
		
		try {
			conn = DBConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.setString(2, name );
			rs = psmt.executeQuery();
			
			while( rs.next() ){
				job = rs.getString(1);
				department = rs.getInt(2);
				email = rs.getString(3);
			}
			
			return new EmployeeDTO(no, name, job, department, email);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
		
	}

	public EmployeeDTO employeeChkNo(String sno) {
		String sql = "select name, jobgrade, department, email from employee where no = ?";
		String name = null;
		String job = null;
		int department = 0;
		String email = null;
		int no = Integer.parseInt(sno);
		
		try {
			conn = DBConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no );
			rs = psmt.executeQuery();
			
			while( rs.next() ){
				name = rs.getString(1);
				job = rs.getString(2);
				department = rs.getInt(3);
				email = rs.getString(4);
			}
			
			return new EmployeeDTO(no, name, job, department, email);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	public EmployeeDTO employeeChkName(String name) {
		String sql = "select no, jobgrade, department, email from employee where name = ?";
		int no = 0;
		String job = null;
		int department = 0;
		String email = null;
		
		try {
			conn = DBConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			
			while( rs.next() ){
				no = rs.getInt(1);
				job = rs.getString(2);
				department = rs.getInt(3);
				email = rs.getString(4);
			}
			
			return new EmployeeDTO(no, name, job, department, email);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	public void employeeUpdate(String sno, String job, String sdpt, String email) {
		String sql = "update employee set jobgrade = ?, department = ?, email = ? where no = ?";
		int no = Integer.parseInt(sno);
		int dpt = Integer.parseInt(sdpt);
		
		try{
			conn = DBConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, job);
			psmt.setInt(2, dpt);
			psmt.setString(3, email);
			psmt.setInt(4, no);
			psmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("예외발생: " + e.getMessage() );
		}catch(Exception e){
			System.out.println(e.getMessage() );
		}
	}

	public void employeeDelete(String sno, String name) {
		String sql = "delete from employee where no = ? and name = ?";
		int no = Integer.parseInt(sno);
		
		try{
			conn = DBConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.setString(2, name);
			psmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("예외발생: " + e.getMessage() );
		}catch(Exception e){
			System.out.println("예외발생: " + e.getMessage() );
		}
	}
}
