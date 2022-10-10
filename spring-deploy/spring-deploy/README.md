
## Despliegue de apps Spring Boot en Heroku

Crear archivo `system.properties` en el proyecto con el contenido:

```
java.runtime.version=18   alansastre,5 minutes ago . ajustar url a la página principal 
```
1. Crear cuenta en heroku.com y github.com
2. Tener configurado git en el ordenador (ejecutar únicamente la primera vez que se utiliza git)
   1. `git config --global user.name "Alan Sastre"`
   2. `git config --global user.email alan@example.com`
3. Subir el proyecto a GitHub desde IntelliJ IDEA desde la opción: VCS > Share projects on GitHub
4. Desde Heroku, crear app y elegir método GitHub y buscar el repositorio subido
5. Habilitar deploy automático y ejecutar el Deploy


## Ejercicio 1

* Probar a empaquetar la aplicación con maven package desde IntelliJ IDEA

* Desde terminal en IntelliJ IDEA verificar que se ejecuta correctamente con el comando:

```
java -jar target/spring-deploy-1.0.jar
```

* Crear un perfil para dev y otro para test con una propiedad nueva que cargaremos en el controlador.

## Ejercicio 2

Desplegar el API REST de Laptop en Heroku y verificar el funcionamiento desde POSTMAN.

## Proveedores Cloud

* Heroku -- Java, Spring, PostgreSQL. https://www.heroku.com/
* Netlify -- Fronted( React, Angular, ...). https://www.netlify.com/
* Vercel -- Fronted( React, Angular, ...). https://vercel.com/


