package com.example;

public class GestorFacturas {

    //1. Atributos
    Calculadora calculadora;
    String nombre;

    //2. Contstructores
    public GestorFacturas(Calculadora calculadora, String nombre){
        System.out.println("Ejecutando constructor GestorFacturas");
        this.calculadora=calculadora;
        this.nombre=nombre;

    }

    //3. Métodos.......
}
