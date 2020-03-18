package com.codeup.srpingblog.controllers;


import com.codeup.srpingblog.models.Product;
import com.codeup.srpingblog.repositories.ProductsRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductsController {

    private ProductsRepo productDao;

    public ProductsController(ProductsRepo productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/products")
    public String viewProducts(Model model){
        List<Product> prods = productDao.findAll();
        model.addAttribute("prods", prods);
        return "/products/index";
    }

    @GetMapping("/products/view")
    public String viewProduct(long id, Model model){
       Product product = productDao.getOne(id);
        model.addAttribute("product", product);

        return "/products/view";
    }

    @GetMapping("/products/create")
    public String viewCreateProdForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "products/create";
    }

    @PostMapping(value = "/save")
    public String saveProduct(@ModelAttribute("product") Product product){
        productDao.save(product);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public ModelAndView editProduct(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("/products/edit");

        Product product = productDao.getOne(id);
        mav.addObject("product", product);
        return mav;
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        productDao.deleteById(id);
        return "redirect:/products";
    }
}
