package controller.site;

import entity.Book;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pagination.Page;
import service.BookService;

@Controller
@RequestMapping(value = "/book")
public class BookController extends BaseController{
    
    @Autowired
    BookService bookService;
    
    @RequestMapping(value = "/bestSeller")
    public String bestSeller(HttpServletRequest request, ModelMap mm){
        mm = super.getDefaultAttribute(mm);
        
        int currentPage = Integer.parseInt(request.getParameter("page"));
        
        List<Book> books = bookService.getAllBestSeller();
        
        Page page = new Page(books);
        page.setCurrentIndex(currentPage);
        page.setBaseUrl("book/bestSeller");
        
        mm.put("title", "Sách bán chạy nhất");
        mm.put("books", page);
        mm.put("bestSeller", bookService.getLimitedBestSeller());
        mm.put("content", "dmtls");
        return VIEW;
    }
    
    @RequestMapping(value = "/search", produces = "text/plain;charset=UTF-8")
    public String search(HttpServletRequest request, ModelMap mm){
        mm = super.getDefaultAttribute(mm);
        
        int currentPage = Integer.parseInt(request.getParameter("page"));
        String keyword = request.getParameter("keyword");
        List<Book> books = bookService.getAllBookByName(keyword);
        
        Page page = new Page(books);
        page.setCurrentIndex(currentPage);
        page.setBaseUrl("book/search?keyword=" + keyword);
        
        mm.put("title", "Kết quả tìm kiếm với: " + keyword);
        mm.put("books", page);
        mm.put("bestSeller", bookService.getLimitedBestSeller());
        mm.put("content", "dmtls");
        return VIEW;
    }
    
    @RequestMapping(value = "/detail")
    public String detail(HttpServletRequest request, ModelMap mm){
        mm = super.getDefaultAttribute(mm);
        
        int bookId = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.getBookByID(bookId);
        
        mm.put("book", book);
        mm.put("relativeBooks", bookService.getRelativeBook(book.getCategory().getId(), bookId));
        mm.put("content", "chitietsach");
        return VIEW;
    }
}
