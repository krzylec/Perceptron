import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MyFrame extends JFrame {
    private Perceptron perceptron= new Perceptron();

    private JPanel contentPane;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    private JPanel panelL1;
    private JPanel panelL2;
    private JLabel lblNewLabel;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JLabel lblNewLabel_1;

    Double[] filled = new Double[4];

    public MyFrame(){


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("perceptron");
        setBounds(100, 100, 480, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 195, 130));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

//========================================================================
        panel_1 = new JPanel();
        contentPane.add(panel_1);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


        btnNewButton_1 = new JButton("SET ACCURACY");

        btnNewButton_1.addActionListener(e -> {


                try{
                    Integer.parseInt(textField_4.getText());
                    lblNewLabel_1.setText("ACCURACY SET TO "+ textField_4.getText());

                    perceptron.learn(Double.parseDouble(textField_4.getText()));

                }
                catch(Exception ex){
                    //System.out.println("podaj poprawne dane!");
                    lblNewLabel_1.setText("podaj poprawne dane");
            }

                }
        );
        panel_1.add(btnNewButton_1);
        contentPane.add(panel_1);
        //========================================================================

        panel_2 = new JPanel();
        lblNewLabel_1 = new JLabel("");
        panel_2.add(lblNewLabel_1);

        contentPane.add(panel_2);
        //========================================================================
        panel_3 = new JPanel();


        panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        textField = new JTextField();
        panel_3.add(new JLabel("Sepal.L:"));
        panel_3.add(textField);
        textField.setColumns(5);

        textField_1 = new JTextField();
        panel_3.add(new JLabel("Sepal.W:"));
        panel_3.add(textField_1);
        textField_1.setColumns(5);

        textField_2 = new JTextField();
        panel_3.add(new JLabel("Petal.L:"));
        panel_3.add(textField_2);
        textField_2.setColumns(5);

        textField_3 = new JTextField();
        panel_3.add(new JLabel("Sepal.W:"));
        panel_3.add(textField_3);
        textField_3.setColumns(5);

        textField_4 = new JTextField();
        panel_3.add(new JLabel("ACCURACY:"));
        panel_3.add(textField_4);
        textField_4.setColumns(5);

        contentPane.add(panel_3);
        //========================================================================

        panel_4 = new JPanel();


        btnNewButton = new JButton("TEST");
        btnNewButton.addActionListener(e -> {
            try {
                filled[0] = Double.parseDouble(textField.getText());
                filled[1] = Double.parseDouble(textField_1.getText());
                filled[2] = Double.parseDouble(textField_2.getText());
                filled[3] = Double.parseDouble(textField_3.getText());

                ArrayList<Double> tmplist= new ArrayList<>();
                for(double d: filled)
                    tmplist.add(d);

                perceptron.getOutput(tmplist);

                if(perceptron.getOutput(tmplist)==0)
                    lblNewLabel.setText("classified to setosa");
                else
                    lblNewLabel.setText("classified to versicolor");
            }
            catch(Exception exc){
                //System.out.println("podaj poprawne dane!");
                lblNewLabel.setText("Dane nie pelne, wczytywane sa dane z pliku testowego");
                Data testData= new Data("iristest.csv");

                for(Flower testFlower: testData.flowerList){
                    if(perceptron.getOutput(testFlower.attributes)==0)
                        System.out.println(testFlower+ " classified to setosa");
                    else
                        System.out.println(testFlower+" classified to versicolor");
                }
            }




        });

        panel_4.add(btnNewButton);

        contentPane.add(panel_4);
//========================================================================
        panel_5 = new JPanel();
        lblNewLabel = new JLabel("");
        panel_5.add(lblNewLabel);

        contentPane.add(panel_5);
        setVisible(true);
    }
}
