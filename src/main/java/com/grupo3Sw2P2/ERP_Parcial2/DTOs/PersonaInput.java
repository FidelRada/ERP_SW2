/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.DTOs;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fidel
 */
@Setter
@Getter
public class PersonaInput {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String ci;
    private String wallet_address_ETH;
}
