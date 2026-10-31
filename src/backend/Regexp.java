package backend;

import java.time.DateTimeException;
import java.time.LocalDate;

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

    //VALIDA NUMEROS

    public static boolean numerosValidos(int id){
        String idStr = Integer.toString(id);
        if (idStr==null||idStr.trim().isEmpty())return false;
        String regexp = "^[0-9]{5}$";
        return idStr.matches(regexp);
    }
    //VALIDA FECHA

    public static boolean fechaValida(String fecha) {
        if (fecha == null) return false;
        try {
            LocalDate.parse(fecha.trim());
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }


}
