package frontend;

import java.awt.*;
import javax.swing.*;

public class InterfazAplicacion extends JFrame{

    private CardLayout panelMixt;
    private JPanel principal;

    public InterfazAplicacion() {
        //Forma
        setTitle("Punto venta");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        //EVENTOS

        PanelMenu menu = new PanelMenu();
        add(menu, BorderLayout.WEST);
        PanelEncabezado encabezado = new PanelEncabezado();
        add(encabezado, BorderLayout.NORTH);
        PanelContenido contenido = new PanelContenido();
        add(contenido, BorderLayout.CENTER);
    }

    public static void main(String[] args){
        InterfazAplicacion interfaz = new InterfazAplicacion();
        interfaz.setVisible(true);
    }
}
