# Actividad 4: El zoológico de animales

## Descripción

En esta actividad en Java, vamos a crear un programa que simule un zoológico de animales. Para ello, vamos a crear una
clase `Animal` que tenga los siguientes atributos:

- `nombre`: El nombre del animal.
- `edad`: La edad del animal.
- `especie`: La especie del animal.
- `peso`: El peso del animal.
- `altura`: La altura del animal.
- `color`: El color del animal.
- `sexo`: El sexo del animal.

Además, la clase `Animal` debe tener los siguientes métodos:

- Un constructor que inicialice los atributos de la clase.
- Un método `comer` que reciba como parámetro la cantidad de comida que el animal va a comer y que incremente el peso
  del animal en función de la cantidad de comida.
- Un método `crecer` que incremente la edad del animal en un año y la altura en 10 cm.
- Un método `dormir` que haga que el animal descanse y que disminuya su peso en 1 kg.
- Un método `hablar` que haga que el animal emita un sonido característico de su especie.
- Un método `mostrar_informacion` que muestre en pantalla la información del animal.

De esta clase deberás crear al menos 4 subclases que representen diferentes tipos de animales (por ejemplo, `Perro`,
`Gato`, `Pez`, `Ave`, etc.). Cada subclase debe tener un método `hablar` que emita un sonido característico de su
especie.

Por último, crea una clase `Zoologico` que tenga un atributo `animales` que sea una lista de animales. La clase
contendrá los siguientes métodos:

- Un método `agregar_animal` que reciba un animal y lo agregue a la lista de animales.
- Un método `alimentar_animales` que reciba la cantidad de comida que se va a dar a los animales y que haga que cada
  animal coma.
- Un método `crecer_animales` que haga que cada animal crezca.
- Un método `dormir_animales` que haga que cada animal duerma.
- Un método `mostrar_animales` que muestre en pantalla la información de cada animal.
- Un método `hacer_sonar_animales` que haga que cada animal emita un sonido característico de su especie.
- Un método `mostrar_informacion` que muestre en pantalla la información de cada animal.
- Un método `mostrar_informacion` que muestre en pantalla la información de cada animal.

Toma en cuenta un límite de comida que puede comer un animal, así como un límite de peso y altura, siguiendo la
siguiente tabla:

| Especie | Límite de comida | Límite de peso | Límite de altura |
|---------|------------------|----------------|------------------|
| Perro   | 1 kg             | 50 kg          | 1 m              |
| Gato    | 0.5 kg           | 10 kg          | 0.5 m            |
| Pez     | 0.1 kg           | 0.5 kg         | 0.1 m            |
| Ave     | 0.2 kg           | 1 kg           | 0.2 m            |

Así mismo, cada animal debe tener un límite de edad de 20 años. Si un animal supera su límite de edad, debe morir y ser
eliminado de la lista de animales, tomando en cuenta un total de 10 animales en el zoológico.

## Requisitos

1. Crea una clase `Animal` con los atributos y métodos mencionados.
2. Crea al menos 4 subclases de `Animal` que representen diferentes tipos de animales.
3. Crea una clase `Zoologico` con los métodos mencionados.
4. Crea un programa que simule un zoológico de animales.
5. Realiza pruebas con diferentes tipos de animales.
6. Realiza pruebas con diferentes cantidades de comida. Y guarda las capturas de pantalla de las pruebas realizadas.
7. Documenta tu código con comentarios que expliquen cada método y atributo.
8. Comprime tu proyecto en un archivo .zip y sube el archivo a la plataforma.

## Critrerios de evaluación

| Criterio               | Descripción                                                                                         | Puntaje  |
|------------------------|-----------------------------------------------------------------------------------------------------|----------|
| Portada                | El archivo contiene una portada con los datos del equipo.                                           | 5%       |
| Código                 | El código cumple con los requisitos solicitados.                                                    | 40%      |
| Diagrama de clases     | El diagrama de clases es correcto.                                                                  | 10%      |
| Modularidad del Código | El código está organizado en clases y archivos diferentes, además de contar con métodos coherentes. | 10%      |
| Pruebas                | Se realizaron pruebas con diferentes tipos de animales.                                             | 20%      |
| Documentación          | El código está debidamente documentado.                                                             | 10%      |
| Formato                | El archivo cumple con el formato solicitado.                                                        | 5%       |
| **Total**              |                                                                                                     | **100%** |

> **La evaluación se realizará con base en los criterios establecidos en la rúbrica. Se considerará la claridad,
> organización, comentarios y estilo del código, así como la calidad de la documentación. Además, se tomará en cuenta
> el cumplimiento de los requerimientos y la funcionalidad del programa.**
> {style="note"}

> **Actividad entregada en lenguaje distinto a Java o sin el uso de clases y objetos, así como de modularidad, no será
> evaluada.**
> {style="warning"}

## Fecha de Entrega

Lunes 31 de marzo de 2025, 11:59 p.m. (medianoche)

> **Trabajos entregados después de la fecha y hora límite serán calificados sobre 70 puntos.**
> {style="warning"}