
## Cifrado

Es el proceso de codificar la información de su representación original (texto plano)
a texto cifrado, de manera que sólamente pueda ser descifrado utilizando una clave.

Historia del cifrado:

1. Almacenar contraseñas en texto plano
2. Almacenar contraseñas cifradas con una función hash (función aleatoria de número y letras con 'x' caracteres).
3. Almacenar contraseñas cifradas con una función hash + salt (función de creación aleatoria de 'x' caracteres asociados al username)
4. Almacenar contraseñas cifradas con una función adaptativa + factor de trabajo

La seguridad se gana haciendo que la validación de contraseñas sean costosas computacionalmente

## Algoritmos en Spring Security

* BCrypt
* PBKDF2
* scrypt
* argon2
