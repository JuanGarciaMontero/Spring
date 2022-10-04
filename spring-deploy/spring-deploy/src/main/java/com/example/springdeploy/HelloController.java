package com.example.springdeploy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController para devolver datos JSON, texto, XML,...
// Controller para devolver HTML

@RestController
public class HelloController {
    // Para vincular una URL

    @Value("${app.message}")
    String message;

    @GetMapping("/hola")
    public String holaMundo(){
        System.out.println(message);
        // Para que refresque rápido marcar en setting (En IntelliJ): AdvanceSetting, Commpiler, Allow Auto-Make
        // y en (Para cada proyecto) Build, Compiller, Build Project Automatically
        return"Hola mundo que tal vamos, ahora refresca rápido, un poco rápido no react. Otra prueba.";
    }

    //""" Para insertar un bloque de código string sin tener que concatenar. ej: HTML con Bootstrap
    // Para enviar HTML pero no se hace desde aquí. Se usa en resources en carpeta static y templates.
    @GetMapping("/bootstrap")
    public String bootstrap(){
        return """
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Bootstrap demo</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
                  </head>
                  <body>
                    <h1>Hola mundo desde SpringBoot!</h1>
                    <a class="btn btn-primary" href="https://www.google.com">Google</a>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
                  </body>
                </html>
                
                """;
    }

}
