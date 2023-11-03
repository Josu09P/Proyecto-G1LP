/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce1.infraestructure.controller;

import java.io.IOException;
import java.util.List;
import org.slf4j.*;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.ecommerce1.app.service.ProductService;
import upeu.edu.pe.ecommerce1.app.service.StockService;
import upeu.edu.pe.ecommerce1.infraestructure.entity.ProductEntity;
import upeu.edu.pe.ecommerce1.infraestructure.entity.StockEntity;
import upeu.edu.pe.ecommerce1.infraestructure.entity.UserEntity;


/**
 *
 * @author LAB-2
 */

@Controller
@RequestMapping("/productos")
public class ProductController {

    private final ProductService productService;
    private final StockService stockService;
    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService productService, StockService stockService) {
        this.productService = productService;
        this.stockService = stockService;
    }

   

    //crear nuevo producto
    @GetMapping("/create")
    public String create() {
        return "productos/create";
    }

    //guardar producto
    @PostMapping("/save")
    public String saveProduct(ProductEntity product, @RequestParam("img") MultipartFile multipartFile) throws IOException {
        log.info("Nombre de producto: {}", product);
        productService.saveProduct(product, multipartFile);
        //return "admin/products/create";
        return "redirect:/productos";
    }

    @GetMapping("")
    public String showProduct(Model model) {
        //log.info("id user desde la variable de session: {}");
        UserEntity user = new UserEntity();
        user.setId(1);
        Iterable<ProductEntity> products = productService.getProductsByUser(user);
        model.addAttribute("productos", products);
        return "/productos/show";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        ProductEntity product = productService.getProductById(id);
        log.info("Product obtenido: {}", product);
        model.addAttribute("product", product);
        return "productos/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
        return "redirect:/productos";
    }

    @GetMapping("/stock/{id}")
    public String showStocks(@PathVariable Integer id,Model model) {
        ProductEntity p = productService.getProductById(id);//A qui solo capturo el ID del producto 
        List<StockEntity> stock = stockService.getStockByProduct(p);// Capturo el stock del producto 
       model.addAttribute("stock", stock);
       return "administrador/stock";
    }
    
    @GetMapping("/carrito/{id}")
    public String showCarrito(@PathVariable Integer id, Model model){
         ProductEntity pro = productService.getProductById(id);
        log.info("Product para el carrito: {}", pro);
        model.addAttribute("pro", pro);
      return "usuario/carrito"; 
    }

}

