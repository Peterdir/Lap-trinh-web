package FinalProject.Repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import FinalProject.Model.Category;
import FinalProject.Repository.CategoryRepo;
import FinalProject.controller.config.DBMySQLConnect;

public class CategoryRepoImpl extends DBMySQLConnect implements CategoryRepo {
	@Override
	public void insert(Category category) {
		String sql = "INSERT INTO category(name,images) VALUES (?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getImages());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Category category) {
		String sql = "UPDATE category SET name = ?, images=? WHERE id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM category WHERE id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Category get(int id) {
		String sql = "SELECT * FROM category WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setImages(rs.getString("images"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Category get(String name) {
		String sql = "SELECT * FROM category WHERE name = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setImages(rs.getString("images"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM category";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setImages(rs.getString("images"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
	
	@Override
	public List<Category> search(String cateName) {
	    List<Category> categories = new ArrayList<Category>();
	    String sql = "SELECT * FROM category WHERE name LIKE ?";

	    try {
	        Connection conn = super.getConnection();
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, "%" + cateName + "%");

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Category category = new Category();
	            category.setId(rs.getInt("id"));
	            category.setName(rs.getString("name"));
	            category.setImages(rs.getString("images"));

	            categories.add(category);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return categories;
	}
	
}
