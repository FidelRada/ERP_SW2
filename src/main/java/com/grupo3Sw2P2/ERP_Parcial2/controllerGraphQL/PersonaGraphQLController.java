/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.controllerGraphQL;

import com.grupo3Sw2P2.ERP_Parcial2.DTOs.PersonaInput;
import com.grupo3Sw2P2.ERP_Parcial2.models.Persona;
import com.grupo3Sw2P2.ERP_Parcial2.models.User;
import com.grupo3Sw2P2.ERP_Parcial2.repository.UserRepository;
import com.grupo3Sw2P2.ERP_Parcial2.services.PersonaService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fidel
 */
@Controller
public class PersonaGraphQLController {

    @Autowired
    private PersonaService personaService;
    
    @Autowired
    private UserRepository userRepository;

    // Query to get all personas
    @QueryMapping
    public List<Persona> getAllPersonas() {
        System.out.println(personaService.obtenerTodas());
        return personaService.obtenerTodas();
    }

    // Query to get persona by id
    @QueryMapping
    public Persona getPersonaById(@Argument("id") String id) {
        Optional<Persona> persona = personaService.obtenerPorId(id);
        if (!persona.isPresent()) {
            return null;
        }
        return persona.get();
    }

    @QueryMapping
    public List<Persona> getPersonasByRolAdmin() {
        List<User> adminUsers = userRepository.findByRolesName("ADMIN");
        return adminUsers.stream()
                .map(User::getPersona)
                .collect(Collectors.toList());
    }

    // Mutation to add a new persona
    @MutationMapping
    public Persona addPersona(@Argument("input") PersonaInput input) {
        Persona persona = new Persona();
        persona.setNombre(input.getNombre());
        persona.setApellidoPaterno(input.getApellidoPaterno());
        persona.setApellidoMaterno(input.getApellidoMaterno());
        persona.setCi(input.getCi());
        persona.setWallet_address_ETH(input.getWallet_address_ETH());

        return personaService.guardar(persona);
    }

    // Mutation to update an existing persona
    @MutationMapping
    public Persona updatePersona(@Argument("id") String id, @Argument("input") PersonaInput input) {

        Optional<Persona> personaExistente = personaService.obtenerPorId(id);

        if (!personaExistente.isPresent()) {
            return null;
        }

        Persona personaActualizada = personaExistente.get();

        personaActualizada.setNombre(input.getNombre());
        personaActualizada.setApellidoPaterno(input.getApellidoPaterno());
        personaActualizada.setApellidoMaterno(input.getApellidoMaterno());
        personaActualizada.setCi(input.getCi());
        personaActualizada.setWallet_address_ETH(input.getWallet_address_ETH());

        return personaService.actualizar(id, personaActualizada);
    }

    // Mutation to delete a persona by id
    @MutationMapping
    public Boolean deletePersona(@Argument("id") String id) {

        Optional<Persona> personaExistente = personaService.obtenerPorId(id);

        if (!personaExistente.isPresent()) {
            return null;
        }

        personaService.eliminar(id);
        return true;
    }
}
