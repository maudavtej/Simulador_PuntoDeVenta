package frontend;

import backend.*;

import java.awt.*;
import javax.swing.*;

public class InterfazAplicacion extends JFrame{
    private final Inventario inventario= new Inventario();
    private final HistorialVentas historial = new HistorialVentas();
    private final CardLayout cartas = new CardLayout();
    private final JPanel centro = new JPanel(cartas);

    public InterfazAplicacion() {
        //Forma
        setTitle("Punto venta");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        //PRODUCTOS DE PRUEBA (BÓRRALOS CUANDO EXISTA EL FORMULARIO DE REGISTRO)
        inventario.agregar(new ProductoDigital("1000001", "Antivirus", 500f, 10, "ABC-123", 12));
        inventario.agregar(new ProductoFisico("1000002", "Mouse inalambrico", 250f, 10, 0.2, 0));

        PanelMenu menu = new PanelMenu();
        add(menu, BorderLayout.WEST);

        PanelEncabezado encabezado = new PanelEncabezado();
        add(encabezado, BorderLayout.NORTH);

        PanelContenido contenido = new PanelContenido(inventario);
        PanelVentas ventas = new PanelVentas(inventario, historial, contenido);
        centro.add(contenido, "INVENTARIO");
        centro.add(ventas, "VENTAS");
        add(centro, BorderLayout.CENTER);

        //EVENTOS
        menu.getBtnVentas().addActionListener(e -> {
            ventas.actualizarProductos();
            cartas.show(centro, "VENTAS");
        });
        ventas.getBtnVolver().addActionListener(e -> cartas.show(centro, "INVENTARIO"));
    }

    public static void main(String[] args){
        InterfazAplicacion interfaz = new InterfazAplicacion();
        interfaz.setVisible(true);
    }
}