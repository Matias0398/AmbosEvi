package com.example.demo.entity;

import com.example.demo.enums.Sizes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "no puede estar vacío")
    private String name;
    @NotBlank(message = "la descripción no puede estar vacía")
    private String description;
    private String imageUrl;
    @Positive(message = "el precio debe ser positivo")
    private double price;
    private int quantity;
    @NotNull(message = "la talla no puede estar vacía")
    private Sizes sizes;
    private Date createdAt;
    private Date updatedAt;
    private boolean isActive;

    @ManyToOne
    private User user;

}
