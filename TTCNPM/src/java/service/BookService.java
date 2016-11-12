package service;

import dao.BookDAO;
import entity.Book;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class BookService {
    
    @Autowired
    BookDAO bookDAO;
    
    public ArrayList<Book> getAllBook(int page){
        return bookDAO.getAllBook(page);
    }
    
    public ArrayList<Book> getAllBookByCategoryID(int categoryID) {
        return bookDAO.getAllBookByCategoryID(categoryID);
    }
    
    public ArrayList<Book> getLimitedBookByCategoryID(int categoryID){
        return bookDAO.getLimitedBookByCategoryID(categoryID);
    }
    
    public ArrayList<Book> getRelativeBook(int categoryID , int bookID) {
        return bookDAO.getRelativeBook(categoryID, bookID);
    }
    
    public ArrayList<Book> getAllBookByName(String name){
        return bookDAO.getAllBookByName(name);
    }
    
    public ArrayList<Book> getLimitedBestSeller(){
        return bookDAO.getLimitedBestSeller();
    }
    
    public ArrayList<Book> getAllBestSeller(){
        return bookDAO.getAllBestSeller();
    }
    
    public Book getBookByID(int bookID){
        return bookDAO.getBookByID(bookID);
    }
    
    public void addBook(Book book){
        bookDAO.addBook(book);
    }
    
    public void deleteBook(Book book){
        bookDAO.deleteBook(book);
    }
    
    public void updateBook(Book book){
        bookDAO.updateBook(book);
    }
    
    public boolean checkUniqueName(String name){
        return bookDAO.checkUniqueName(name);
    }
    
    public Book updatePoint(Book book, int ratePoint){ 
        return bookDAO.updatePoint(book, ratePoint);
    }
}
