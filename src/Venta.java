import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venta {

    private int idVenta;               // Identificador único de la venta
    private LocalDateTime fecha;       // Fecha y hora en que se creó la venta
    private String nombreCliente;      // Nombre del cliente que compra
    private List<LineaVenta> lineas;   // Carrito: lista de renglones de la venta
    private double descuento;          // Porcentaje de descuento
    private MetodoPago metodoPago;     // Forma en que se pagó
    private double montoPagado;        // Cantidad que el cliente entregó
    private boolean pagada;            // Indica si la venta ya fue pagada

    // Crea una venta nueva, vacía y sin pagar
    public Venta(int idVenta, String nombreCliente) {
        this.idVenta = idVenta;
        this.nombreCliente = nombreCliente;
        this.fecha = LocalDateTime.now();  // Se asigna la fecha y hora actuales
        this.lineas = new ArrayList<>();   // El carrito empieza sin nada
        this.descuento = 0;
        this.montoPagado = 0;
        this.pagada = false;
    }

    // Devuelve el identificador de la venta
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
            throw new IllegalArgumentException("El descuento debe ser enrew 0 y 100");
        }
        this.descuento = descuento;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    // Indica si la venta ya está pagada
    public boolean isPagada() {
        return pagada;
    }
}