package frontend;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelMenu extends JPanel {
    private JLabel lbMenu;
    //BOTONES
    private JButton btnAddProducto;
    private JButton btnBuscarProducto;
    private JButton btnVentas;

    //CONSTANTES
    private final static String REGISTRAR_PRODUCTO="AGREGAR NUEVO PRODUCTO";
    private final static  String BUSCAR_PRODUCTO="BUSCAR PRODUCTO";
    private final static String CONSULTAR_VENTAS="VENTAS";
    //CONSTRUCTOR
    public PanelMenu(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        setPreferredSize(new Dimension(165,0));
        setBackground(new Color(15, 23, 42));
        //ETIQUETAS
        //MENÚ
        lbMenu = new JLabel("MENÚ");
        lbMenu.setFont(new Font("Arial",Font.BOLD,20));
        lbMenu.setForeground(Color.white);
        lbMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
//======================================================================
        //BOTONES

        btnAddProducto=new JButton("REGISTRAR PRODUCTO");
        btnAddProducto.setActionCommand(REGISTRAR_PRODUCTO);
        btnAddProducto.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAddProducto.setMaximumSize(new Dimension(160, 40));
        btnAddProducto.setMinimumSize(new Dimension(160, 40));
        btnAddProducto.setPreferredSize(new Dimension(160, 40));
        btnAddProducto.setFont(new Font("Arial", Font.BOLD, 10));
        //======================================================
        btnBuscarProducto = new JButton("BUSCAR PRODUCTO");
        btnBuscarProducto.setActionCommand(BUSCAR_PRODUCTO);
        btnBuscarProducto.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBuscarProducto.setMaximumSize(new Dimension(160, 40));
        btnBuscarProducto.setMinimumSize(new Dimension(160, 40));
        btnBuscarProducto.setPreferredSize(new Dimension(160, 40));
        btnBuscarProducto.setFont(new Font("Arial", Font.BOLD, 10));
    //================================================================
        btnVentas = new JButton("VENTAS");
        btnVentas.setActionCommand(CONSULTAR_VENTAS);
        btnVentas.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVentas.setMaximumSize(new Dimension(160, 40));
        btnVentas.setMinimumSize(new Dimension(160, 40));
        btnVentas.setPreferredSize(new Dimension(160, 40));
        btnVentas.setFont(new Font("Arial", Font.BOLD, 10));
        //===================================================
        //ESPACIOS ENTRE BOTONES
        add(lbMenu);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(btnAddProducto);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnBuscarProducto);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(btnVentas);
        add(Box.createVerticalGlue());
    }
    public JButton getBtnAddProducto(){
        return btnAddProducto;
    }

    public JButton getBtnBuscarProducto(){
        return btnBuscarProducto;
    }

    public JButton getBtnVentas(){
        return btnVentas;
    }
}
