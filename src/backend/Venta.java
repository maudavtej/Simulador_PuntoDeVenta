package backend;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    //=============================================================================
    //ATRIBUTOS
    private int idVenta;
    private LocalDateTime fecha;
    private String nombreCliente;
    private List<LineaVenta> lineas;   //Carrito
    private double descuento;          //PORCENTAJE DE 0 A 100
    private MetodoPago metodoPago;
    private double montoPagado;
    private boolean pagada;

    //=============================================================================
    //CONSTRUCTOR: LA VENTA NACE VACÍA Y SIN PAGAR
    public Venta(int idVenta, String nombreCliente) {
        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío");
        }
        this.idVenta = idVenta;
        this.nombreCliente = nombreCliente;
        this.fecha = LocalDateTime.now();
        this.lineas = new ArrayList<>();
        this.descuento = 0;
        this.montoPagado = 0;
        this.pagada = false;
    }

    //=============================================================================
    //GETTERS Y SETTERS
    public int getIdVenta() {
        return idVenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public List<LineaVenta> getLineas() {
        return lineas;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        if (descuento < 0 || descuento > 100) {
            throw new IllegalArgumentException("El descuento debe ser entre 0 y 100");
        }
        this.descuento = descuento;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public boolean isPagada() {
        return pagada;
    }

    //=============================================================================
    //AGREGAR PRODUCTO AL CARRITO
    public void agregarProducto(Producto producto, int cantidad) {
        if (pagada) {
            throw new IllegalStateException("La venta ya fue hecha");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
        }
        if (cantidad > producto.getStock()) {
            throw new IllegalArgumentException("Stock insuficiente");
        }
        lineas.add(new LineaVenta(producto, cantidad));
    }

    //=============================================================================
    //CÁLCULOS
    public double calcularSubtotal() {
        double subtotal = 0;
        for (LineaVenta linea : lineas) {
            subtotal = subtotal + linea.getSubtotal();
        }
        return subtotal;
    }

    public double calcularTotal() {
        double subtotal = calcularSubtotal();
        return subtotal - (subtotal * descuento / 100);
    }

    //AQUÍ SOLO SE SEPARA CUÁNTO ES
    public double calcularIVA() {
        double total = calcularTotal();
        return total - (total / Producto.IVA);
    }

    //=============================================================================
    //PROCESAR PAGO

    // RECIBE EL DINERO Y DEVUELVE EL CAMBIO
    public double procesarPago(double montoRecibido) {
        if (pagada) {
            throw new IllegalStateException("La venta ya fue hecha");
        }
        if (lineas.isEmpty()) {
            throw new IllegalStateException("El carrito está vacío");
        }
        double total = calcularTotal();
        if (montoRecibido < total) {
            throw new IllegalArgumentException("El monto no alcanza para pagar");
        }
        //DESCUENTA EL STOCK DE CADA PRODUCTO VENDIDO
        for (LineaVenta linea : lineas) {
            Producto p = linea.getProducto();
            p.setStock(p.getStock() - linea.getCantidad());
        }
        this.metodoPago = MetodoPago.EFECTIVO;
        this.montoPagado = montoRecibido;
        this.pagada = true;
        return montoRecibido - total;
    }

    //TARJETA: RECIBE NÚMERO DE TARJETA Y TITULAR
    public boolean procesarPago(String numeroTarjeta, String titular) {
        if (pagada) {
            throw new IllegalStateException("La venta ya fue hecha");
        }
        if (lineas.isEmpty()) {
            throw new IllegalStateException("El carrito está vacío");
        }
        if (numeroTarjeta == null || numeroTarjeta.length() != 16) {
            throw new IllegalArgumentException("El número de tarjeta debe tener 16 dígitos");
        }
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("El titular no puede estar vacío");
        }
        for (LineaVenta linea : lineas) {
            Producto p = linea.getProducto();
            p.setStock(p.getStock() - linea.getCantidad());
        }
        this.metodoPago = MetodoPago.TARJETA;
        this.montoPagado = calcularTotal();
        this.pagada = true;
        return true;
    }

    //TRANSFERENCIA: RECIBE CLAVE DE RASTREO, BANCO Y MONTO
    public boolean procesarPago(String claveRastreo, String banco, double monto) {
        if (pagada) {
            throw new IllegalStateException("La venta ya fue hecha");
        }
        if (lineas.isEmpty()) {
            throw new IllegalStateException("El carrito está vacío");
        }
        if (claveRastreo == null || claveRastreo.trim().isEmpty()) {
            throw new IllegalArgumentException("La clave de rastreo no puede estar vacía");
        }
        if (banco == null || banco.trim().isEmpty()) {
            throw new IllegalArgumentException("El banco no puede estar vacío");
        }
        if (monto < calcularTotal()) {
            throw new IllegalArgumentException("El monto no alcanza para pagar");
        }
        for (LineaVenta linea : lineas) {
            Producto p = linea.getProducto();
            p.setStock(p.getStock() - linea.getCantidad());
        }
        this.metodoPago = MetodoPago.TRANSFERENCIA;
        this.montoPagado = monto;
        this.pagada = true;
        return true;
    }
}