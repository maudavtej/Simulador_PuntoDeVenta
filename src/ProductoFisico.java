public class ProductoFisico extends Producto{
    protected double peso=0;
    public ProductoFisico(String codigo, String nombre, float precioBase, int stock,double peso){
        super(codigo,nombre,precioBase,stock);
        this.peso=peso;
    }
    public void setPeso(double peso){this.peso=peso;}
    public double getPeso(){
        return peso;
    }

    @Override
    public double calcularPrecioFinal(){
        return precioBase*IVA;
    }

}
