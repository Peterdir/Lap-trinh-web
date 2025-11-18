package FinalProject.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

@WebServlet(urlPatterns = { "/admin/category/edit" })
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1,  // 1 MB
	    maxFileSize = 1024 * 1024 * 10,       // 10 MB
	    maxRequestSize = 1024 * 1024 * 50     // 50 MB
)
public class CategoryEditController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Category category = cateService.get(Integer.parseInt(id));
		req.setAttribute("category", category);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-Category.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");

	    Category category = new Category();

	  
	    String id = req.getParameter("id");
	    String name = req.getParameter("name");

	    category.setId(Integer.parseInt(id));
	    category.setName(name);

	  
	    Part filePart = req.getPart("image"); 

	    if (filePart != null && filePart.getSize() > 0) {

	        
	        String originalFileName = filePart.getSubmittedFileName();

	        String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
	        String fileName = System.currentTimeMillis() + ext;

	   
	        String uploadPath = Constant.DIR + "/category";
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) uploadDir.mkdirs();

	        filePart.write(uploadPath + "/" + fileName);

	        category.setImages("category/" + fileName);
	    } else {
	        category.setImages(null);
	    }

	    cateService.edit(category);
	    resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}

}
