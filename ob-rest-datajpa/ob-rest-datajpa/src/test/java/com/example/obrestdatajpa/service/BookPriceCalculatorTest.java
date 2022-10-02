package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookPriceCalculatorTest {

    @Test
    void calculatePriceTest() {

        // Configuración de la prueba o test
        Book book = new Book(1L, "El Señor de los Anillo", "Author", 1000, 49.99, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        // Se ejecuta el comportamiento a testear o probar
        double price = calculator.calculatePrice(book);
        System.out.println(price);

        // Comprobaciones o aserciones
        assertTrue(price > 0);
        assertEquals(57.980000000000004, price);
    }
}