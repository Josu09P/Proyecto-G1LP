/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecommerce1.infraestructure.adapter;

import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.ecommerce1.infraestructure.entity.ProductEntity;
import upeu.edu.pe.ecommerce1.infraestructure.entity.UserEntity;


/**
 *
 * @author LAB-2
 */
public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer>{
    Iterable<ProductEntity> findByUserEntity(UserEntity user);
}
