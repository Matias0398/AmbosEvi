package com.ambosevii.ventas.service;


import com.ambosevii.ventas.entity.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    Optional<Client>findById(Long id);
    Client save(Client client);
    Optional<Client> findByEmail(String email);
    List<Client> findAll();
    Client update(Long id,Client client);

}
