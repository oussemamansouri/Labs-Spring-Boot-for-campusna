package com.example.onlinestore.web.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.onlinestore.web.Models.Product;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;




@Controller
public class ProductController {

    private static List<Product> products = new ArrayList<Product>();
    private static Long idCont = 0L ;

    static{
        products.add(new Product(++idCont, "ss-s9","Samsung Galaxy s9",500D, 50, "samsung-s9.png"));
        products.add(new Product(++idCont, "NK-5P","Nokia 5.1 Plus",60D, 60, null));
        products.add(new Product(++idCont, "IP-7","iPhone 7",600D, 30, "iphone-7.png"));

    }


    @RequestMapping("/product")
    // @ResponseBody
    public String getProducts(@RequestParam(value = "clientName" , required = true) String client , Model model) {
        model.addAttribute("products", products);
        model.addAttribute("client", client);
        return "list";
        // return "<h1>"+client+"</h1>";
    }

    @RequestMapping("/")
    public String addProduct(Model model) {
        return "redirect:/product";
    }

    // @ExceptionHandler(Exception.class)
    // @ResponseBody
    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // public String handelException( Exception e){
    //     return " <h1 style='color:red;' >errur: "+ e.getMessage()+"</h1>";
    // }
    

}
