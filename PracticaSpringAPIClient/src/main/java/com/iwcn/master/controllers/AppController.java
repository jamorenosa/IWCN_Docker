package com.iwcn.master.controllers;  

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.servlet.ModelAndView;

import com.iwcn.master.entities.Product;
import com.iwcn.master.services.ProductClientService;
import com.iwcn.master.services.UserDataBase;
import com.iwcn.master.services.UserService;

@Controller
public class AppController {

    @Autowired
    private UserDataBase users;
    
    @Autowired
    private ProductClientService Service;
    
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("login");
	}

	@RequestMapping("/login")  public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping("/home")  public ModelAndView home() {
		return new ModelAndView("home");
	}
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping("/productList")
    public ModelAndView showProducts() {
        return new ModelAndView("/productsList").addObject("productList", Service.GetAll());
    }
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping("/showProduct")
    public ModelAndView showProduct(@RequestParam Long index) {
        return new ModelAndView("/details").addObject("product", Service.GetProduct(index));
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/editCurrProduct")
    public ModelAndView editCurrProduct(@Valid Product product)
    {
    	this.Service.EditProduct(product);
    	return new ModelAndView("/productsList").addObject("productList", Service.GetAll());
    }
    
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/editProduct")
    public ModelAndView editProduct(@RequestParam Long index)
    {
    	return new ModelAndView("/product")
        		.addObject("product", Service.GetProduct(index))
        		.addObject("flag","edit").addObject("productId", index);
    }
    
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/deleteProduct")
    public ModelAndView deleteProduct(@RequestParam Long index) {
    	Service.DeleteProduct(index);
        return new ModelAndView("/productsList").addObject("productList", Service.GetAll());
    }
    
    /*@Secured({"ROLE_ADMIN"})
    @RequestMapping("/addCurrProduct")
    public ModelAndView addCurrProduct(@RequestParam String name, @RequestParam float price,
    		@RequestParam String description, @RequestParam String size, @RequestParam String origin,
    		@RequestParam int yearLot, @RequestParam int monthLot, @RequestParam int dayLot) {
    	Service.AddProduct(name, price, description, size, origin, yearLot, monthLot, dayLot);
        return new ModelAndView("/productsList").addObject("productList", Service.GetAll());
    }*/
    @RequestMapping(value = "/addCurrProduct", method=RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public ModelAndView addCurrProduct(@Valid Product product) {
    	Service.AddProduct(product);
        return new ModelAndView("/productsList").addObject("productList", Service.GetAll());
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/addProduct")
    public ModelAndView addProduct() {
        return new ModelAndView("/product").addObject("flag","add");
    }
    
}
