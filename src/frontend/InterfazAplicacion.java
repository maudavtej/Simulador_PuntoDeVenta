package frontend;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class InterfazAplicacion extends JFrame{

    public InterfazAplicacion(){
        //Forma
        setTitle("Putno venta");
        setSize(1200,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
    }

    public static void main(String[] args){
        InterfazAplicacion interfaz = new InterfazAplicacion();
        interfaz.setVisible(true);
    }
}
