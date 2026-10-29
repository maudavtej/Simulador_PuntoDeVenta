# Simulador_PuntoDeVenta
PROYECTO DE PROGRAMACIÓN ORIENTADA A OBJETOS DE  FIN DE CURSO


*Sistema de facturación e inventario para una tienda de productos tecnológicos o de consumo general*

## DESCRIPCIÓN DEL PROYECTO
Este proyecto implementa un sistema para la gestión de productos, ventas y emisión de facturas. El proyecto tiene como objetivo principal aplicar los pilares de la Programación Orientada a Objetos (POO) vistos a lo largo del curso

### Conceptos de POO Aplicados
Abstracción: Definición de entidades principales como backend.Producto, Factura, Cliente e Inventario, modelando solo sus atributos y comportamientos relevantes.
Encapsulamiento: Protección de datos mediante atributos privados (private) y acceso controlado a través de métodos getters y setters, asegurando la validación de datos.
Herencia: Especialización de clases (ejemplo: ProductoElectronico y ProductoAlimenticio heredando de una clase base backend.Producto).
Polimorfismo: Implementación de comportamientos específicos mediante sobreescritura de métodos
Interfaces y Clases Abstraíbles
### Funcionalidades Principales
* Gestión de Inventario: Alta, baja, modificación y consulta de productos con stock disponible.
* Gestión de backend.Ventas: Registro de clientes, selección de productos y generación de carritos de compra.
* Facturación: Cálculo de subtotal, impuestos (IVA), descuentos aplicables y total a pagar.
* Alertas de Stock: Notificación cuando un producto está por debajo del stock mínimo.
* Reportes: Generación de resúmenes de ventas o historial de facturas emitidas.
### Tecnologías y Herramientas
Lenguaje: Java (JDK 17 o superior)
Entorno de Desarrollo (IDE): IntelliJ IDEA
Gestión de Versiones: Git & GitHub
