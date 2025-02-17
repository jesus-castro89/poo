# Ejemplo 1: La Veterinaria

Para el siguiente ejemplo tomemos como referencia lo solicitado a continuación:

Sistema de Gestión de una Clínica Veterinaria
Eres el desarrollador de un sistema para una clínica veterinaria. Debes crear un programa que permita gestionar mascotas
y veterinarios. Los veterinarios pueden atender a las mascotas y registrar su estado de salud. El sistema debe mostrar
un menú con opciones para agregar mascotas, registrar veterinarios, atender mascotas y mostrar información.

## Clases y Funcionalidades:

* **Clase Mascota**:
    * Atributos: nombre, especie, edad, estadoSalud.
    * Métodos: mostrarInformacion(), actualizarEstadoSalud(String estado).
* **Clase Veterinario**:
    * Atributos: nombre, id, mascotasAtendidas (lista de mascotas).
    * Métodos: mostrarInformacion(), atenderMascota(Mascota mascota, String estadoSalud).
* **Clase Clinica**:
    * Atributos: mascotas (lista de mascotas), veterinarios (lista de veterinarios).
    * Métodos: agregarMascota(Mascota mascota), registrarVeterinario(Veterinario veterinario), mostrarMenu().

## Menú:

1. Agregar mascota
2. Registrar veterinario
3. Atender mascota
4. Mostrar información de mascotas
5. Mostrar información de veterinarios
6. Salir

## Interacción:

El menú se muestra en un bucle hasta que el usuario elija "Salir". Cada opción del menú llama a los métodos
correspondientes de la clase ClinicaVeterinaria.

## Resolviendo el problema

Primero que nada, deberemos de trabajar con las clases que se nos solicitan, pero de igual manera deberemos de
analizarlas para poder entender cómo se comportarán en el sistema.

### Clase Mascota

Dentro de la clase máscota existe un atributo llamado `estadoSalud` que nos permitirá saber el estado de salud de la
máscota, además de tener un método llamado `actualizarEstadoSalud(String estado)` que nos permitirá actualizar el
estado de salud de la máscota.

Sin embargo, el atributo `estadoSalud` no nos especifica un tipo de datos en concreto, y pese a que la función solicita
un String, podemos trabajar con `Enums` para restringir los posibles valores a introducir por parte del usuario de la
siguiente manera:

**EstadoSalud.java**

```java
package veterinaria;

public enum EstadoSalud {

    HEALTHY("Saludable"),
    SICK("Enfermo"),
    RECOVERING("Recuperándose"),
    DEAD("Muerto");

    /**
     * Atributo que representa la etiqueta de texto de cada estado de
     * salud posible.
     */
    private final String name;

    /**
     * Constructor de la clase EstadoSalud.
     */
    EstadoSalud(String name) {
        this.name = name;
    }

    /**
     * Función que devuelve el nombre del estado de salud.
     */
    public String getName() {
        return name;
    }

    /**
     * Función que transforma el estado de salud en un String.
     * Es usado por las listas deplegables y otros componentes.
     */
    @Override
    public String toString() {
        return getName();
    }
}
```

Con lo anterior, podemos trabajar con un tipo de dato más específico y restringir los valores que se pueden introducir
en el sistema.

Posteriormente, podemos trabajar con la clase `Mascota` de la siguiente manera:

**Mascota.java**

```java
package veterinaria;

import javax.swing.*;

public class Mascota {

    private String nombre;
    private String especie;
    private int edad;
    private String estadoSalud;

    /**
     * Constructor de la clase Mascota.
     */
    public Mascota(String nombre, String especie, int edad, String estadoSalud) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.estadoSalud = estadoSalud;
    }

    /**
     * Función que crea una ventana flotante con los datos de la mascota.
     */
    public void mostrarInfo() {
    
        JOptionPane.showMessageDialog(null,
                String.format("""
                        Nombre: %s
                        Especie: %s
                        Edad: %d
                        Estado de salud: %s
                        """, nombre, especie, edad, estadoSalud));
    }

    // Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }
    
    // Función de la clase
    /**
     * Función que convierte un objeto de tipo Mascota en un texto
     */
    @Override
    public String toString() {
        return nombre;
    }
}
```

Como te habrás dado cuenta, el atributo `estadoSalud` sigue siendo un `String`, esto debido a la funcionalidad
solicitada, pero gracias el tipo enumerado podemos restringir los valores que se pueden introducir en el sistema.

### Clase Veterinario

Dentro de la clase Veterinario, existe un atributo llamado `mascotasAtendidas` que nos permitirá saber cuántas
máscotas ha atendido el veterinario, además de tener un método llamado
`atenderMascota(Mascota mascota, String estadoSalud)` que nos permitirá atender a la máscota y actualizar su estado
de salud.

**Veterinario.java**

