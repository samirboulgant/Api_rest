package com.tp_rest.service;

import com.tp_rest.entity.Utilisateur;
import com.tp_rest.exception.UserNotFoundException;
import com.tp_rest.repository.UtilisateurRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur addUser(Utilisateur user) {
        return utilisateurRepository.save(user);
    }

    @Override
    public Utilisateur getUserById(long id) {
        return utilisateurRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));
    }

    @Override
    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur updateUser(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void deleteUserById(long id) {
        utilisateurRepository.deleteById(id);
    }
}
