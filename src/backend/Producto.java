package backend;

public abstract class Producto {
    public static final double IVA=1.16;
    protected String codigo;
    protected String nombre;
    protected float precioBase;
    protected int stock;
    protected double descuento;

    private Producto(){}
    public Producto(String codigo,String nombre, float precioBase, int stock, double descuento){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
        this.descuento=descuento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (!Regexp.isCodigo(codigo)){throw new IllegalArgumentException("Código inválido");
        }
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioBase() {
        if (precioBase<=0){
            throw new IllegalArgumentException("Ingrese un precio base válido");
        }
        return this.precioBase=precioBase;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDescuento(double descuento){
        this.descuento=descuento;
    }
    public double getDescuento(){return descuento;}

    public abstract double calcularPrecioFinal();
}
