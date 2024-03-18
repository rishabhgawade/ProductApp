package org.jspiders.springmvcdemo3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class ProductController {
    List<Product> productData=new ArrayList<>();

    {
        productData.add(new Product(1,"LAPTOP",45000));
        productData.add(new Product(2,"MOBILE",25000));
        productData.add(new Product(3,"HEADPHONE",1200));

    }
    @GetMapping("/")
    public  String getAllProduct(Model model){
        model.addAttribute("records",productData);
        return "productList";
    }
    @GetMapping("/addproduct")
    public String displayProductForm(Model model){
        model.addAttribute("product",new Product());
        return "addproduct";

    }
    @PostMapping("/insertproduct")
    public String addProductDetails(Product p){
        productData.add(p);
        return "redirect:/";
    }
    @GetMapping("/updateproduct/{id}")
    public String showUpdateForm(@PathVariable(value = "id") int id, Model model){
        Product p=productData.get(id-1);
        model.addAttribute("product",p);
        return "updateproduct";

    }
    @GetMapping("/modifyproduct")
    public String changeProduct(Product p){
        productData.set(p.getProductId()-1,p);
        return "redirect:/";
    }
}
