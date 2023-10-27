package com.sistemaclienteservidorpackage;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDbUtil studentDbUtil;

	@Resource(name = "jdbc/DbStudents")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		try {

			studentDbUtil = new StudentDbUtil(dataSource);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// verificar o valor do parametro "comand"
			String command = request.getParameter("command");

			// escolher a opção correta da operação
			if (command == null) {
				command = "LIST";
			}

			switch (command) {

			case "LIST":
				listStudents(request, response);
				break;
			case "ADD":
				addStudents(request, response);
				break;
			default:
				listStudents(request, response);
			}// end switch

		} catch (Exception e) {

			throw new ServletException(e);

		} // end try catch

	}// end doGet

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// recuperar estudantes do banco de dados
		List<Student> students = studentDbUtil.getStudents();

		// adicionar os dados do request
		request.setAttribute("STUDENTS_LIST", students);

		// enviar para a pagina JSP (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}// end listStudents

	private void addStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// recupera as informaçoes enviadas
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		// criar um novo objeto estudante
		Student student = new Student(0, firstName, lastName, email);

		// gravar na base
		studentDbUtil.addStudent(student);

		// voltar para a lista de estudantes
		listStudents(request, response);
	}// end addStudents

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
