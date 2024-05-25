package com.example.onlinestore.web.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.onlinestore.web.Models.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class ProductController {

    private static List<Product> products = new ArrayList<Product>();
    private static Long idCont = 0L ;

    static{
        products.add(new Product(++idCont, "ss-s9","Samsung Galaxy s9",500D, 50, "samsung-s9.png"));
        products.add(new Product(++idCont, "NK-5P","Nokia 5.1 Plus",60D, 60, null));
        products.add(new Product(++idCont, "IP-7","iPhone 7",600D, 30, "iphone-7.png"));

    }


    // Read products endpoints 
    @RequestMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", products);
        return "list";
    }

    @RequestMapping("/")
    public String addProduct(Model model) {
        return "redirect:/products";
    }


    //  product endpoints 
    @RequestMapping(path="Products/create", method=RequestMethod.GET)
    public String getAddProductForm(@RequestParam String param) {
        return new String();
    }

    @RequestMapping(path="Products/create", method=RequestMethod.POST)
    public String addProduct(@RequestParam String param) {
        return new String();
    }

    // update product endpoints 
    @RequestMapping(path="Products/{id}/edit", method=RequestMethod.GET)
    public String getEditProductForm(@RequestParam String param) {
        return new String();
    }

    @RequestMapping(path="Products/{id}/edit", method=RequestMethod.POST)
    public String updateProduct(@RequestParam String param) {
        return new String();
    }
    
     // delete product endpoints 
     @RequestMapping(path="Products/{id}/delete", method=RequestMethod.POST)
     public String deleteProduct(@RequestParam String param) {
         return new String();
     }
    


    

}
