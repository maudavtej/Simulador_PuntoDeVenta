package backend;

public class Regexp {
    //=============================================================================
    //VALIDAMOS QUE EL CÓDIGO SEAN SOLO NÚMEROS
    public static boolean isCodigo(String codigoProducto){
        if (codigoProducto==null|| codigoProducto.trim().isEmpty()){
            return false;
        }
        String regex = "^[0-9]{7}$";
        return codigoProducto.trim().matches(regex);
    }

    //================================================================================
    //VALIDACIÓN DE CANTIDADES
    public static boolean isNumber(String precioBase){
        if (precioBase==null||precioBase.trim().isEmpty())return false;
        try {
            float precioB =Float.parseFloat(precioBase.trim());
            return precioB>0;
        }catch (NumberFormatException e){
            return false;
        }

    }

    //==================================================================================
    //VALIDA NOMBRE DE PRODUCTO
    public static boolean validaNombres(String nombreP){
        if (nombreP==null||nombreP.trim().isEmpty())return false;
        String regex = "^[A-Za-zÁÉÍÓÚáéíóúñÑ\\s]+$";
        return nombreP.trim().matches(regex);
    }

    //=============================================================================
    //VALIDA QUE EL DESCUENTO SEA UNA FRACCIÓN ENTRE 0 Y 1 (0.2 = 20%)
    public static double descuentoV(double descuento){
        if (descuento < 0 || descuento > 1) {
            throw new IllegalArgumentException("Descuento inválido (debe ser entre 0 y 1)");
        }
        return descuento;
    }


}
