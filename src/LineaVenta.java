// Representa el carrito de la compra sisisisi
public class LineaVenta {

    private Producto producto;     // Producto que se está comprando
    private int cantidad;          // Unidades de ese producto
    private double precioUnitario; // Precio al momento de la venta

    // Validando la cantidad y guardando el precio final del producto
    public LineaVenta(Producto producto, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
        }
        this.producto = producto;
        this.cantidad = cantidad;
        // Polimorfismo: cada tipo de producto calcula su precio final a su manera
        this.precioUnitario = producto.calcularPrecioFinal();
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getSubtotal() {
        return precioUnitario * cantidad;
    }
}