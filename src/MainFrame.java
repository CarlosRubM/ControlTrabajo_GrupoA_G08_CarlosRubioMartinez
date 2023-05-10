


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class MainFrame extends JFrame {
    private JTextField tfPeso;
    private JButton btnApilar;
    private JButton btnClear;

    private JPanel mainPanel;
    private JTextField tfContenido;
    private JTextField tfPrioridad;
    private JTextField tfPais;
    private JTextField tfEmisor;
    private JTextField tfReceptor;
    private JTextField tfId;
    private JTextArea tfResultado;
    private JButton btnDesapilar;
    private JTextField tfColumna;
    private JTextField tfNhub;
    private JTextArea tfMostrar_id;
    private JTextField tfBuscar_id;
    private JButton IdButton;
    private JTextField tfBuscarPais;
    private JButton calcularPaisButton;
    private JTextField tfResultadoPais;

    private FileInputStream fis;
    private ObjectInputStream entrada;
    private Puerto puerto;


    public MainFrame(){
        setContentPane(mainPanel);
        setTitle("Bienvenido");
        setSize(850,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        puerto = new Puerto();

        btnApilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String content = tfContenido.getText();
                int weight = Integer.parseInt(tfPeso.getText());
                int priority = Integer.parseInt(tfPrioridad.getText());
                String nation = tfPais.getText();
                String em = tfEmisor.getText();
                String re = tfReceptor.getText();
                int ident = Integer.parseInt(tfId.getText());

                Contenedor c = new Contenedor(ident,weight,priority,content,nation,em,re);
                puerto.apilar(c);
                tfResultado.setText(puerto.mostrar_puerto());


            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfPeso.setText("");
                tfContenido.setText("");
                tfPrioridad.setText("");
                tfPais.setText("");
                tfEmisor.setText("");
                tfId.setText("");
                tfReceptor.setText("");


            }
        });
        btnDesapilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int colum = Integer.parseInt(tfColumna.getText());
                int nhub = Integer.parseInt(tfNhub.getText());
                puerto.desapilar(colum,nhub);
                tfResultado.setText(puerto.mostrar_puerto());

            }
        });
        IdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfMostrar_id.setText((puerto.mostrar_por_id(Integer.parseInt(tfBuscar_id.getText()))));
            }
        });

        calcularPaisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfResultadoPais.setText(Integer.toString(puerto.contador(tfBuscarPais.getText())));
            }
        });
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
   }


}