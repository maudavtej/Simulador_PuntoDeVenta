package backend;

public class ProductoDigital extends Producto {
    //ATRIBUTOS
    private String claveLicencia;
    public static final int []MESES_GARANTIA={1,3,6,9,12};
    private int mesesGarantia;
    //=============================================================================================
    //CONSTRUCTOR
    public ProductoDigital(String codigo, String nombre, float precioBase, int stock, String claveLicencia, int mesesGarantia){
        super(codigo,nombre,precioBase,stock);
        this.claveLicencia=claveLicencia;
        setMesesGarantia(mesesGarantia);
    }
    //===========================================================================
    //SETTERS Y GETTERS
    public void setClaveLicencia(String claveLicencia){this.claveLicencia=claveLicencia;}
    public String getClaveLicencia(){return claveLicencia;
    }

    public void setMesesGarantia(int mesesGarantia){
        for (int opcion:MESES_GARANTIA){
            if (opcion==mesesGarantia){
                this.mesesGarantia=mesesGarantia;
                return;
            }
        }
        throw new IllegalArgumentException("Garantía inválida");
    }
    public int getMesesGarantia(){
        return mesesGarantia;
    }

    //CÁLCULO DE SU PRECIO FINAL PROPIO
    @Override
    public double calcularPrecioFinal(){
        return precioBase*IVA;
    }
}
