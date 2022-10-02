package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    // atributos
    private BookRepository bookRepository;

    // constructores
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // CRUD sobre la entidad Book

    /**
     * Buscar todos los libros que hay en base de datos (ArrayList de libros)
     * http://localhost:8081/api/books
     * @return
     */
    // Devuelve en URL un JSon con todos los libros
    @GetMapping("/api/books")
    public List<Book> findAll(){
        // Recuperar y devolver los libros de BD
        return bookRepository.findAll();
    }


    /**
     * http://localhost:8081/api/books/1
     * http://localhost:8081/api/books/2
     * Request
     * Response
     * @param id
     * @return
     */

    // Buscar un sólo libro en base de datos según id
    @GetMapping("/api/books/{id}")
    @ApiOperation("Buscar un libro por clave primaria id Long")
    //public Book findOneById(@PathVariable Long id){
    public ResponseEntity<Book> findOneById(@ApiParam("Clave primaria tipo id Long") @PathVariable Long id){

        Optional<Book> bookOpt = bookRepository.findById(id); // id=154565547899554
        // Opcion 1. Primeros sin ResponseEntity
        /*if(bookOpt.isPresent())
            //return bookOpt.get();
            return ResponseEntity.ok(bookOpt.get());
        else
            //return null;
            return ResponseEntity.notFound().build();*/
        // Menos código con expresión funcional que tiene función lambda y método tfrenes (...::...)
            return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        // Opcion 2 igual con menos código. Devuelve null si no hay libro pero el Response es 200 tendría que ser 404
        //return bookOpt.orElse(null);
   }


    /**
     * Crear un nuevo libro en base de datos
     * Método POST, no colisiona con findAll porque son diferentes métodos HTTP: GET y POST
     * @param book
     * @param headers
     * @return
     */
    // Crear un nuevo libro en base de datos
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));

        // Guardar el libro recibido por parámetro en la base de datos
        if(book.getId() != null){ // quiere decir que existe el id y por tanto no es una creación
            log.warn("trying to create a book with id with log");
            System.out.println("trying to create a book with id with println" );
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);// El libro devuelto tiene un clave primaria
    }


    /**
     * Actualizar un libro existente en base de datos
     */
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if(book.getId() == null){ // si no tiene id quiere decir que si es una creación
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!bookRepository.existsById(book.getId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }
        // El proceso de actualización
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }


    // Borrar un libro  existente en base de datos
    // No permite Método DELETE
    @ApiIgnore
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){

        if(!bookRepository.existsById(id)){
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }

        bookRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    @ApiIgnore// Ignora el siguiente método para que no salga en API Swagger
    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
        log.info("REST Request for delete all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }



}
