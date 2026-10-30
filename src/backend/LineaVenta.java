package backend;

public class LineaVenta {
    //=============================================================================
    //ATRIBUTOS
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    //=============================================================================
    //CONSTRUCTOR
    public LineaVenta(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
        }
        this.producto = producto;
        this.cantidad = cantidad;
        //CADA TIPO DE PRODUCTO CALCULA SU PRECIO FINAL (POLIMORFISMO)
        this.precioUnitario = producto.calcularPrecioFinal();
    }

    //=============================================================================
    //GETTERS
    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    //=============================================================================
    //PRECIO POR CANTIDAD
    public double getSubtotal() {
        return precioUnitario * cantidad;
    }
}