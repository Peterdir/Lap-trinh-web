package FinalProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String userName = req.getParameter("ten");
		String lastName = req.getParameter("ho");
		String[] checkBox = req.getParameterValues("checkbox"); // Gọi khi tham số xuất hiện nhiều lần và trả về nhiều giá trị
		List<String> nameParameters = Collections.list(req.getParameterNames()); // .getParameterNames() trả về kiểu Enumeration<String>
		
		nameParameters.forEach(name -> {
			System.out.println(name + " = " + req.getParameter(name));
		});
		
		PrintWriter pw = resp.getWriter();
		
		pw.print("Hello World" + " " + lastName + " " + userName);
		
		pw.close();
	}
}
