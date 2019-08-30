
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Tela1 extends JFrame {

    private JTextField txt1;
    private JButton botao;

    public void init() {

        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        this.txt1 = new JTextField(30);
        this.txt1.setBounds(0, 0, 200, 50);
        add(txt1);

        this.botao = new JButton("OK");
        this.botao.setBounds(0, 0, 100, 50);
        add(botao);

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, txt1.getText());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        Tela1 t = new Tela1();
        t.init();
    }
}