```java
package veterinaria;

import javax.swing.*;

public class Veterinario {

    private String nombre;
    private int id;
    private Mascota[] mascotasAtendidas;

    /**
     * Constructor de la clase Veterinario.
     */
    public Veterinario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.mascotasAtendidas = new Mascota[5];
    }

    /**
     * Función que crea una ventana flotante con los datos del veterinario.
     * Además de incluir los datos de las mascotas atendidas.
     */
    public void mostrarInfo() {
        String mascotas = "";
        // Recorremos el arreglo de mascotas
        for (Mascota mascota : mascotasAtendidas) {
            // Si alguna mascota de la lista no es null, recuperaremos sus datos
            if (mascota != null) {
                mascotas += String.format("""
                                +++++++++++++++++++++++++++++++
                                Nombre: %s - Especie: %s
                                Edad: %d - Estado de salud: %s
                                +++++++++++++++++++++++++++++++
                                """, mascota.getNombre(),
                        mascota.getEspecie(), mascota.getEdad(),
                        mascota.getEstadoSalud());
            }
        }
        // Mostramos los datos del veterinario y las mascotas atendidas
        String mensaje = String.format("""
                Nombre: %s
                ID: %d
                Mascotas atendidas:
                %s
                """, nombre, id, mascotas);
        // Mostramos la ventana flotante con el mensaje anterior
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /**
     * Función que atiende a una mascota y actualiza su estado de salud.
     */
    public void atenderMascota(Mascota mascota, String estadoSalud) {
        // Creamos una variable local para saber si fue posible antender a la mascota
        boolean mascotaAtendida = false;
        // Recorremos el arreglo de mascotas atendidas
        for (Mascota currentMascota : mascotasAtendidas) {
            // Verificamos si el nombre de la mascota a tender coincide con el de la mascota actual de la lista.
            if (currentMascota != null &&
                    currentMascota.getNombre().equals(mascota.getNombre())) {
                // Si coincide, hacemos que la variable de control sea true
                mascotaAtendida = true;
                // Actualizamos el estado de salud de la mascota
                currentMascota.setEstadoSalud(estadoSalud);
                // Mostramos un mensaje de confirmación
                JOptionPane.showMessageDialog(null,
                        "Se ha actualizado el estado de salud de la mascota.");
            }
        }
        // En caso de que no existe la mascota a buscar en la lista de mascotas atendidas
        if (!mascotaAtendida) {
            // Recorremos nuevamente el arreglo, pero esta vez sin usar
            // el foreach ya que lo que queremos es crear un objeto de tipo Mascota
            for (int i = 0; i < mascotasAtendidas.length; i++) {
                // Si queda espacio en la lista de mascotas atendidas
                if (mascotasAtendidas[i] == null) {
                    // Asignamos la mascota a la lista de mascotas atendidas
                    mascotasAtendidas[i] = mascota;
                    // Actualizamos el estado de salud de la mascota
                    mascotasAtendidas[i].setEstadoSalud(estadoSalud);
                    // Mostramos un mensaje de confirmación
                    JOptionPane.showMessageDialog(null,
                            "Se ha atendido a la mascota.");
                    break;
                }
            }
        }
    }
    
    @Override
    public String toString() {
        return nombre;
    }

    // Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mascota[] getMascotasAtendidas() {
        return mascotasAtendidas;
    }

    public void setMascotasAtendidas(Mascota[] mascotasAtendidas) {
        this.mascotasAtendidas = mascotasAtendidas;
    }
}
```

### Enumerado MenuOption

Para poder trabajar con las opciones del menú, podemos trabajar con un enumerado que nos permita tener un control
sobre las opciones disponibles.

**MenuOption.java**

```java
package veterinaria;

public enum MenuOption {

    REGISTER_PET("Agregar mascota"),
    REGISTER_VET("Registrar veterinario"),
    ATTEND_PET("Atender mascota"),
    SHOW_PET("Mostrar mascotas"),
    SHOW_VET("Mostrar veterinarios"),
    EXIT("Salir");

    private final String name;

    MenuOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
```

### Clase Clinica

Dentro de la clase Clínica, existen dos atributos llamados `mascotas` y `veterinarios` que nos permitirán saber cuántas
máscotas y veterinarios hay en la clínica, además de tener un método llamado `mostrarMenu()` que nos permitirá mostrar
un menú con las opciones disponibles.

**Clinica.java**

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
                edad = Integer.parseInt(JOptionPane.showInputDialog(
                        "Ingrese la edad de la mascota:"));
                // En el caso de la salud, usamos un Enum para restringir los valores
                // y lo usaremos en conjunto con una ventana de selección
                estadoSalud = JOptionPane.showInputDialog(null,
                        "Seleccione el estado de salud de la mascota:",
                        "Estado de salud", JOptionPane.QUESTION_MESSAGE,
                        null, EstadoSalud.values(), EstadoSalud.HEALTHY).toString();
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
                id = Integer.parseInt(JOptionPane.showInputDialog(
                        "Ingrese el ID del veterinario:"));
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
        // Regresmos al menú principal
        mostrarMenu();
    }
}
```

### Main

Finalmente, podemos trabajar con la clase principal que nos permitirá ejecutar el sistema.

**Main.java**

```java
package veterinaria;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        UIManager.put("OptionPane.messageFont",
                new Font("Arial", Font.BOLD, 24));
        UIManager.put("OptionPane.buttonFont",
                new Font("Arial", Font.BOLD, 24));
        UIManager.put("TextField.font",
                new Font("Arial", Font.PLAIN, 24));
        UIManager.put("ComboBox.font",
                new Font("Arial", Font.BOLD, 24));
        Clinica c = new Clinica();
        c.mostrarMenu();
    }
}
```

Con lo anterior, hemos logrado crear un sistema que nos permitirá gestionar mascotas y veterinarios en una clínica
veterinaria.