package service;

import dao.UserDAO;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    UserDAO userDAO;
    
    public void addUser(User user){
        userDAO.addUser(user);
    }
    
    public void updateUser(User user){
        userDAO.updateUser(user);
    }
    
    public void deleteUser(User user){
        userDAO.deleteUser(user);
    }
    
    public boolean checkUniqueEmail(String email){
        return userDAO.checkUniqueEmail(email);
    }
    
    public boolean checkExistEmail(String email){
        return !checkUniqueEmail(email);
    }
    
    public void updatePassword(String email){
        userDAO.updatePassword(email);
    }
    
    public User checkAccount(String email, String password){
        return userDAO.checkAccount(email, password);
    }
}
