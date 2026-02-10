# DOSW-Bootcamp-Laboratorio-02

## Integrantes
-Gina Sofia Garcia
-Juan Diego Patiño

---

## Retos completados

---

### Reto 1: El problema de la tienda de Don Pepe

**Evidencia:**
![captura]("./imagenesretos/reto1sol.png")

**Descripción:**
El reto de la tienda de Don Pepe consiste en crear un sistema de ventas sencillo donde se agregue productos a un carrito de compras, recibaun descuento segun el tipo de cliente y que obtenga un recibo al finalizar la compra pero el recibo debe mostrar ciertas especificaciones. 
Ahora para entender mas se realizaron las siguientes aplicaciones en el codigo para poder llevarlo de una manera limpia y organizada cumpliendo los requisitos del reto.

### Encapsulamiento
Hemos protegido la integridad de los datos utilizando:
Atributos Privados: Los datos de Producto y Cliente no pueden ser modificados desde fuera de la clase.
Inmutabilidad: Uso de la palabra clave final para asegurar que el precio y el nombre no cambien una vez creados.
Métodos Getter: Solo permitimos la lectura controlada de la información necesaria.

### Polimorfismo
Se aplica mediante el Patrón Strategy en la gestión de descuentos:
Tratamos a ClienteNuevo y ClienteFrecuente como un objeto genérico de tipo Cliente.
El sistama decide en tiempo de ejecución qué lógica de descuento aplicar (5% o 10%) sin necesidad de usar condicionales if/else complejos.

### Aplicación de los principios SOLID:

### S – Single Responsibility Principle: 
Cada clase tiene un solo motivo para cambiar (ej. Carrito solo gestiona la lista de items).

### O – Open/Closed Principle
Podemos agregar nuevos tipos de descuento (ej. VIP) creando una nueva clase sin tocar el código existente.

### L – Liskov Substitution Principle
Cualquier subclase de Cliente puede ser usada por el Carrito sin alterar su funcionamiento.

### I – Interface Segregation Principle (Segregación de Interfaces)
Las clases son pequeñas y específicas, evitando métodos innecesarios.

### D – Dependency Inversion Principle
El Carrito depende de la abstracción Cliente, no de una implementación específica.

### Reto 2: El chef de 5 estrellas

**Evidencia:**
![Captura](./imagenretos/reto2sol.png)

**Descripción:**
El objetivo de este reto es simular un sistema de preparación de hamburguesas personalizadas. El sistema debe permitir:

Personalización total: El cliente puede elegir qué ingredientes desea incluir (Pan, Carne, Queso, etc.).

Flexibilidad: Los ingredientes no son obligatorios; la hamburguesa se construye paso a paso según la elección del usuario.

Cálculo Dinámico: Utilizar el poder de los Java Streams para calcular el precio total de la combinación seleccionada y generar la lista final de ingredientes.

### - Categoría:
Estructural

### - Patrón: 
Composite

### - Justificación:
Se eligió el patrón Composite porque permite tratar objetos individuales (como un ingrediente simple: carne, queso) y objetos compuestos (la hamburguesa final que contiene varios ingredientes) de manera uniforme a través de una interfaz común. Esto facilita el cumplimiento del requerimiento de "construir paso a paso", ya que la hamburguesa actúa como un contenedor que delega el cálculo del precio y la obtención de nombres a los elementos que tiene dentro.

### - Como se aplico:
1. Componente (Ingrediente.java): Es una interfaz que define los métodos getNombre() y getPrecio().

2. Hoja (IngredienteIndividual.java): Representa los ingredientes básicos con sus respectivos costos.

3. Compuesto (Hamburguesa.java): Clase que contiene una lista de objetos Ingrediente. Implementa el cálculo del precio total utilizando Java Streams (mapToDouble().sum()) y genera el resumen de ingredientes con Collectors.joining().

4. Ejecución (Reto2.java): Permite al usuario interactuar mediante un menú para agregar dinámicamente "Hojas" al "Compuesto", mostrando el resultado final de forma integrada.

### Reto 3: El Reino de los Vehiculos

**Evidencia:**
**Descripción:**

---

### Reto 4: La Estafa de la Casa de Cambio

**Evidencia:**
**Descripción:**

---

### Reto 5: El Café Personalizado

**Evidencia:**
**Descripción:**

---

### Reto 6: Habla con Soporte Técnico

**Evidencia:**
**Descripción:**

---

### Reto 7: El Control Remoto Mágico

**Evidencia:**

**Descripción:**



### Categoría del patrón de diseño



### Patrón Utilizado



### Justificación



### ¿Cómo lo aplicó?



---