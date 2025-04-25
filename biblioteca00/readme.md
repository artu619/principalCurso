<p align="center">
  <img src="Biblioteca.png" alt="Library Logo" width="200"/>
</p>

<h1 align="center">📚 Sistema de Gestión de Biblioteca en Java</h1>

Este proyecto es una aplicación de consola orientada a objetos en Java que permite gestionar una biblioteca de manera sencilla. Puedes listar recursos (libros, revistas y DVDs), prestar y devolver materiales, todo desde un menú interactivo.

🧑‍💻 Autor
Proyecto creado por Arturo como ejercicio de práctica de programación orientada a objetos en Java.
##Estado del proyecto

-version: Final

## 🚀 Características

- Registro y gestión de recursos bibliográficos (libros, revistas y DVDs).
- Registro de usuarios.
- Préstamo y devolución de recursos.
- Menú interactivo por consola.
- Código modular y bien estructurado con uso de herencia, interfaces y enumeraciones.


## 🧾 Estructura del Proyecto

biblioteca/
├── app/
│   └── Main.java
├── enums/
│   └── EstadoRecurso.java
├── interfaces/
│   └── Prestamista.java
├── model/
│   ├── RecursoBiblioteca.java
│   ├── Libro.java
│   ├── Revista.java
│   ├── DVD.java
│   └── Usuario.java
├── un logo original para una biblioteca.png
└── README.md


## 🚀 Cómo ejecutar

### Prerrequisitos

- Java 8 o superior instalado.
- (Opcional) Un IDE como IntelliJ IDEA, Eclipse o VSCode.

### Compilar desde consola

1. Clona o descarga este repositorio.
2. Abre una terminal y navega a la carpeta raíz del proyecto.
3. Ejecuta los siguientes comandos:

```bash
javac biblioteca/**/*.java
java biblioteca.app.Main
````

## 📋 Ejemplo de Uso

====== Menú Biblioteca ======
1. Listar todos los recursos
2. Prestar recurso
3. Devolver recurso
4. Salir

=============================

Seleccione una opción: 1

--- Lista de Recursos ---
📚 Libros:
  - [L1] Don Quijote (DISPONIBLE)
  - [L2] Cien Años de Soledad (DISPONIBLE)
...

