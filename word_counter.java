import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class word_counter extends Component {

    private JTextArea ta;

    private JButton count;

    private JButton txtcolor;

    private JButton pad;

    private JLabel cha;

    private JLabel word;
    private JPanel panel;

    private JPanel panel1;

    private  JLabel Char;
    private JButton reset;


    word_counter(){
        JFrame frame = new JFrame("Word Counter");
        frame.setSize(300,300);

        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        // Initialize the panel
        panel = new JPanel();

        // Initialize buttons and labels
        count = new JButton("Count");
        pad = new JButton("Pad");
        txtcolor = new JButton("Text Color");
        cha = new JLabel("Character");
        word = new JLabel("Words: ");
        Char = new JLabel("Character Count: ");

        // Initialize the text area
        ta = new JTextArea(10, 20);
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);

        // Initialize the reset button
        reset = new JButton("Reset");

        // Add components to the panel
        panel.add(cha);
        panel.add(word);
        panel.add(Char);
        panel.add(ta);
        panel.add(count);
        panel.add(pad);
        panel.add(txtcolor);
        panel.add(reset);

        frame.add(panel);


        count.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = ta.getText();
                cha.setText("Character:"+text.length());
                String words[] = text.split("\\s");;
                word.setText("Words"+words.length);
            }
        });
        pad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(ta, "Choose the color to use",Color.black );
                ta.setBackground(c);

            }
        });
        txtcolor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(ta,"Choose the color to use", Color.black);
                ta.setForeground(c);
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("");

            }
        });
    }

    public static void main(String[]args){
        new word_counter();

    }
}
