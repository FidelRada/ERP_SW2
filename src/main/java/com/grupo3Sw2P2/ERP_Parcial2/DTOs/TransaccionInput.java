/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.DTOs;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fidel
 */
@Setter
@Getter
public class TransaccionInput {
    private String id;
    private String tipo; // VARCHAR(50) NOT NULL, -- 'Compra', 'Venta', 'Herencia'
    private Date fecha;// DATE NOT NULL,
    private Double monto;// NUMERIC(15, 2) NOT NULL,
    private String compradorId;
    private String vendedorId;
    private String inmuebleId;
    private String detalles;
}
