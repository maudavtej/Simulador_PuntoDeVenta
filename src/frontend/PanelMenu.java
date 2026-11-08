package frontend;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelMenu extends JPanel {
    private JLabel lbMenu;
    private JComboBox<String> cbProductos;
    //BOTONES
    private JButton btnAddProducto;

    //CONSTANTES
    private final static String REGISTRAR_PRODUCTO="AGREGAR NUEVO PRODUCTO";


    //CONSTRUCTOR

    public PanelMenu(){
        setLayout(null);
        setPreferredSize(new Dimension(150,0));
        setBackground(new Color(15, 23, 42));



        //ETIQUETAS

        lbMenu = new JLabel("MENÚ");
        lbMenu.setFont(new Font("Arial",Font.BOLD,14));
        lbMenu.setForeground(Color.white);

        //LISTAS DESPLEGABLES

        cbProductos=new JComboBox<>();
        cbProductos.addItem("Producto físico");
        cbProductos.addItem("Producto perecedero");
        cbProductos.addItem("Producto digital");

        //BOTONES

        btnAddProducto=new JButton("PRODUCTOS");
        btnAddProducto.setActionCommand(REGISTRAR_PRODUCTO);
        //POSICIONES

        lbMenu.setBounds(50,10,50,20);
        //cbProductos.setBounds(25, 50,100,20);
        btnAddProducto.setBounds(7,80,140,50);

        //
        add(lbMenu, BorderLayout.CENTER);
        //add(cbProductos);
        add(btnAddProducto);

    }
}
