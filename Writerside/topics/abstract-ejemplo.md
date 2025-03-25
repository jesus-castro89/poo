# Ejemplo de implementación de clases abstractas en Java

Veamos el siguiente problema: se desea modelar un sistema de Figuras geométricas en Java. Para ello, se puede utilizar
una clase abstracta llamada `Shape` que definen los métodos abstractos `draw`, `calculateArea`, `calculatePerimeter` y
y un método concreto `showName`. Las clases que hereden de la clase `Shape` deberán implementar el método `draw` y
podrán heredar el método `showName`.

```java
public abstract class Shape {
    
    public abstract void draw();

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public void showName() {
        System.out.println("Shape");
    }
}
```

A continuación, se muestra un ejemplo de una clase `Circle` que hereda de la clase `Shape` y sobrescribe los métodos
`draw`, `calculateArea` y `calculatePerimeter`.

```java
public class Circle extends Shape {
    
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
```

En el ejemplo anterior, la clase `Circle` hereda de la clase `Shape` y sobrescribe los métodos `draw`, `calculateArea` y
`calculatePerimeter` para implementar la funcionalidad específica de un círculo. La clase `Circle` también hereda el
método `showName` de la clase `Shape`. Y por último agrega su propio atributo `radius` y un constructor para
inicializarlo.

Similarmente, se puede definir una clase `Rectangle` que hereda de la clase `Shape` y sobrescribe los métodos `draw`,
`calculateArea` y `calculatePerimeter`.

```java
public class Rectangle extends Shape {
    
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}
```

En este caso, la clase `Rectangle` hereda de la clase `Shape` y sobrescribe los métodos `draw`, `calculateArea` y
`calculatePerimeter` para implementar la funcionalidad específica de un rectángulo. La clase `Rectangle` también hereda
el método `showName` de la clase `Shape`. Y por último agrega sus propios atributos `width` y `height` y un constructor
para inicializarlos.

De esta forma, se puede utilizar la clase `Shape` como una estructura base para definir las operaciones comunes a todas
las figuras geométricas y las clases hijas pueden implementar la funcionalidad específica de cada figura.

En resumen, las clases abstractas son una herramienta poderosa para definir una estructura base que será heredada por
otras clases. Permiten definir métodos abstractos que deben ser implementados por las clases hijas y métodos concretos
que pueden ser heredados o sobrescritos según sea necesario. Las clases abstractas son una forma efectiva de modelar
jerarquías de clases en Java y facilitan la reutilización de código y la implementación de polimorfismo.