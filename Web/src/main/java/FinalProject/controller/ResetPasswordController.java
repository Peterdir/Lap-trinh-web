package FinalProject.controller;

import java.io.IOException;

import FinalProject.Service.UserService;
import FinalProject.Service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reset-password")
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String newPass = request.getParameter("newPassword");
        String confirm = request.getParameter("confirmPassword");

        if (!newPass.equals(confirm)) {
            request.setAttribute("email", email);
            request.setAttribute("message", "Mật khẩu nhập lại không khớp!");
            request.getRequestDispatcher("/views/reset-password.jsp").forward(request, response);
            return;
        }

        boolean updated = userService.updatePassword(email, newPass);

        if (updated) {
            request.setAttribute("message", "Đổi mật khẩu thành công! Mời đăng nhập.");
            request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
        } else {
            request.setAttribute("email", email);
            request.setAttribute("message", "Có lỗi xảy ra, thử lại sau!");
            request.getRequestDispatcher("/views/reset-password.jsp").forward(request, response);
        }
    }
}
