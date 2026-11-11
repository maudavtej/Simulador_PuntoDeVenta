package backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventario {
    private final List<Producto> productos = new ArrayList<>();

    public void agregar(Producto p) {
        if (p == null) throw new IllegalArgumentException("Producto requerido");
        if (buscarPorCodigo(p.getCodigo()) != null) {
            throw new IllegalArgumentException("Ya existe un producto con ese código");
        }
        productos.add(p);
    }

    public Producto buscarPorCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) return p;
        }
        return null;
    }

    public List<Producto> getProductos() {
        return Collections.unmodifiableList(productos);
    }

    public int getTotalProductos() {
        return productos.size();
    }
}