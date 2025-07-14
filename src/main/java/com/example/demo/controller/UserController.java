package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.impl.OrderServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @NotNull @RequestBody User user) {
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("El usuario con este email ya existe");
        }
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable @NotNull Long id) {
        if (userService.findById(id).isEmpty()) {
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }
        userService.delete(id);
        return ResponseEntity.ok("Usuario eliminado con éxito");
    }

}








