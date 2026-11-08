package frontend;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PanelEncabezado extends JPanel {
    private JLabel lbTitulo;
    public PanelEncabezado(){
        setLayout(new BorderLayout());
        setBackground(new Color(30, 41, 59));
        setPreferredSize(new Dimension(0,60));
        //BORDES
        Border bordeInferior = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(51, 65, 85));
        Border padding = BorderFactory.createEmptyBorder(0, 25, 0, 20);
        setBorder(BorderFactory.createCompoundBorder(bordeInferior, padding));
        //Titulo
        lbTitulo=new JLabel("SISTEMA DE INVENTARIOS");
        lbTitulo.setFont(new Font("Segoe UI", Font.BOLD,25));
        lbTitulo.setForeground(Color.white);
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lbTitulo, BorderLayout.CENTER);

    }
}
