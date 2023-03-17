package com.tp_rest.controller;


import com.tp_rest.entity.Utilisateur;
import com.tp_rest.exception.UserNotFoundException;
import com.tp_rest.service.UtilisateurService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("utilisateurs/")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUsers() {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUsers();
        if (utilisateurs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(utilisateurs);
    }

    @GetMapping("{id}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable long id) {
        try {
            Utilisateur utilisateur = utilisateurService.getUserById(id);
            return ResponseEntity.ok(utilisateur);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        }
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable Long id){
        utilisateurService.deleteUserById(id);
    }

    @PostMapping
    public Utilisateur addUser(@RequestBody Utilisateur utilisateur){
        return utilisateurService.addUser(utilisateur);
    }

    @PutMapping("{id}")
    public Utilisateur UpdateUser(@PathVariable Long id,@RequestBody Utilisateur utilisateur){
        return utilisateurService.updateUser(utilisateur);
    }


}
