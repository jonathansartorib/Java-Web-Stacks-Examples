package com.sistemaclienteservidorpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {

	private DataSource dataSource;

	public StudentDbUtil(DataSource datasource) {
		this.dataSource = datasource;
	}

	public List<Student> getStudents() throws Exception {

		List<Student> students = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = dataSource.getConnection();
			String sql = "SELECT id, first_name, last_name, email FROM STUDENT ORDER BY LAST_NAME";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");

				Student tempStudent = new Student(id, firstName, lastName, email);

				students.add(tempStudent);
			} // end while

			return students;

		} finally {
			close(con, stmt, rs);
		} // end try finally
	}// end List

	public void addStudent(Student student) throws Exception {

		Connection con = null;
		PreparedStatement stmt = null;

		try {

			con = dataSource.getConnection();
			String sql = "INSERT INTO STUDENT(FIRST_NAME, LAST_NAME, EMAIL) VALUES (?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getEmail());
			stmt.execute();

		} finally {

			close(con, stmt, null);

		} // end try finally

	}// end addStudent

	private void close(Connection con, Statement stmt, ResultSet rs) {

		try {

			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (con != null) {
				con.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// end close

}// end StudentDbUtil
