package com.example.demo.entity;

import com.example.demo.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nombre no puede estar vacío")
    private String name;
    private Date createdAt;
    private Date updatedAt;
    private boolean isActive;
    @Email
    @NotBlank(message = "email no puede estar vacío")
    private String email;
    private String phone;
    @NotBlank(message = "dirección no puede estar vacía")
    private String address;
    @Size(min=8)
    @NotBlank(message = "contraseña no puede estar vacía")
    private String password;
    @NotNull(message = "rol no puede estar vacío")
    private Role role;
    private String imageUrl;

}
