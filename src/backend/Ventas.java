package backend;

import java.util.Date;

public class Ventas {
    private int idVenta;
    private Date fecha;
    private double descuento;
    private Metodopago metodoPago;
    private double montoPagado;
    private boolean pagada;

    private Ventas(){}
    public Ventas(int idVenta, Date fecha, double descuento, Metodopago metodoPago, double montoPagado, boolean pagada ) {
        this.idVenta = idVenta;
        this.fecha= fecha;
        this.descuento = descuento;
        this.metodoPago=metodoPago;
        this.pagada = pagada;
        this.montoPagado=montoPagado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public Date getFecha() {
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

    public boolean isPagada() {
        return pagada;
    }
}

