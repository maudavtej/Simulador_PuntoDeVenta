package frontend;

import backend.Inventario;

import java.awt.*;
import javax.swing.*;

public class InterfazAplicacion extends JFrame{
    private final Inventario inventario= new Inventario();

    public InterfazAplicacion() {
        //Forma
        setTitle("Punto venta");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        //EVENTOS

        PanelMenu menu = new PanelMenu();
        add(menu, BorderLayout.WEST);

        PanelEncabezado encabezado = new PanelEncabezado();
        add(encabezado, BorderLayout.NORTH);

        PanelContenido contenido = new PanelContenido(inventario);
        add(contenido, BorderLayout.CENTER);
    }

    public static void main(String[] args){
        InterfazAplicacion interfaz = new InterfazAplicacion();
        interfaz.setVisible(true);
    }
}
