package sv.edu.udb.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButton extends JFrame{
    private JPanel pnlRadioButton;
    private JLabel lblTitulo;
    private JLabel lblImagen;
    private JRadioButton rbtOpcion1;
    private JRadioButton rbtOpcion2;
    private JRadioButton rbtOpcion3;

    public RadioButton(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlRadioButton);
        this.setMinimumSize(new Dimension(400,400));
        this.setLocationRelativeTo(getParent());

        rbtOpcion1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/img/img2.png")));
            }
        });
        rbtOpcion2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/img/img1.png")));
            }
        });
        rbtOpcion3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/img/img3.png")));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new RadioButton("Seleccione una Imagen");
        frame.setVisible(true);
    }
}
