/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce1.infraestructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;


/**
 *
 * @author LAB-2
 */

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String username;
    private String email;
    private String telefono;
    private String password;
    private String direccion;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    private LocalDateTime dateCreated;

    public UserEntity() {
    }

    public UserEntity(Integer id, String nombre, String username, String email, String telefono, String password, String direccion, UserType userType, LocalDateTime dateCreated) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.direccion = direccion;
        this.userType = userType;
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "UserEntity{" + "id=" + id + ", nombre=" + nombre + ", username=" + username + ", email=" + email + ", telefono=" + telefono + ", password=" + password + ", direccion=" + direccion + ", userType=" + userType + ", dateCreated=" + dateCreated + '}';
    }

}