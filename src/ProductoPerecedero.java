import java.time.LocalDate;
import java.util.Date;

public class ProductoPerecedero extends ProductoFisico{
    //=============================================================================
    //ATRIBUTOS PROPIOS
    private LocalDate caducidad;
//=========================================================================================
//CONSTRUCTOR
    public ProductoPerecedero(String codigo, String nombre, float precioBase, int stock, double peso, LocalDate caducidad){
        super(codigo,nombre,precioBase,stock, peso);
        this.caducidad=caducidad;
        setPeso(peso);//ASIGNAMOS Y VALIDAMOS AL MISMO TIEMPO
    }
//===============================================================================================
//GETTERS Y SETTERS
    public void setCaducidad(LocalDate caducidad){
       if (caducidad.isBefore(LocalDate.now())){
           throw new IllegalArgumentException("El producto está caducado");
       }
        this.caducidad=caducidad;
    }
    public LocalDate getCaducidad(){return caducidad;}
//===============================================================================================
//FUNCION PROPIA
    @Override
    public double calcularPrecioFinal(){
        return precioBase*getPeso()*IVA;
    }

}
