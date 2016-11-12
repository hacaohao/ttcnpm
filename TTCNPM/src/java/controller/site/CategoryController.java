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
public class CategoryController extends BaseController{
    
    @Autowired
    BookService bookService;
    
    @RequestMapping(value = "/category")
    public String index(HttpServletRequest request, ModelMap mm){
        mm = super.getDefaultAttribute(mm);
        
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int categoryId = Integer.parseInt(request.getParameter("id"));
        
        List<Book> books = bookService.getAllBookByCategoryID(categoryId);
        
        Page page = new Page(books);
        page.setCurrentIndex(currentPage);
        page.setBaseUrl("category?id=" + categoryId);
        
        mm.put("title", books.get(0).getCategory().getName());
        mm.put("books", page);
        mm.put("bestSeller", bookService.getLimitedBestSeller());
        mm.put("content", "dmtls");
        return VIEW;
    }
}
