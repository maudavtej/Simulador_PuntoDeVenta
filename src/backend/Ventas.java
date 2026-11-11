package backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ventas {
    private int idVenta;
    private LocalDate fecha;
    private double descuento;
    private Metodopago metodoPago;
    private double montoPagado;
    private boolean pagada;
    private final List<LineaVenta> lineas = new ArrayList<>();

    public Ventas(int idVenta, LocalDate fecha, double descuento,
            Metodopago metodoPago) {
        setIdVenta(idVenta);
        setFecha(fecha);
        setDescuento(descuento);
        if (metodoPago == null) {
            throw new IllegalArgumentException("Método de pago requerido");
        }
        this.metodoPago = metodoPago;
        this.montoPagado = 0;
        this.pagada = false;
    }

    // ===============================================================
    // LÍNEAS
    public void agregarLinea(Producto producto, int cantidad) {
        // Si el producto ya está en la venta, aumenta el stock
        for (LineaVenta lv : lineas) {
            if (lv.getProducto().getCodigo().equals(producto.getCodigo())) {
                lv.setCantidad(lv.getCantidad() + cantidad);
                return;
            }
        }
        lineas.add(new LineaVenta(producto, cantidad));
    }

    public void eliminarLinea(String codigoProducto) {
        lineas.removeIf(lv -> lv.getProducto().getCodigo().equals(codigoProducto));
    }

    public List<LineaVenta> getLineas() {
        return Collections.unmodifiableList(lineas);
    }

    // ============================================================
    // TOTALES
    public double getSubtotal() {
        double suma = 0;
        for (LineaVenta lv : lineas) suma += lv.getSubtotal();
        return suma;
    }

    public double getTotal() {
        return getSubtotal() * (1 - descuento);
    }

    public double getCambio() {
        return Math.max(0, montoPagado - getTotal());
    }

    // =========================================================
    // GETTERS
    public int getIdVenta() { return idVenta; }
    public LocalDate getFecha() { return fecha; }
    public double getDescuento() { return descuento; }
    public Metodopago getMetodoPago() { return metodoPago; }
    public double getMontoPagado() { return montoPagado; }
    public boolean isPagada() { return pagada; }

    // =========================================================
    // SETTERS
    public void setIdVenta(int idVenta) {
        if (!Regexp.numerosValidos(idVenta)) {
            throw new IllegalArgumentException("Ingrese un ID válido");
        }
        this.idVenta = idVenta;
    }

    public void setFecha(LocalDate fecha) {
        if (fecha == null || !Regexp.fechaValida(fecha.toString())) {
            throw new IllegalArgumentException("Fecha inválida");
        }
        this.fecha = fecha;
    }

    public void setDescuento(double descuento) {
        this.descuento = Regexp.descuentoV(descuento);
    }

    public void setMetodoPago(Metodopago metodoPago) {
        if (metodoPago == null) {
            throw new IllegalArgumentException("Método de pago requerido");
        }
        this.metodoPago = metodoPago;
    }

    public void setMontoPagado(double montoPagado) {
        if (montoPagado < 0) {
            throw new IllegalArgumentException("Monto pagado inválido");
        }
        this.montoPagado = montoPagado;
    }

    public void setPagada(boolean pagada) {
        if (pagada && montoPagado < getTotal()) {
            throw new IllegalArgumentException(
                    "El monto pagado (" + montoPagado + ") no cubre el total (" + getTotal() + ")");
        }
        this.pagada = pagada;
    }

    @Override
    public String toString() {
        return "Venta #" + idVenta + " | " + fecha +
                " | Total: $" + String.format("%.2f", getTotal()) +
                " | " + (pagada ? "PAGADA" : "PENDIENTE");
    }
}