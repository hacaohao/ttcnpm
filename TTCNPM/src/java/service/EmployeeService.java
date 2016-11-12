package service;

import dao.EmployeeDAO;
import entity.Employee;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {
    
    @Autowired
    EmployeeDAO employeeDAO;
    
    public ArrayList<Employee> getAllEmployee(int page) {
        return employeeDAO.getAllEmployee(page);
    }
    
    public ArrayList<Employee> getAllEmployeeByName(int page, String name){
        return employeeDAO.getAllEmployeeByName(page, name);
    }
    
    public Employee getEmployeeByID(int employeeID){
        return employeeDAO.getEmployeeByID(employeeID);
    }
    
    public String createCode(){
        return employeeDAO.createCode();
    }
}
