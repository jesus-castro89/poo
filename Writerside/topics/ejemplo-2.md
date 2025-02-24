# Ejemplo 2: Manejando Excepciones en Java

Para este ejemplo tomaremos el código del ejemplo anterior y lo modificaremos para manejar excepciones.

## Modificando el código del Menú

Primero, vamos a modificar el código del ejemplo anterior para que lance una excepción si el no selecciona una opción
válida.

```java

    public void mostrarMenu() {

        // Mostramos el menú de opciones y manejamos la excepción
        try {
            // Mostramos el menú de opciones
            MenuOption selection = (MenuOption) JOptionPane.showInputDialog(null,
                    "Seleccione una opción:",
                    "Menú", JOptionPane.QUESTION_MESSAGE,
                    null, MenuOption.values(), MenuOption.REGISTER_PET);
            // De acuerdo a la selección llamaremos a una función o saldremos del sistema
            switch (selection) {
                case REGISTER_PET -> agregarMascota();
                case REGISTER_VET -> registrarVeterinario();
                case ATTEND_PET -> atenderMascota();
                case SHOW_PET -> mostrarInfoMascotas();
                case SHOW_VET -> mostrarInfoVeterinarios();
                case EXIT -> System.exit(0);
            }
        } catch (NullPointerException e) {
            // Si el usuario cierra la ventana del menú, salimos del sistema
            JOptionPane.showMessageDialog(null, "Selecciona una opción válida", "Error", JOptionPane.ERROR_MESSAGE);
            mostrarMenu();
        } 
    }
```

En este código, hemos envuelto el bloque de código que muestra el menú de opciones en un bloque `try-catch`. Si el
usuario cierra la ventana del menú sin seleccionar una opción, se lanzará una excepción de tipo `NullPointerException`.

## Manejando la excepción `NullPointerException`

En el bloque `catch`, mostramos un mensaje de error al usuario y llamamos a la función `mostrarMenu()` de nuevo para
permitirle seleccionar una opción válida.

```java
        } catch (NullPointerException e) {
            // Si el usuario cierra la ventana del menú, salimos del sistema
            JOptionPane.showMessageDialog(null, "Selecciona una opción válida", "Error", JOptionPane.ERROR_MESSAGE);
            mostrarMenu();
        } 
```

De esta manera, hemos manejado la excepción de forma elegante y permitimos al usuario seleccionar una opción válida sin
que el programa se bloquee o se cierre inesperadamente.

## Modificando la función de agregar mascota y registrar veterinario

Para manejar excepciones en las funciones `agregarMascota()` y `registrarVeterinario()`, podemos utilizar bloques
`try-catch` dentro de estas funciones para capturar y manejar excepciones específicas.

Por ejemplo, si queremos manejar una excepción de tipo `NumberFormatException` al intentar convertir una cadena a un
número en la función `agregarMascota()`, y si el usuario selecciona el botón cancelar o cierra la ventana de selección
del estado de salud de la mascota, podemos hacer lo siguiente:

```java
    public void agregarMascota() {
        try {
            // Código para agregar una mascota
            // ...
            // Código para convertir una cadena a un número
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota:"));
            estadoSalud = JOptionPane.showInputDialog(null,
                        "Seleccione el estado de salud de la mascota:",
                        "Estado de salud", JOptionPane.QUESTION_MESSAGE,
                        null, EstadoSalud.values(), EstadoSalud.HEALTHY).toString();
            // ...
        } catch (NumberFormatException e) {
            // Manejo de la excepción de tipo NumberFormatException
            JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            agregarMascota();
        } catch (NullPointerException e) {
            // Manejo de la excepción de tipo NullPointerException
            JOptionPane.showMessageDialog(null, "Error: Seleccione un estado de salud válido", "Error", JOptionPane.ERROR_MESSAGE);
            agregarMascota();
        }
        mostrarMenu();
    }
```

