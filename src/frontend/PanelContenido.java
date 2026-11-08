package frontend;

import backend.Inventario;
import backend.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class PanelContenido extends JPanel {
    private JTable tabla;
    private JLabel lbTotalProductos;
    private JLabel lbTotalVentas;
    private DefaultTableModel modeloTabla;
    private final Inventario inventario;
    public PanelContenido(Inventario inventario){
        this.inventario=inventario;
        //PANELES
        setLayout(new BorderLayout());
        JPanel contenido = new JPanel();
        contenido.setBorder(BorderFactory.createEmptyBorder());
        contenido.setBackground(new Color(213, 221, 234));
        add(contenido, BorderLayout.CENTER);
        //==========================================================
        JPanel tablaInf = new JPanel(new BorderLayout());
        tablaInf.setBorder(BorderFactory.createEmptyBorder());
        tablaInf.setBackground(new Color(255, 255, 255));
        tablaInf.setPreferredSize(new Dimension(0,200));
        add(tablaInf, BorderLayout.SOUTH);
        //============================================================
        //============================================================
// ENCABEZADO CON TOTALES
        JPanel encabezado = new JPanel(new GridLayout(1, 2));
        encabezado.setBackground(new Color(213, 221, 234));
        encabezado.setBorder(BorderFactory.createEmptyBorder());
        encabezado.setPreferredSize(new Dimension(0, 25));
        add(encabezado, BorderLayout.NORTH);

        lbTotalProductos = new JLabel("PRODUCTOS: 0", SwingConstants.CENTER);
        lbTotalProductos.setFont(new Font("Arial", Font.BOLD, 8));

        lbTotalVentas = new JLabel("VENTA TOTAL: $0.00", SwingConstants.CENTER);
        lbTotalVentas.setFont(new Font("Arial", Font.BOLD, 8));

        encabezado.add(lbTotalProductos);
        encabezado.add(lbTotalVentas);
        //============================================================

        //=============================================================
        //TABLA
        String[] columnas = {"CÓDIGO", "PRODUCTO", "PRECIO","STOCK"};
        modeloTabla=new DefaultTableModel(columnas,0){
                @Override
                public boolean isCellEditable(int fila, int columna) {
                return false; // la tabla es solo de lectura
            }
            };
        tabla = new JTable(modeloTabla);
        tabla.setRowHeight(25);
        tabla.setFont(new Font("Arial", Font.PLAIN, 14));
        tabla.setBackground(Color.WHITE);
        tabla.setSelectionBackground(new Color(213, 221, 234));
        tabla.setSelectionForeground(Color.BLACK);
        tabla.setGridColor(new Color(213, 221, 234));
        tabla.setFillsViewportHeight(true);

        JTableHeader header = tabla.getTableHeader();
        header.setBackground(new Color(17, 24, 45));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setReorderingAllowed(false);

        // Centrar el contenido de las celdas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        // Scroll
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getViewport().setBackground(Color.WHITE);

        tablaInf.add(scroll, BorderLayout.CENTER);
        actualizarTabla();
    }

    public void actualizarTabla(){
        modeloTabla.setRowCount(0);
        for (Producto p : inventario.getProductos()) {
            modeloTabla.addRow(new Object[]{
                    p.getCodigo(),
                    p.getNombre(),
                    String.format("$%.2f", p.calcularPrecioFinal()),
                    p.getStock()
    });
        }
    }
    //==================================================================
    //GETTERS




    }

   

