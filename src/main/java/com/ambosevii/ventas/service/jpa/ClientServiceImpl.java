package com.ambosevii.ventas.service.jpa;

import com.ambosevii.ventas.entity.Client;
import com.ambosevii.ventas.repository.IClientRepository;
import com.ambosevii.ventas.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private IClientRepository clientRepository;

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
