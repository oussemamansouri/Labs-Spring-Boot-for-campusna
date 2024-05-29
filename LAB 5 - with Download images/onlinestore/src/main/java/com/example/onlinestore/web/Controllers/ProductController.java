package com.example.onlinestore.web.Controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.onlinestore.web.Models.Product;
import com.example.onlinestore.web.Models.requests.ProductForm;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
public class ProductController {

    private static List<Product> products = new ArrayList<Product>();
    private static Long idCont = 0L;

    static {
        products.add(new Product(++idCont, "ss-s9", "Samsung Galaxy s9", 500D, 50, "samsung-s9.png"));
        products.add(new Product(++idCont, "NK-5P", "Nokia 5.1 Plus", 60D, 60, null));
        products.add(new Product(++idCont, "IP-7", "iPhone 7", 600D, 30, "iphone-7.png"));
    }

    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/images";
   

    // Read products endpoints
    @RequestMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", products);
        return "list";
    }

    @RequestMapping("/")
    public String addProduct(Model model) {
        return "index";
    }

    // Create product endpoints
    @RequestMapping(path = "/products/create", method = RequestMethod.GET)
    public String getAddProductForm(Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "create";
    }

  @RequestMapping(path = "/products/create", method = RequestMethod.POST)
public String addProduct(@Valid @ModelAttribute("productForm") ProductForm productForm,
                         BindingResult bindingResult, @RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
        return "create";
    } else {
        if (!file.isEmpty()) {
            // Check if the uploaded file is an image
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                redirectAttributes.addFlashAttribute("errorMessage", "Invalid file type. Please upload an image.");
                return "redirect:/products/create";
            }

            String originalFileName = file.getOriginalFilename();
            String fileExtension = "";
            if (originalFileName != null && originalFileName.contains(".")) {
                fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            }
            String uniqueFileName = UUID.randomUUID().toString() + fileExtension;
            Path newFilePath = Paths.get(uploadDirectory, uniqueFileName);
            try {
                Files.write(newFilePath, file.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
            products.add(new Product(++idCont, productForm.getCode(), productForm.getName(),
                    productForm.getPrice(), productForm.getQuantity(), uniqueFileName));
        } else {
            products.add(new Product(++idCont, productForm.getCode(), productForm.getName(),
                    productForm.getPrice(), productForm.getQuantity(), null));
        }

        return "redirect:/products";
    }
}

// @RequestMapping(path = "/products/create", method = RequestMethod.POST)
// public String addProduct(@Valid @ModelAttribute("productForm") ProductForm productForm,
//                          BindingResult bindingResult, @RequestParam("file") MultipartFile file) {
//     if (bindingResult.hasErrors()) {
//         return "create";
//     } else {
//         if (!file.isEmpty()) {
//             String originalFileName = file.getOriginalFilename();
//             String fileExtension = "";
//             if (originalFileName != null && originalFileName.contains(".")) {
//                 fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
//             }
//             String uniqueFileName = UUID.randomUUID().toString() + fileExtension;
//             Path newFilePath = Paths.get(uploadDirectory, uniqueFileName);
//             try {
//                 Files.write(newFilePath, file.getBytes());
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//             products.add(new Product(++idCont, productForm.getCode(), productForm.getName(),
//                     productForm.getPrice(), productForm.getQuantity(), uniqueFileName));
//         } else {
//             products.add(new Product(++idCont, productForm.getCode(), productForm.getName(),
//                     productForm.getPrice(), productForm.getQuantity(), null));
//         }

//         return "redirect:/products";
//     }
// }

    // update product endpoints
    @RequestMapping(path = "/products/{id}/edit", method = RequestMethod.GET)
    public String getEditProductForm(@PathVariable Long id, Model model) {
        products.stream()
                .filter(res -> res.getId() == id)
                .findFirst()
                .ifPresent((res) -> {
                    model.addAttribute("productForm",
                            new ProductForm(res.getCode(),
                                    res.getName(), res.getPrice(), res.getQuantity(), null));
                    model.addAttribute("id", id);
                });
        return "edit";
    }

    @RequestMapping(path = "/products/{id}/edit", method = RequestMethod.POST)
    public String updateProduct( @PathVariable Long id,
            @Valid @ModelAttribute("productForm") ProductForm productForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "edit";
        }else{
        products.stream().filter(res -> res.getId() == id)
                .findFirst()
                .ifPresent(res -> {
                    res.setCode(productForm.getCode());
                    res.setName(productForm.getName());
                    res.setPrice(productForm.getPrice());
                    res.setQuantity(productForm.getQuantity());
                });

        return "redirect:/products";
        }
    }

    // delete product endpoints
    @RequestMapping(path = "/products/{id}/delete", method = RequestMethod.POST)
    public String deleteProduct(@PathVariable(value = "id") long id) {
        products.removeIf(res -> res.getId() == id);
        return "redirect:/products";
    }

}
