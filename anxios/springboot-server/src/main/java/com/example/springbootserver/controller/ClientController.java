package com.example.springbootserver.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootserver.model.ClientEntity;
import com.example.springbootserver.model.ClientRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @PostMapping("/add")
	public ResponseEntity<ClientEntity> createTutorial(@RequestBody ClientEntity client) {
		clientRepository.save(client);
		return new ResponseEntity<>(client, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

    @GetMapping("/getAll")
    public List<ClientEntity> getClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ClientEntity getClient(@PathVariable Long id) {
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}