/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce1.infraestructure.adapter;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.ecommerce1.app.repository.ProductRepository;
import upeu.edu.pe.ecommerce1.infraestructure.entity.ProductEntity;
import upeu.edu.pe.ecommerce1.infraestructure.entity.UserEntity;


/**
 *
 * @author LAB-2
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository{
    private final ProductCrudRepository productCrudRepository;

    public ProductRepositoryImpl(ProductCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }
      
    @Override
    public Iterable<ProductEntity> getProducts() {
        //metodo propio de Spring 
        return productCrudRepository.findAll();
    }

    @Override
    public Iterable<ProductEntity> getProductsByUser(UserEntity user) {
        return productCrudRepository.findByUserEntity(user);
    }

    @Override
    public ProductEntity getProductById(Integer id) {
        return productCrudRepository.findById(id).get();
    }

    @Override
    public ProductEntity saveProduct(ProductEntity product) {
       return productCrudRepository.save(product);
    }

    @Override
    public void deleteProductById(Integer id) {
       productCrudRepository.deleteById(id);
    }
    
}
