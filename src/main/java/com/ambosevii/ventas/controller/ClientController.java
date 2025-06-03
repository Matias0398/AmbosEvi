package com.ambosevii.ventas.controller;

import com.ambosevii.ventas.entity.Client;
import com.ambosevii.ventas.entity.Role;
import com.ambosevii.ventas.service.jpa.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping("/save")
    public ResponseEntity<String> saveClient(@RequestBody Client client) {
        if(client == null || client.getEmail() == null || client.getEmail().isEmpty()){
            return ResponseEntity.badRequest().body("Datos del cliente no válidos.");
        }
        try{
            clientService.registerClient(client);
            return ResponseEntity.ok("Cliente registrado correctamente");
        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al registrar el cliente: " + e.getMessage());
        }
    }

    @GetMapping("/client")
    public ResponseEntity<String>getClientByEmail(@RequestParam String email) {
        return clientService.findByEmail(email)
                .map(client -> ResponseEntity.ok("Cliente encontrado: " + client.getName()))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?>updateClient(@PathVariable Long id, @RequestBody Client client) {
       try {
           Client update= clientService.update(id, client);
           return ResponseEntity.ok(update);
       }catch (RuntimeException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado.");
       }
    }


}



