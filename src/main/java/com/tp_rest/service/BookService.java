package com.tp_rest.service;

import com.tp_rest.entity.Utilisateur;
import com.tp_rest.exception.UserNotFoundException;

import java.util.List;

public interface UtilisateurService {
    Utilisateur addUser(Utilisateur user);
    Utilisateur getUserById(long id);
    List<Utilisateur> getAllUsers();
    Utilisateur updateUser(Utilisateur utilisateur);
    void deleteUserById(long id);

}
