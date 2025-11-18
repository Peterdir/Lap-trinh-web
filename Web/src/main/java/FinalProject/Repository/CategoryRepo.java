package FinalProject.Repository;
import java.util.List;

import FinalProject.Model.Category;

public interface CategoryRepo {
	 void insert(Category category);
	 void edit(Category category);
	 void delete(int id);
	 Category get(int id);
	 Category get(String name);
	 List<Category> getAll();
	 List<Category> search(String cateName);
}
