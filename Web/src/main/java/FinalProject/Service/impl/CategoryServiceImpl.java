package FinalProject.Service.impl;

import java.io.File;
import java.util.List;

import FinalProject.Model.Category;
import FinalProject.Repository.CategoryRepo;
import FinalProject.Repository.impl.CategoryRepoImpl;
import FinalProject.Service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryRepo categoryRepo = new CategoryRepoImpl();

	@Override
	public void insert(Category category) {
		categoryRepo.insert(category);
	}

	@Override
	public void delete(int id) {
		categoryRepo.delete(id);
	}

	@Override
	public void edit(Category newCategory) {
		Category oldCategory = categoryRepo.get(newCategory.getId());
		oldCategory.setName(newCategory.getName());
		if (newCategory.getImages() != null) {
			// XOA ANH CU DI
			String fileName = oldCategory.getImages();
			final String dir = "E:\\upload";
			File file = new File(dir + "/category" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldCategory.setImages(newCategory.getImages());
		}
		categoryRepo.edit(oldCategory);
	}

	@Override
	public Category get(int id) {
		return categoryRepo.get(id);
	}

	@Override
	public Category get(String name) {
		return categoryRepo.get(name);
	}

	@Override
	public List<Category> getAll() {
		return categoryRepo.getAll();
	}

	@Override
	public List<Category> search(String catename) {
		return categoryRepo.search(catename);
	}
}
