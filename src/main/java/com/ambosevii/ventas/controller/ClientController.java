package com.ambosevii.ventas.controller;

import com.ambosevii.ventas.entity.Client;
import com.ambosevii.ventas.entity.Role;
import com.ambosevii.ventas.service.jpa.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping("/save")
    public ResponseEntity<String> saveClient(@RequestBody Client client) {
    if (client != null && client.getEmail() != null && !client.getEmail().isEmpty()) {
            // Check if the client already exists
            if (clientService.findByEmail(client.getEmail()).isPresent()) {
                return ResponseEntity.badRequest().body("El email ya fue registrado.");
            }
            // Set default role if not set
            if (client.getRole() == null) {
                client.setRole(Role.USER);
            }
            // Save the client
            clientService.save(client);
            return ResponseEntity.ok("Usuario creado.");
        }
        return ResponseEntity.badRequest().body("Datos del cliente inválidos.");
    }
}



