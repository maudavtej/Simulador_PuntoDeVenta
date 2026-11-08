package frontend;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {

    private JButton btnIniciar;

    public Login() {
        setLayout(new GridBagLayout());
        setBackground(new Color(240, 242, 244));

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBackground(new Color(116, 195, 244, 137));

        JLabel lbTitulo = new JLabel("SIMULADOR DE INVENTARIOS");
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lbTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnIniciar = new JButton("INICIAR");
        btnIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 14));

        form.add(lbTitulo);
        form.add(Box.createRigidArea(new Dimension(0, 20)));
        form.add(btnIniciar);
        add(form);
    }

    public JButton getBtnIniciar() {
        return btnIniciar;
    }
}