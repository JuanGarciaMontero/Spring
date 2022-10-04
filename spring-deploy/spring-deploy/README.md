
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