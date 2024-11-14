/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.controllerGraphQL;

import com.grupo3Sw2P2.ERP_Parcial2.models.Transaccion;
import com.grupo3Sw2P2.ERP_Parcial2.repository.TransaccionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fidel
 */
@Controller
public class TransaccionGraphQLController {
    
    @Autowired
    private TransaccionRepository transaccionRepository;

    @QueryMapping
    public List<Transaccion> getAllTransacciones() {
        return transaccionRepository.findAll();
    }

    @QueryMapping
    public Transaccion getTransaccionById(@Argument String id) {
        Optional<Transaccion> transaccion = transaccionRepository.findById(id);
        return transaccion.orElse(null); // Manejo de null si no se encuentra
    }
}
