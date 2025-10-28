# La clase HashMap en Java

La clase `HashMap` en Java es una implementación de la interfaz `Map` que utiliza una tabla hash para almacenar pares
clave-valor. Es parte del paquete `java.util` y es ampliamente utilizada debido a su eficiencia en operaciones de
búsqueda, inserción y eliminación.

## Características principales

- **Almacenamiento de pares clave-valor**: Cada elemento en un `HashMap` se almacena como un par de clave y valor.
  Las claves deben ser únicas, mientras que los valores pueden repetirse.
- **Permite valores nulos**: Tanto las claves como los valores pueden ser `null`.
- **No ordenado**: Los elementos en un `HashMap` no tienen un orden específico. Si se necesita un orden, se puede usar
  `LinkedHashMap` o `TreeMap`.
- **No es sincronizado**: `HashMap` no es seguro para el acceso concurrente. Si se necesita sincronización, se puede
  usar `Collections.synchronizedMap()` o `ConcurrentHashMap`.
- **Capacidad y factor de carga**: La capacidad inicial por defecto es 16 y el factor de carga por defecto es 0.75,
  lo que proporciona un buen equilibrio entre el uso de memoria y el rendimiento.
- **Redimensionamiento automático**: Cuando el número de elementos supera el umbral (capacidad * factor de carga), el
  `HashMap` se redimensiona automáticamente para mantener un rendimiento óptimo.
- **Complejidad de tiempo**: Las operaciones básicas como `get()`, `put()` y `remove()` tienen una complejidad de tiempo
  promedio de O(1), aunque en el peor de los casos puede ser O(n) si hay muchas colisiones.

## Ejemplo de uso

```java
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // Crear un HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Agregar pares clave-valor
        map.put("Uno", 1);
        map.put("Dos", 2);
        map.put("Tres", 3);

        // Obtener un valor por su clave
        int value = map.get("Dos");
        System.out.println("El valor asociado a 'Dos' es: " + value);

        // Eliminar un par clave-valor
        map.remove("Tres");

        // Verificar si una clave existe
        boolean containsKey = map.containsKey("Uno");
        System.out.println("¿El mapa contiene la clave 'Uno'? " + containsKey);

        // Iterar sobre las entradas del HashMap
        for (String key : map.keySet()) {
            System.out.println("Clave: " + key + ", Valor: " + map.get(key));
        }
    }
}
```

## Funciones comunes

| Método                               | Descripción                                                                            |
|--------------------------------------|----------------------------------------------------------------------------------------|
| `put(K key, V value)`                | Agrega un par clave-valor al mapa.                                                     |
| `get(Object key)`                    | Devuelve el valor asociado a la clave especificada.                                    |
| `getIfAbsent(K key, V defaultValue)` | Devuelve el valor asociado a la clave o el valor predeterminado si la clave no existe. |
| `remove(Object key)`                 | Elimina el par clave-valor asociado a la clave.                                        |
| `containsKey(Object key)`            | Verifica si el mapa contiene la clave especificada.                                    |
| `containsValue(Object value)`        | Verifica si el mapa contiene el valor especificado.                                    |
| `size()`                             | Devuelve el número de pares clave-valor en el mapa.                                    |
| `clear()`                            | Elimina todos los pares clave-valor del mapa.                                          |
| `keySet()`                           | Devuelve un conjunto de todas las claves en el mapa.                                   |
| `values()`                           | Devuelve una colección de todos los valores en el mapa.                                |
| `entrySet()`                         | Devuelve un conjunto de todas las entradas (pares clave-valor) en el mapa.             |

## Conclusión

La clase `HashMap` es una herramienta poderosa y eficiente para almacenar y gestionar datos en Java. Su capacidad
para manejar grandes cantidades de datos con rapidez la convierte en una opción popular para desarrolladores que
necesitan una estructura de datos flexible y eficiente.