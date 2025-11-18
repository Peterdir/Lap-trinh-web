package FinalProject.controller;

import java.io.IOException;

import FinalProject.Service.UserService;
import FinalProject.Service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forgot-password")
public class ForgotPasswordController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/forgot-password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        boolean exists = userService.checkEmailExists(email);

        if (exists) {
            request.setAttribute("email", email);
            request.getRequestDispatcher("/views/reset-password.jsp")
                   .forward(request, response);
        } else {
            request.setAttribute("message", "Email không tồn tại trong hệ thống!");
            request.getRequestDispatcher("/views/forgot-password.jsp")
                   .forward(request, response);
        }
    }
}
