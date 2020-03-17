package com.codeup.srpingblog.controllers;


import com.codeup.srpingblog.models.Product;
import com.codeup.srpingblog.repositories.ProductsRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductsController {

    private ProductsRepo productDao;

    public ProductsController(ProductsRepo productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/products")
    public String viewProducts(){
        productDao.findAll();

        return "products";
    }

    @GetMapping("/products/view")
    public String viewProduct(long id, Model model){
       Product product = productDao.getOne(id);
        model.addAttribute("product", product);

        return "products/view";
    }


    @GetMapping("/products/edit")
    public String editProduct(Model model){
        model.addAttribute("name", name);
        model.addAttribute("description", description);
        model.addAttribute("price", price);
        model.addAttribute("inStock", inStock);

        return "products/edit";
    }

    @PostMapping("/products/edit")
    public String editProduct(long id, Model model){
        Product product = productDao.getOne(id);

        model.getAttribute("name", name);
        model.getAttribute("description", description);
        model.getAttribute("price", price);
        model.getAttribute("inStock", inStock);

        productDao.save(product);

        return "redirect:/products/view";
    }



    @GetMapping("/products/delete")
    public String deleteProduct(){
        productDao.delete();
        return "redirect:/products";
    }
}
