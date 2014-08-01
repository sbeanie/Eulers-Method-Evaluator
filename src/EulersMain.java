/**
 * Created by Tom on 13/03/14.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.JOptionPane;


public class EulersMain extends JFrame
        implements ActionListener
{
    public static JPanel panel;

    JLabel InfoLabel;
    JLabel xLabel;
    JLabel yLabel;
    JLabel hLabel;
    JLabel fLabel;
    JLabel fxLabel;

    static JTextField xField;
    static JTextField yField;
    static JTextField hField;
    static JTextField fField;
    static JTextField fxField;

    JButton StartButton;

    private EulersMain.Task task;

    public EulersMain()
    {
        panel = new JPanel(null);

        this.InfoLabel = new JLabel();
        this.InfoLabel.setLocation(30, 0);
        this.InfoLabel.setSize(400, 50);
        this.InfoLabel.setText("Tom Parker's Eulers Method Calculator!");
        Font infoLabelFont = new Font(this.InfoLabel.getFont().getName(), 1, 16);
        this.InfoLabel.setFont(infoLabelFont);
        panel.add(this.InfoLabel);

        this.xLabel = new JLabel();
        this.xLabel.setLocation(23, 40);
        this.xLabel.setSize(100, 48);
        this.xLabel.setText("Enter x:");
        panel.add(this.xLabel);

        this.yLabel = new JLabel();
        this.yLabel.setLocation(24, 80);
        this.yLabel.setSize(100, 50);
        this.yLabel.setText("Enter y:");
        panel.add(this.yLabel);

        this.hLabel = new JLabel();
        this.hLabel.setLocation(24, 120);
        this.hLabel.setSize(100, 50);
        this.hLabel.setText("Enter step:");
        panel.add(this.hLabel);

        this.fLabel = new JLabel();
        this.fLabel.setLocation(24,160);
        this.fLabel.setSize(100, 50);
        this.fLabel.setText("Enter final x:");
        panel.add(this.fLabel);

        this.fxLabel = new JLabel();
        this.fxLabel.setLocation(24,200);
        this.fxLabel.setSize(100, 50);
        this.fxLabel.setText("Enter f(x):");
        panel.add(this.fxLabel);

        xField = new JTextField();
        xField.setLocation(133, 49);
        xField.setSize(100, 30);
        xField.setText("");
        xField.setColumns(10);
        panel.add(xField);

        yField = new JTextField();
        yField.setLocation(133, 91);
        yField.setSize(100, 30);
        yField.setText("");
        yField.setColumns(10);
        panel.add(yField);

        hField = new JTextField();
        hField.setLocation(133, 131);
        hField.setSize(100, 30);
        hField.setText("");
        hField.setColumns(10);
        panel.add(hField);

        fField = new JTextField();
        fField.setLocation(133, 171);
        fField.setSize(100, 30);
        fField.setText("");
        fField.setColumns(10);
        panel.add(fField);

        fxField = new JTextField();
        fxField.setLocation(133, 211);
        fxField.setSize(220, 30);
        fxField.setText("");
        fxField.setColumns(10);
        panel.add(fxField);

        this.StartButton = new JButton();
        this.StartButton.setLocation(265, 98);
        this.StartButton.setSize(100, 50);
        this.StartButton.setBackground(new Color(-65536));
        this.StartButton.setText("START");
        this.StartButton.addActionListener(this);
        panel.add(this.StartButton);

        add(panel);
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == this.StartButton) {
            this.task = new EulersMain.Task();
            eulers.noError = true;
            this.task.execute();
        }
    }

    public static void startGUI() {
        EulersMain first = new EulersMain();
        first.setTitle("Eulers Method");
        first.setSize(400, 310);
        first.setDefaultCloseOperation(3);
        first.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                EulersMain.startGUI();
            }
        });
    }

    class Task extends SwingWorker<Void, Void>
    {
        Task()
        {
        }

        public Void doInBackground()
        {
            eulers.setParameters(Double.parseDouble(EulersMain.xField.getText()),
                    Double.parseDouble(EulersMain.yField.getText()),
                    Double.parseDouble(EulersMain.hField.getText()),
                    Double.parseDouble(EulersMain.fField.getText()),
                    fxField.getText().toString());

            eulers.euler();
            if(eulers.noError){
                JOptionPane.showMessageDialog(null, "Answer is: " + eulers.y);
            }
            return null;
        }
    }
}