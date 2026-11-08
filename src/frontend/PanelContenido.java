package frontend;

import javax.swing.*;
import java.awt.*;

public class PanelContenido extends JPanel {
    public PanelContenido(){
        //PANELES
        JPanel informacion = new JPanel();
        //JPanel
        setLayout(new BorderLayout());
        JPanel contenido = new JPanel();
        contenido.setBorder(BorderFactory.createLineBorder(new Color(225, 232, 237), 1));
        contenido.setBackground(new Color(213, 221, 234));
        add(contenido, BorderLayout.CENTER);
    }
}
