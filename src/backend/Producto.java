package backend;

public abstract class Producto {
    public static final double IVA=1.16;
    protected String codigo;
    protected String nombre;
    protected float precioBase;
    protected int stock;
    protected double descuento;

    public Producto(String codigo,String nombre, float precioBase, int stock, double descuento){
        setCodigo(codigo);
        setNombre(nombre);
        setPrecioBase(precioBase);
        setStock(stock);
        setDescuento(descuento);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (!Regexp.isCodigo(codigo)){throw new IllegalArgumentException("Código inválido");
        }
        this.codigo = codigo.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!Regexp.validaNombres(nombre)){throw new IllegalArgumentException("Nombre de producto inválido");}
        this.nombre=nombre.trim();
    }

    public float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(float precioBase) {

        if (precioBase <= 0 || !Float.isFinite(precioBase)) {
            throw new IllegalArgumentException("Precio inválido");
        }
        this.precioBase=precioBase;
    }
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock<0||stock>3000){
            throw new IllegalArgumentException("Stock inválido");
        }
        this.stock = stock;
    }

    public void setDescuento(double descuento){
        this.descuento=Regexp.descuentoV(descuento);
    }
    public double getDescuento(){return descuento;}

    public abstract double calcularPrecioFinal();
}
