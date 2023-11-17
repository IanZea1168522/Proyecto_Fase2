/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_fase1_zea_1168522_izaguirre_1170522;

/**
 *
 * @author izeac
 */
import java.util.ArrayList;
import java.util.List;

public class ABB 
{
    Nodo raiz;

    public ABB() 
    {
        this.raiz = null;
    }

    public void insertar(String dato) 
    {
        raiz = insertarRec(raiz, dato);
    }

    private Nodo insertarRec(Nodo nodo, String dato) 
    {
        if (nodo == null) {
            return new Nodo(dato);
        }

        if (dato.split("\\|")[1].compareTo(nodo.dato.split("\\|")[1]) < 0) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, dato);
            nodo.datoHijoIzquierdo = nodo.izquierdo.dato.split("\\|")[0];
        } else if (dato.split("\\|")[1].compareTo(nodo.dato.split("\\|")[1]) > 0) {
            nodo.derecho = insertarRec(nodo.derecho, dato);
            nodo.datoHijoDerecho = nodo.derecho.dato.split("\\|")[0];
        }
        return nodo;
    }
    public List<String> listaOrdenada() 
    {
        return inOrderAVL(raiz);
    }

    private List<String> inOrderAVL(Nodo nodoActual) 
    {
        List<String> nodosInOrder = new ArrayList<>();

        if (nodoActual != null) {
            nodosInOrder.addAll(inOrderAVL(nodoActual.izquierdo));
            nodosInOrder.add(nodoActual.dato.split("\\|")[0] + "|" + nodoActual.datoHijoIzquierdo + "|" + nodoActual.datoHijoDerecho + "|" + nodoActual.dato.split("\\|")[1] + "|" + nodoActual.dato.split("\\|")[2] + "|" + "0" + "|" + "1");
            nodosInOrder.addAll(inOrderAVL(nodoActual.derecho));
        }
        return nodosInOrder;
    }
    public void eliminarArbol()
    {
        this.raiz = null;
    }
    public int contarNodos() {
        return contarNodosRec(raiz);
    }

    private int contarNodosRec(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        int izquierdo = contarNodosRec(nodo.izquierdo);
        int derecho = contarNodosRec(nodo.derecho);

        // Se cuenta el nodo actual
        return 1 + izquierdo + derecho;
    }
    public boolean existeDato(String dato) {
        return existeDatoRec(raiz, dato);
    }

    private boolean existeDatoRec(Nodo nodo, String dato) {
        if (nodo == null) {
            return false;
        }

        // Comparar el dato con el nodo actual
        int comparacion = dato.split("\\|")[1].compareTo(nodo.dato.split("\\|")[1]);

        if (comparacion == 0 && dato.split("\\|")[2].equals(nodo.dato.split("\\|")[2])) {
            // El dato es igual al nodo actual
            return true;
        } else if (comparacion < 0) {
            // El dato puede estar en el subárbol izquierdo
            return existeDatoRec(nodo.izquierdo, dato);
        } else {
            // El dato puede estar en el subárbol derecho
            return existeDatoRec(nodo.derecho, dato);
        }
    }
}
