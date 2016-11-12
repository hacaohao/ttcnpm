package controller.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import service.CategoryService;

@Controller
public class BaseController {
    protected static final String VIEW = "jsp/frontend/index";
    
    @Autowired
    CategoryService categoryService;
    
    protected ModelMap getDefaultAttribute(ModelMap mm){
        mm.put("categories", categoryService.getAllCategory());
        
        return mm;
    }
}
