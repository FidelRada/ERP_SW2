/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.services;

import com.grupo3Sw2P2.ERP_Parcial2.models.Transaccion;
import com.grupo3Sw2P2.ERP_Parcial2.repository.TransaccionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fidel
 */
public class TransaccionService {
    
    @Autowired
    private TransaccionRepository personaRepository;


    public List<Transaccion> obtenerTodas() {
        return personaRepository.findAll();
    }

    public Optional<Transaccion> obtenerPorId(String id) {
        return personaRepository.findById(id);
    }
}
