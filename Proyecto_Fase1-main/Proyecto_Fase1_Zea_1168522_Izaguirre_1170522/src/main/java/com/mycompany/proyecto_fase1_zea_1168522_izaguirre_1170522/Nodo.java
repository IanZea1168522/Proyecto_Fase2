/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_fase1_zea_1168522_izaguirre_1170522;

/**
 *
 * @author izeac
 */
public class Nodo 
{
    String dato;
    Nodo izquierdo;
    Nodo derecho;
    String datoHijoIzquierdo;
    String datoHijoDerecho;

    public Nodo(String dato) 
    {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
        this.datoHijoIzquierdo = "-1";
        this.datoHijoDerecho = "-1";
    }
}
