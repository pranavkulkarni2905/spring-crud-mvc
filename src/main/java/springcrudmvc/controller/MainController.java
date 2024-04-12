package springcrudmvc.controller;


import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import springcrudmvc.dao.ProductDao;
import springcrudmvc.entities.Product;

@Controller
public class MainController {

	@Autowired
	public ProductDao productDao;
	
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title","CRUD Operations");
		List<Product> allProducts = this.productDao.getAllProducts();
		
		model.addAttribute("product",allProducts);
		return "index";
	}
	
	@RequestMapping(value = "/handle-product",method = RequestMethod.POST)
	public RedirectView handleForm(@ModelAttribute Product product,HttpServletRequest request) {
		
		RedirectView redirectView = new RedirectView();
		this.productDao.createProduct(product);
		System.out.println(product);
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public RedirectView deleteHandle(HttpServletRequest request,@RequestParam("productIdToDelete") int id) {
		RedirectView redirectView=new RedirectView();
		
		this.productDao.deleteProduct(id);
		
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
}
