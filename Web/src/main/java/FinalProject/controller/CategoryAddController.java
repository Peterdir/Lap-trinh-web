package FinalProject.controller;

import java.io.File;
import java.io.IOException;

import FinalProject.Model.Category;
import FinalProject.Service.CategoryService;
import FinalProject.Service.impl.CategoryServiceImpl;
import FinalProject.utils.Constant;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(urlPatterns = { "/admin/category/add" })
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024,      // 1MB
	    maxFileSize = 1024 * 1024 * 10,       // 10MB
	    maxRequestSize = 1024 * 1024 * 50     // 50MB
)
public class CategoryAddController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-category.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");

	    Category category = new Category();


	    String name = req.getParameter("name");
	    category.setName(name);


	    Part filePart = req.getPart("image"); 

	    if (filePart != null && filePart.getSize() > 0) {

	        String originalFileName = filePart.getSubmittedFileName();

	        int index = originalFileName.lastIndexOf(".");
	        String ext = originalFileName.substring(index);

	        String fileName = System.currentTimeMillis() + ext;


	        String uploadPath = Constant.DIR + "/category";
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) uploadDir.mkdirs();

	
	        filePart.write(uploadPath + "/" + fileName);


	        category.setImages("category/" + fileName);
	    }

	    cateService.insert(category);

	    resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}
}
