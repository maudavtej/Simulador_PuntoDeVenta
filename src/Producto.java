public abstract class Producto {

    protected String codigo;
    protected String nombre;
    protected float precioBase;
    protected int stock;

    public Producto(String codigo,String nombre, float precioBase, int stock){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
    }

    public abstract double calcularPrecioFinal();

    public void reducirStock(int cant){
        if(this.stock>0){
            this.stock-=cant;
        }
    }
}
