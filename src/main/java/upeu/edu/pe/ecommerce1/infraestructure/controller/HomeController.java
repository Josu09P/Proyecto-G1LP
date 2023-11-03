/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce1.infraestructure.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;;

import upeu.edu.pe.ecommerce1.app.service.ProductService;
import upeu.edu.pe.ecommerce1.app.service.StockService;
import upeu.edu.pe.ecommerce1.infraestructure.entity.ProductEntity;
import upeu.edu.pe.ecommerce1.app.service.ProductService;
import upeu.edu.pe.ecommerce1.app.service.StockService;


/**
 *
 * @author LAB-2
 */
@Controller
@RequestMapping("/")
public class HomeController {

    private final ProductService productService;
    private final StockService stockService;
    
    private final Logger log = LoggerFactory.getLogger(HomeController.class);


    public HomeController(ProductService productService, StockService stockService) {
        this.productService = productService;
        this.stockService = stockService;

    }

    @GetMapping("")
    public String home(Model model) {

        model.addAttribute("products", productService.getProducts());
        return "usuario/home";

    }

    @GetMapping("productohome/{id}")
    public String productoHome(@PathVariable Integer id, Model model) {
      ProductEntity product = productService.getProductById(id);
        //log.info("Id product: {}", id);
        //log.info("stock size: {}", stocks.size());

        model.addAttribute("product", product);
        return "usuario/productohome";
    }

    @PostMapping("/cart")
    public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad) {

        return "usuario/carrito";
    }
    
    
    
   	
	@PostMapping("/search")
	public String searchProduct(@RequestParam String nombre, Model model) {
		log.info("Nombre del producto: {}", nombre);	
	
		return "usuario/home";
	}

}
