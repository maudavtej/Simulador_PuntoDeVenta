public class ProductoDigital extends Producto{
    protected String claveLicencia;

    public ProductoDigital(String codigo, String nombre, float precioBase, int stock, String claveLicencia){
        super(codigo,nombre,precioBase,stock);
        this.claveLicencia=claveLicencia;
    }
    public void setClaveLicencia(String claveLicencia){this.claveLicencia=claveLicencia;}
    public String getClaveLicencia(){return claveLicencia;
    }
    @Override
    public double calcularPrecioFinal(){
        return precioBase*IVA;
    }
}
