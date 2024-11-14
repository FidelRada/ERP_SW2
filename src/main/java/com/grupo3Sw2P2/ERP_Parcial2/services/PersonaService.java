/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.services;

import com.grupo3Sw2P2.ERP_Parcial2.models.Persona;
import com.grupo3Sw2P2.ERP_Parcial2.models.User;
import com.grupo3Sw2P2.ERP_Parcial2.repository.PersonaRepository;
import com.grupo3Sw2P2.ERP_Parcial2.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fidel
 */
@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Persona> obtenerTodas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> obtenerPorId(String id) {
        return personaRepository.findById(id);
    }

    public List<Persona> obtenerPorAdminRole() {
        // Encuentra los usuarios que tienen el rol "ADMIN"
        List<User> adminUsers = userRepository.findByRolesName("ADMIN");

        // Extrae las personas de los usuarios encontrados
        return adminUsers.stream()
                .map(User::getPersona)
                .collect(Collectors.toList());
    }

    public Persona guardar(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona actualizar(String id, Persona personaNuevo) {

        Optional<Persona> personaExiste = personaRepository.findById(id);

        if (!personaExiste.isPresent()) {
            throw new RuntimeException("Persona no encontrada con id: " + id);
        }

        Persona persona = personaExiste.get();

        persona.setCi(personaNuevo.getCi());
        persona.setNombre(personaNuevo.getNombre());
        persona.setApellidoPaterno(personaNuevo.getApellidoPaterno());
        persona.setApellidoMaterno(personaNuevo.getApellidoMaterno());

        return personaRepository.save(persona);
    }

    public void eliminar(String id) {
        personaRepository.deleteById(id);
    }
}
