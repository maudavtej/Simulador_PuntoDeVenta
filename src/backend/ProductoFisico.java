package backend;

public class ProductoFisico extends Producto {
    //============================================
    //ATRIBUTOS PROPIOS
    private double peso=0;
    //============================================
    //CONSTRUCTOR
    public ProductoFisico(String codigo, String nombre, float precioBase, int stock,double peso, double descuento){
        super(codigo,nombre,precioBase,stock, descuento);
        setPeso(peso);
    }
    //=============================================
    //SETTERS Y GETTERS
    public void setPeso(double peso){
        if (peso<=0) throw new IllegalArgumentException("Peso inválido");
        this.peso=peso;
    }
    public double getPeso(){
        return peso;
    }

    @Override
    public double calcularPrecioFinal(){
        return precioBase*IVA;
    }

}
