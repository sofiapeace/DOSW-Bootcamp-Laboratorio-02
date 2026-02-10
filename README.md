# DOSW-Bootcamp-Laboratorio-02

## Integrantes
-Gina Sofia Garcia
-Juan Diego Patiño

---

## Retos completados

---

### Reto 1: El problema de la tienda de Don Pepe

**Evidencia:**
![captura](./imagenesretos/reto1sol.png)

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



**Descripción:**

### - Categoría:


### - Patrón:

### - Justificación:


### - Como se aplico:

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