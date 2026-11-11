package frontend;

import backend.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelVentas extends JPanel {
    //=============================================================================
    //ATRIBUTOS
    private final Inventario inventario;
    private final HistorialVentas historial;
    private final PanelContenido contenido;
    private Venta ventaActual;
    private int contadorVentas = 1;

    private JTextField txtCliente;
    private JTextField txtDescuento;
    private JComboBox<String> cmbProductos;
    private JSpinner spnCantidad;
    private JButton btnAgregar;
    private DefaultTableModel modeloCarrito;
    private JTable tablaCarrito;
    private JComboBox<MetodoPago> cmbMetodo;
    private JLabel lbTotal;
    private JLabel lbCampo1, lbCampo2, lbCampo3;
    private JTextField txtCampo1, txtCampo2, txtCampo3;
    private JButton btnPagar;
    private JButton btnVolver;

    //=============================================================================
    //CONSTRUCTOR
    public PanelVentas(Inventario inventario, HistorialVentas historial, PanelContenido contenido) {
        this.inventario = inventario;
        this.historial = historial;
        this.contenido = contenido;
        setLayout(new BorderLayout(5, 5));
        setBackground(new Color(213, 221, 234));
        setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        //=========================================================
        //PARTE SUPERIOR: CLIENTE, DESCUENTO, PRODUCTO Y CANTIDAD
        JPanel superior = new JPanel(new GridLayout(2, 4, 5, 5));
        superior.setBackground(new Color(213, 221, 234));
        superior.add(new JLabel("CLIENTE:"));
        txtCliente = new JTextField();
        superior.add(txtCliente);
        superior.add(new JLabel("DESCUENTO (%):"));
        txtDescuento = new JTextField("0");
        superior.add(txtDescuento);
        superior.add(new JLabel("PRODUCTO:"));
        cmbProductos = new JComboBox<>();
        superior.add(cmbProductos);
        superior.add(new JLabel("CANTIDAD:"));
        spnCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        superior.add(spnCantidad);

        btnAgregar = new JButton("AGREGAR AL CARRITO");
        btnAgregar.setFont(new Font("Arial", Font.BOLD, 10));

        JPanel norte = new JPanel(new BorderLayout(5, 5));
        norte.setBackground(new Color(213, 221, 234));
        norte.add(superior, BorderLayout.CENTER);
        norte.add(btnAgregar, BorderLayout.SOUTH);
        add(norte, BorderLayout.NORTH);

        //=========================================================
        //TABLA DEL CARRITO
        String[] columnas = {"PRODUCTO", "CANTIDAD", "PRECIO", "SUBTOTAL"};
        modeloCarrito = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        tablaCarrito = new JTable(modeloCarrito);
        tablaCarrito.setRowHeight(22);
        add(new JScrollPane(tablaCarrito), BorderLayout.CENTER);

        //=========================================================
        //PARTE INFERIOR: MÉTODO DE PAGO Y TOTAL
        JPanel inferior = new JPanel(new GridLayout(3, 4, 5, 5));
        inferior.setBackground(new Color(213, 221, 234));

        cmbMetodo = new JComboBox<>(MetodoPago.values());
        lbTotal = new JLabel("$0.00");
        lbTotal.setFont(new Font("Arial", Font.BOLD, 14));
        lbCampo1 = new JLabel();
        lbCampo2 = new JLabel();
        lbCampo3 = new JLabel();
        txtCampo1 = new JTextField();
        txtCampo2 = new JTextField();
        txtCampo3 = new JTextField();
        btnPagar = new JButton("PAGAR");
        btnVolver = new JButton("VOLVER");

        inferior.add(new JLabel("MÉTODO DE PAGO:"));
        inferior.add(cmbMetodo);
        inferior.add(new JLabel("TOTAL:"));
        inferior.add(lbTotal);
        inferior.add(lbCampo1);
        inferior.add(txtCampo1);
        inferior.add(lbCampo2);
        inferior.add(txtCampo2);
        inferior.add(lbCampo3);
        inferior.add(txtCampo3);
        inferior.add(btnPagar);
        inferior.add(btnVolver);
        add(inferior, BorderLayout.SOUTH);

        //=========================================================
        //EVENTOS
        cmbMetodo.addActionListener(e -> actualizarCampos());
        btnAgregar.addActionListener(e -> agregarAlCarrito());
        btnPagar.addActionListener(e -> pagar());

        actualizarCampos();
        actualizarProductos();
    }

    //=============================================================================
    //CARGA LOS PRODUCTOS DEL INVENTARIO EN LA LISTA DESPLEGABLE
    public void actualizarProductos() {
        cmbProductos.removeAllItems();
        for (Producto p : inventario.getProductos()) {
            cmbProductos.addItem(p.getCodigo() + " - " + p.getNombre() + " (stock: " + p.getStock() + ")");
        }
    }

    //=============================================================================
    //MUESTRA LOS CAMPOS QUE PIDE CADA MÉTODO DE PAGO
    private void actualizarCampos() {
        MetodoPago metodo = (MetodoPago) cmbMetodo.getSelectedItem();
        lbCampo2.setVisible(false);
        txtCampo2.setVisible(false);
        lbCampo3.setVisible(false);
        txtCampo3.setVisible(false);

        if (metodo == MetodoPago.EFECTIVO) {
            lbCampo1.setText("MONTO RECIBIDO:");
        } else if (metodo == MetodoPago.TARJETA) {
            lbCampo1.setText("NÚMERO DE TARJETA:");
            lbCampo2.setText("TITULAR:");
            lbCampo2.setVisible(true);
            txtCampo2.setVisible(true);
        } else {
            lbCampo1.setText("CLAVE DE RASTREO:");
            lbCampo2.setText("BANCO:");
            lbCampo3.setText("MONTO:");
            lbCampo2.setVisible(true);
            txtCampo2.setVisible(true);
            lbCampo3.setVisible(true);
            txtCampo3.setVisible(true);
        }
    }

    //=============================================================================
    //AGREGAR EL PRODUCTO SELECCIONADO AL CARRITO
    private void agregarAlCarrito() {
        try {
            if (cmbProductos.getSelectedIndex() < 0) {
                throw new IllegalArgumentException("No hay productos en el inventario");
            }
            if (ventaActual == null) {
                ventaActual = new Venta(contadorVentas, txtCliente.getText());
            }
            Producto p = inventario.getProductos().get(cmbProductos.getSelectedIndex());
            int cantidad = (int) spnCantidad.getValue();
            ventaActual.agregarProducto(p, cantidad);
            actualizarCarrito();
        } catch (IllegalArgumentException | IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //=============================================================================
    //REFRESCA LA TABLA DEL CARRITO Y EL TOTAL
    private void actualizarCarrito() {
        modeloCarrito.setRowCount(0);
        for (LineaVenta linea : ventaActual.getLineas()) {
            modeloCarrito.addRow(new Object[]{
                    linea.getProducto().getNombre(),
                    linea.getCantidad(),
                    String.format("$%.2f", linea.getPrecioUnitario()),
                    String.format("$%.2f", linea.getSubtotal())
            });
        }
        lbTotal.setText(String.format("$%.2f", ventaActual.calcularTotal()));
    }

    //=============================================================================
    //PAGAR LA VENTA SEGÚN EL MÉTODO ELEGIDO
    private void pagar() {
        try {
            if (ventaActual == null || ventaActual.getLineas().isEmpty()) {
                throw new IllegalStateException("El carrito está vacío");
            }
            ventaActual.setDescuento(Double.parseDouble(txtDescuento.getText().trim()));
            MetodoPago metodo = (MetodoPago) cmbMetodo.getSelectedItem();
            String mensaje;

            if (metodo == MetodoPago.EFECTIVO) {
                double cambio = ventaActual.procesarPago(Double.parseDouble(txtCampo1.getText().trim()));
                mensaje = "Pago en efectivo.\nCambio: $" + String.format("%.2f", cambio);
            } else if (metodo == MetodoPago.TARJETA) {
                ventaActual.procesarPago(txtCampo1.getText().trim(), txtCampo2.getText().trim());
                mensaje = "Pago con tarjeta aprobado.";
            } else {
                ventaActual.procesarPago(txtCampo1.getText().trim(), txtCampo2.getText().trim(),
                        Double.parseDouble(txtCampo3.getText().trim()));
                mensaje = "Transferencia registrada.";
            }

            mensaje = mensaje + "\nTotal: $" + String.format("%.2f", ventaActual.calcularTotal())
                    + "\nIVA incluido: $" + String.format("%.2f", ventaActual.calcularIVA());
            historial.registrar(ventaActual);
            JOptionPane.showMessageDialog(this, mensaje, "Venta pagada", JOptionPane.INFORMATION_MESSAGE);
            nuevaVenta();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Escribe solo números en los montos y el descuento",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException | IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //=============================================================================
    //LIMPIA TODO PARA EMPEZAR OTRA VENTA
    private void nuevaVenta() {
        ventaActual = null;
        contadorVentas++;
        txtCliente.setText("");
        txtDescuento.setText("0");
        txtCampo1.setText("");
        txtCampo2.setText("");
        txtCampo3.setText("");
        modeloCarrito.setRowCount(0);
        lbTotal.setText("$0.00");
        actualizarProductos();
        contenido.actualizarTabla();
        contenido.actualizarTotales(historial.calcularTotalVendido());
    }

    //=============================================================================
    //GETTERS
    public JButton getBtnVolver() {
        return btnVolver;
    }
}