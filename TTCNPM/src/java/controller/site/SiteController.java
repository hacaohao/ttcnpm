package controller.site;

import entity.Category;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BookService;
import service.UserService;

@Controller
@RequestMapping(value = "/site")
public class SiteController extends BaseController{
    
    @Autowired
    BookService bookService;
    
    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/index")
    public String index(ModelMap mm){
        mm = super.getDefaultAttribute(mm);
        
        ArrayList<Category> categories = categoryService.getAllCategory();
        for(Category category : categories){
            category.setBooks(bookService.getLimitedBookByCategoryID(category.getId()));
        }
        
        mm.put("bestSeller", bookService.getLimitedBestSeller());
        mm.put("categories", categories);
        mm.put("content", "trangchu");
        return VIEW;
    }
    
    @RequestMapping(value = "/about")
    public String about(ModelMap mm){
        mm = super.getDefaultAttribute(mm);
        
        mm.put("content", "lienhe");
        return VIEW;
    }
}
