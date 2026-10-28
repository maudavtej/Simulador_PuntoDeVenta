public class Venta {
    private int idVenta;
    private String fecha;
    private String nombreCliente;
    private double descuento;
    private MetodoPago metodoPago;
    private double montoPagado;
    private boolean pagada;

    public Venta(int idVenta, String nombreCliente) {
        this.idVenta = idVenta;
        this.nombreCliente = nombreCliente;
        this.descuento = 0;
        this.pagada = false;
    }


}