En este código, hemos envuelto el código que convierte una cadena a un número en un bloque `try-catch` para manejar la
excepción de tipo `NumberFormatException`. Si el usuario ingresa una cadena que no se puede convertir a un número, se
lanzará esta excepción y mostraremos un mensaje de error al usuario.

También hemos envuelto el código que muestra la ventana de selección del estado de salud de la mascota en un bloque
`try-catch` para manejar la excepción de tipo `NullPointerException`. Si el usuario selecciona el botón cancelar o
cierra la ventana sin seleccionar una opción, se lanzará esta excepción y mostraremos un mensaje de error al usuario.

Por su parte la función `registrarVeterinario()` puede manejar excepciones de tipo `NumberFormatException`:

```java
    public void registrarVeterinario() {
        try {
            // Código para registrar un veterinario
            // ...
            // Código para convertir una cadena a un número
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del veterinario:"));
            // ...
        } catch (NumberFormatException e) {
            // Manejo de la excepción de tipo NumberFormatException
            JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            registrarVeterinario();
        }
        mostrarMenu();
    }
```

## Modificando la función de atender mascota

Para manejar excepciones en la función `atenderMascota()`, podemos utilizar un bloque `try-catch` para capturar y
manejar excepciones específicas:

```java
    private void atenderMascota() {
    
        Mascota mascota = null;
        Veterinario veterinario = null;
        String estadoSalud;
        try{
            // Mostramos las listas desplegables para seleccionar la mascota y el veterinario
            mascota = (Mascota) JOptionPane.showInputDialog(null,
                    "Seleccione la mascota a atender:",
                    "Mascotas", JOptionPane.QUESTION_MESSAGE,
                    null, this.mascotas, this.mascotas[0]);
            veterinario = (Veterinario) JOptionPane.showInputDialog(null,
                    "Seleccione el veterinario que atenderá a la mascota:",
                    "Veterinarios", JOptionPane.QUESTION_MESSAGE,
                    null, this.veterinarios, this.veterinarios[0]);
            // Mostramos la lista desplegable para seleccionar el estado de salud de la mascota
            estadoSalud = JOptionPane.showInputDialog(null,
                    "Seleccione el estado de salud de la mascota:",
                    "Estado de salud", JOptionPane.QUESTION_MESSAGE,
                    null, EstadoSalud.values(), EstadoSalud.HEALTHY).toString();
            // Atendemos a la mascota con el veterinario seleccionado
            veterinario.atenderMascota(mascota, estadoSalud);
        } catch (NullPointerException e) {
            // Manejo de la excepción de tipo NullPointerException
            JOptionPane.showMessageDialog(null, "Error: Seleccione una mascota, veterinario y estado de salud válidos", "Error", JOptionPane.ERROR_MESSAGE);
            atenderMascota();
        }
        // Regresmos al menú principal
        mostrarMenu();
    }
```

En este código, hemos envuelto el código que muestra las listas desplegables para seleccionar la mascota, el veterinario
y el estado de salud de la mascota en un bloque `try-catch` para manejar la excepción de tipo `NullPointerException`. Si
el usuario selecciona el botón cancelar o cierra la ventana sin seleccionar una opción, se lanzará esta excepción y
mostraremos un mensaje de error al usuario.

## Código completo

A continuación se muestra el código completo de la clase `Clinica`

