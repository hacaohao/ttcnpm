package service;

import dao.CategoryDAO;
import entity.Category;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryService {
    
    @Autowired
    CategoryDAO categoryDAO;
    
    public ArrayList<Category> getAllCategory() {
        return categoryDAO.getAllCategory();
    }
    
    public ArrayList<Category> getAllCategoryByName(String name){
        return categoryDAO.getAllCategoryByName(name);
    }
    
    public void addCategory(Category category){
        categoryDAO.addCategory(category);
    }
    
    public void deleteCategory(int categoryID){
        categoryDAO.deleteCategory(categoryID);
    }
    
    public void updateCategory(Category category){
        categoryDAO.updateCategory(category);
    }
    
    public boolean checkUniqueName(String name){
        return categoryDAO.checkUniqueName(name);
    }
}
