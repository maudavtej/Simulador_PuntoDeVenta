import java.util.Date;

public class ProductoPerecedero extends ProductoFisico{
    protected Date caducidad;

    public ProductoPerecedero(String codigo, String nombre, float precioBase, int stock, double peso, Date caducidad){
        super(codigo,nombre,precioBase,stock, peso);
        this.caducidad=caducidad;
    }

    public void setCaducidad(Date caducidad){this.caducidad=caducidad;}
    public Date getCaducidad(){return caducidad;}
    @Override
    public double calcularPrecioFinal(){
        return precioBase*IVA;
    }

}