```java
package veterinaria;

import javax.swing.*;

public class Clinica {

    private Veterinario[] veterinarios;
    private Mascota[] mascotas;

    /**
     * Constructor de la clase Clinica que inicia cada lista con un total de 5 elementos posibles.
     */
    public Clinica() {
        this.veterinarios = new Veterinario[5];
        this.mascotas = new Mascota[5];
    }

    /**
     * Función que mostrará el menú de interacción con el usuario.
     */
    public void mostrarMenu() {

        try {
            // Mostramos el menú de opciones
            MenuOption selection = (MenuOption) JOptionPane.showInputDialog(null,
                    "Seleccione una opción:",
                    "Menú", JOptionPane.QUESTION_MESSAGE,
                    null, MenuOption.values(), MenuOption.REGISTER_PET);
            // De acuerdo a la selección llamaremos a una función o saldremos del sistema
            switch (selection) {
                case REGISTER_PET -> agregarMascota();
                case REGISTER_VET -> registrarVeterinario();
                case ATTEND_PET -> atenderMascota();
                case SHOW_PET -> mostrarInfoMascotas();
                case SHOW_VET -> mostrarInfoVeterinarios();
                case EXIT -> System.exit(0);
            }
        } catch (NullPointerException e) {
            // Si el usuario cierra la ventana del menú, salimos del sistema
            JOptionPane.showMessageDialog(null, "Selecciona una opción válida", "Error", JOptionPane.ERROR_MESSAGE);
            mostrarMenu();
        }
    }

    /**
     * Función que solicitará los datos de la mascota y la agregará a la lista de mascotas.
     * Siempre que haya espacio disponible.
     */
    private void agregarMascota() {
        // Creamos nuestra variable de control de agregación
        boolean mascotaAgregada = false;
        // Creamos nuestras variables locales de los datos de la mascota
        String nombre, especie, estadoSalud;
        int edad;
        // Recorremos el arreglo de mascotas
        for (int i = 0; i < mascotas.length; i++) {
            // Si hay algún espacio vacio en la lista de mascotas
            if (mascotas[i] == null) {
                // Solicitamos los datos de la mascota
                nombre = JOptionPane.showInputDialog(
                        "Ingrese el nombre de la mascota:");
                especie = JOptionPane.showInputDialog(
                        "Ingrese la especie de la mascota:");
                try{
                    edad = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese la edad de la mascota:"));
                    // En el caso de la salud, usamos un Enum para restringir los valores
                    // y lo usaremos en conjunto con una ventana de selección
                    estadoSalud = JOptionPane.showInputDialog(null,
                            "Seleccione el estado de salud de la mascota:",
                            "Estado de salud", JOptionPane.QUESTION_MESSAGE,
                            null, EstadoSalud.values(), EstadoSalud.HEALTHY).toString();
                } catch (NumberFormatException e) {
                    // Manejo de la excepción de tipo NumberFormatException
                    JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    agregarMascota();
                    return;
                } catch (NullPointerException e) {
                    // Manejo de la excepción de tipo NullPointerException
                    JOptionPane.showMessageDialog(null, "Error: Seleccione un estado de salud válido", "Error", JOptionPane.ERROR_MESSAGE);
                    agregarMascota();
                    return;
                }
                // Agregamos la mascota a la lista de mascotas
                mascotas[i] = new Mascota(nombre, especie, edad, estadoSalud);
                // Mostramos un mensaje de confirmación
                JOptionPane.showMessageDialog(null,
                        "Se ha agregado la mascota.");
                // Cambiamos el estado de nuestra variable de control
                mascotaAgregada = true;
                // Una vez agregada la mascota, salimos del ciclo
                break;
            }
        }
        // En caso de que no se haya podido agregar la mascota
        if (!mascotaAgregada) {
            // Mostramos un mensaje de error
            JOptionPane.showMessageDialog(null,
                    "No se pueden agregar más mascotas.");
        }
        // Regresamos al menú principal
        mostrarMenu();
    }

    /**
     * Función que solicitará los datos del veterinario y lo agregará a la lista de veterinarios.
     * Siempre que haya espacio disponible.
     */
    private void registrarVeterinario() {
        boolean veterinarioRegistrado = false;
        String nombre;
        int id;
        for (int i = 0; i < veterinarios.length; i++) {
            if (veterinarios[i] == null) {
                nombre = JOptionPane.showInputDialog(
                        "Ingrese el nombre del veterinario:");
                try{
                    id = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese el ID del veterinario:"));
                } catch (NumberFormatException e) {
                    // Manejo de la excepción de tipo NumberFormatException
                    JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    registrarVeterinario();
                    return;
                }
                veterinarios[i] = new Veterinario(nombre, id);
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado el veterinario.");
                veterinarioRegistrado = true;
                break;
            }
        }
        if (!veterinarioRegistrado) {
            JOptionPane.showMessageDialog(null,
                    "No se pueden registrar más veterinarios.");
        }
        mostrarMenu();
    }

    /**
     * Función que mostrará la información de las mascotas registradas.
     */
    private void mostrarInfoMascotas() {
        
        // Mostramos un mensaje para iniciar la lista
        JOptionPane.showMessageDialog(null,
                "Mascotas registradas:");
        // Recorremos la lista de mascotas
        for (Mascota mascota : this.mascotas) {
            // Si la mascota no es null, mostramos su información
            if (mascota != null) {
                // Invocamos el método de la clase Mascota
                mascota.mostrarInfo();
            }
        }
        // Regresamos al menú principal
        mostrarMenu();
    }

    /**
     * Función que mostrará la información de los veterinarios registrados.
     */
    private void mostrarInfoVeterinarios() {

        JOptionPane.showMessageDialog(null,
                "Veterinarios registrados:");
        for (Veterinario veterinario : this.veterinarios) {
            if (veterinario != null) {
                veterinario.mostrarInfo();
            }
        }
        mostrarMenu();
    }

    /**
     * Función que mostrará dos listas desplegables para seleccionar una mascota y un veterinario.
     * Además de una lista desplegable para seleccionar el estado de salud de la mascota.
     */
    private void atenderMascota() {
    
        Mascota mascota = null;
        Veterinario veterinario = null;
        String estadoSalud;
        try{
            // Mostramos las listas desplegables para seleccionar la mascota y el veterinario
            mascota = (Mascota) JOptionPane.showInputDialog(null,
                    "Seleccione la mascota a atender:",
                    "Mascotas", JOptionPane.QUESTION_MESSAGE,
                    null, this.mascotas, this.mascotas[0]);
            veterinario = (Veterinario) JOptionPane.showInputDialog(null,
                    "Seleccione el veterinario que atenderá a la mascota:",
                    "Veterinarios", JOptionPane.QUESTION_MESSAGE,
                    null, this.veterinarios, this.veterinarios[0]);
            // Mostramos la lista desplegable para seleccionar el estado de salud de la mascota
            estadoSalud = JOptionPane.showInputDialog(null,
                    "Seleccione el estado de salud de la mascota:",
                    "Estado de salud", JOptionPane.QUESTION_MESSAGE,
                    null, EstadoSalud.values(), EstadoSalud.HEALTHY).toString();
        } catch (NullPointerException e) {
            // Manejo de la excepción de tipo NullPointerException
            JOptionPane.showMessageDialog(null, "Error: Seleccione una mascota, veterinario y estado de salud válidos", "Error", JOptionPane.ERROR_MESSAGE);
            atenderMascota();
        }
        // Atendemos a la mascota con el veterinario seleccionado
        veterinario.atenderMascota(mascota, estadoSalud);
        // Regresmos al menú principal
        mostrarMenu();
    }
}
```

## Conclusiones

En este ejemplo hemos aprendido cómo manejar excepciones en Java para evitar que nuestro programa se bloquee o se cierre
inesperadamente. Hemos utilizado bloques `try-catch` para capturar y manejar excepciones específicas en diferentes
partes de nuestro código, permitiendo al usuario seleccionar opciones válidas y corrigiendo errores de entrada de datos.

El manejo de excepciones es una parte importante de la programación en Java y nos permite escribir código robusto y
confiable que puede manejar situaciones inesperadas de forma elegante y controlada.

Para más información sobre el manejo de excepciones en Java, se recomienda consultar la documentación oficial de Java en
el siguiente enlace: [Java Documentation](https://docs.oracle.com/en/java/).