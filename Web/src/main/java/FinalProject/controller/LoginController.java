package FinalProject.controller;

import java.io.IOException;

import FinalProject.Model.User;
import FinalProject.Service.UserService;
import FinalProject.Service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
	private static final long serialVerionUID = 1L;
	UserService service = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  resp.setContentType("text/html");
		  resp.setCharacterEncoding("UTF-8");
		  req.setCharacterEncoding("UTF-8");
		  String username = req.getParameter("username");        
		  String password = req.getParameter("password");       
		  boolean isRememberMe = false;
		  String remember = req.getParameter("remember");
	        
	      if("on".equals(remember)){
	    	  	isRememberMe = true;
	       }
		  
		  String alertMsg="";
		  
		  
		  if(username == null || username.trim().isEmpty() ||
				    password == null || password.trim().isEmpty()){
			  alertMsg= "Tài khoản hoặc mật khẩu không được rỗng";
			  req.setAttribute("alert", alertMsg);
			  req.getRequestDispatcher("/Login.jsp").forward(req, resp);
			  return;
		  }
		  User user = service.login(username, password);
		  if(user != null){
			  HttpSession session = req.getSession(true);          
			  resp.sendRedirect(req.getContextPath()+"/home");
		  }else{
			  alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			  req.setAttribute("alert", alertMsg);
			  req.getRequestDispatcher("/Login.jsp").forward(req, resp);
		  }
	}
}
