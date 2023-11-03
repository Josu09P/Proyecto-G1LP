/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce1.infraestructure.controller;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ecommerce1.app.repository.UserRepository;
import upeu.edu.pe.ecommerce1.app.service.UserService;
import upeu.edu.pe.ecommerce1.infraestructure.entity.UserEntity;
import upeu.edu.pe.ecommerce1.infraestructure.entity.UserType;

/**
 *
 * @author USUARIO
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final Logger logger= LoggerFactory.getLogger(UsuarioController.class);
    
    
    private final UserRepository userRepository;

    public UsuarioController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

 
    // /usuario/registro
    @GetMapping("/registro")
    public String create() {
        return "usuario/registro";
    }

    @PostMapping("/save")
    public String save(UserEntity usuario) {
        logger.info("Usuario registro: {}", usuario);
        usuario.setUserType(UserType.USER);
        userRepository.save(usuario);
        return "redirect:/";
    }
    
    @GetMapping("/login")
	public String login() {
		return "usuario/login";
	}

       @PostMapping("/acceder")
	public String acceder(UserEntity usuario) {
            logger.info("Accesos : {}", usuario);
            Optional<UserEntity> user=userRepository.findByEmail(usuario.getEmail());
            logger.info("Usuario de db: {}", user.get());
            

        return "redirect:/";
        }
        
}
