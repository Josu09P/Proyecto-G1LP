/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce1.infraestructure.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ecommerce1.app.service.ProductService;
import upeu.edu.pe.ecommerce1.infraestructure.entity.ProductEntity;

/**
 *
 * @author LAB-2
 */
@Controller
@RequestMapping("/administrador")
public class AdminController {

    private final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String home(Model model) {
        Iterable<ProductEntity> productos = productService.getProducts();
        model.addAttribute("productos", productos);
        return "administrador/home";
        
    }
}