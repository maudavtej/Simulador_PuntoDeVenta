package backend;

import java.time.LocalDate;
import java.util.Date;

public class Ventas {
    private int idVenta;
    private LocalDate fecha;
    private double descuento;
    private Metodopago metodoPago;
    private double montoPagado;
    private boolean pagada=false;
    private final Producto producto;

    public Ventas(int idVenta, LocalDate fecha, double descuento, Metodopago metodoPago, double montoPagado, boolean pagada, Producto producto) {
        if (producto==null) throw new IllegalArgumentException("Producto requerido");
        this.producto=producto;
        setIdVenta(idVenta);
        this.fecha= fecha;
        setDescuento(descuento);
        this.metodoPago=metodoPago;
        this.pagada = pagada;
        this.montoPagado=montoPagado;
    }

    //GETTERS
    public int getIdVenta() {return idVenta;}

    public LocalDate getFecha() {
        return fecha;
    }

    public double getDescuento() {
        return descuento;
    }

    public Metodopago getMetodoPago() {
        return metodoPago;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    //SETTERS

    public void setIdVenta(int idVenta) {
        if (!Regexp.numerosValidos(idVenta)){
            throw new IllegalArgumentException("Ingrese un ID válido");
        }
        this.idVenta = idVenta;
    }

    public void setFecha(LocalDate fecha) {
        String fechaStr = fecha.toString();
        if (!Regexp.fechaValida(fechaStr)){
            throw new IllegalArgumentException("Fecha inválida");
        }
        this.fecha = fecha;
    }

    public void setDescuento(double descuento) {

        this.descuento = Regexp.descuentoV(descuento);
    }

    public void setMetodoPago(Metodopago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public void setPagada(boolean pagada) {
        if (montoPagado>=producto.calcularPrecioFinal()){
            pagada=true;
        }
        this.pagada=pagada;
    }

    public boolean isPagada() {
        return pagada;
    }
}

