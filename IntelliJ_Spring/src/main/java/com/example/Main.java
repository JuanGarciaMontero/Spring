package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] arg) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // CONCEPTO 1: Cómo obtener beans de Spring
            // No se instancia la clase lo hace automáticamente Sprint
            // Calculadora calculadora1= new Calculadora();

            //Opcion 1: Crear un objeto de forma normal
            //Calculadora service = new Calculadora();

            //Opcion 2: Recibir un objeto de Sprint
            Calculadora calculadora = (Calculadora) context.getBean("calculadora");

            String texto = calculadora.holaMundo();
            System.out.println(texto);

            // Se puede volver a obtener
            // OJO: se recupeera el mismo objeto
            Calculadora calculadora2 = (Calculadora) context.getBean("calculadora");
            texto= calculadora2.holaMundo();
            System.out.println(texto);

        // CONCEPTO 2: Cargar bean dentro de otro bean. Se carga el objeto más de una vez.

            GestorFacturas gestor = (GestorFacturas) context.getBean("gestorFacturas");
            System.out.println( gestor.calculadora.holaMundo());

        // CONCEPTO 3: Scope o alcance. Se cambia en beans.xml en cada bean
        // Los beans por defecto son singleton, se crea el objeto y se reutiliza para toda la aplicación
        // podemos cambiarlo a scope="prototype" si queremos que se cree una objeto cada vez.
        // verificarlo viendo cómo se ejecuta varias veces un constructor

    }
}
