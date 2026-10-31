package backend;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProductoPerecedero extends ProductoFisico {
    //=============================================================================
    //ATRIBUTOS PROPIOS
    private LocalDate caducidad;
//=========================================================================================
//CONSTRUCTOR
    public ProductoPerecedero(String codigo, String nombre, float precioBase, int stock, double peso, LocalDate caducidad){
        super(codigo,nombre,precioBase,stock, peso, 0);
        setCaducidad(caducidad);
    }
//===============================================================================================
//GETTERS Y SETTERS
    public void setCaducidad(LocalDate caducidad){
       if (caducidad==null)throw new IllegalArgumentException("Se requiere una caducidad para el producto");
       if (caducidad.isBefore(LocalDate.now())){
           throw new IllegalArgumentException("El producto está caducado");
       }
        this.caducidad=caducidad;
    }
    public LocalDate getCaducidad(){return caducidad;}
//===============================================================================================
//FUNCION PROPIA y FUNCIONES
    @Override
    public double calcularPrecioFinal(){
        return precioBase*getPeso()*IVA;
    }

    @Override
    public double getDescuento(){
        long diasDeDif = ChronoUnit.DAYS.between(LocalDate.now(), caducidad);
        if (diasDeDif<=3) return 0.6;
        if (diasDeDif<=6) return 0.2;
        return 0;
    }

}
