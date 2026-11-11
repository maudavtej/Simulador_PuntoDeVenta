package backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistorialVentas {
    private final List<Venta> ventas = new ArrayList<>();

    //SOLO SE REGISTRAN VENTAS YA PAGADAS
    public void registrar(Venta v) {
        if (v == null) throw new IllegalArgumentException("Venta requerida");
        if (!v.isPagada()) {
            throw new IllegalArgumentException("Solo se registran ventas pagadas");
        }
        ventas.add(v);
    }

    public List<Venta> getVentas() {
        return Collections.unmodifiableList(ventas);
    }

    public int getTotalVentas() {
        return ventas.size();
    }

    //SUMA EL TOTAL DE TODAS LAS VENTAS
    public double calcularTotalVendido() {
        double suma = 0;
        for (Venta v : ventas) {
            suma = suma + v.calcularTotal();
        }
        return suma;
    }
}