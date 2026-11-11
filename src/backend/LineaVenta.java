package backend;

public class LineaVenta {
    private final Producto producto;
    private int cantidad;
    private final double precioUnitario; // precio congelado al momento de la venta

    public LineaVenta(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("Producto requerido");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        if (cantidad > producto.getStock()) {
            throw new IllegalArgumentException("No hay stock suficiente (disponible: "
                    + producto.getStock() + ")");
        }
        this.producto = producto;
        this.cantidad = cantidad;
        // Congelamos el precio al momento de la venta (por si cambia después)
        this.precioUnitario = producto.calcularPrecioFinal();
    }

    // GETTERS
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }

    public double getSubtotal() {
        return precioUnitario * cantidad;
    }

    // SETTERS
    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        if (cantidad > producto.getStock()) {
            throw new IllegalArgumentException("No hay stock suficiente");
        }
        this.cantidad = cantidad;
    }
}