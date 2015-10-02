import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class orderForm extends JFrame {
	private static final long serialVersionUID = 597963664276031085L;
	
	String[] labels = {"Name: ", "Address: ", "Product: ", "Quantity: "};
	int numPairs = labels.length;
	SpringLayout sl = new SpringLayout();
	JPanel panel = new JPanel(sl);
	
	public orderForm(){
		super("Create Order");
		init();
	}
	
	public void init(){
		//JPanel panel;
		
	
		//Create and populate the panel.
		
		
		for(int i = 0; i < numPairs; i++){
		    JLabel l = new JLabel(labels[i], JLabel.TRAILING);
		    panel.add(l);
		    JTextField textField = new JTextField(10);
		    l.setLabelFor(textField);
		    panel.add(textField);
		    //sl.putConstraint(SpringLayout.WEST, l, 2, SpringLayout.WEST, panel);
		    //sl.putConstraint(SpringLayout.NORTH, l, 30*i+5, SpringLayout.NORTH, panel);
		    //sl.putConstraint(SpringLayout.WEST, textField, 5, SpringLayout.EAST, l);
		    //sl.putConstraint(SpringLayout.NORTH, textField, 30*i+5, SpringLayout.NORTH, panel);
		}
		
		SpringUtilities su = new SpringUtilities();
		//Lay out the panel.
		su.makeCompactGrid(panel, numPairs, 2,6, 6, 6, 6);
		
		add(panel);
		setSize(300,180);
		setLocation(600,450);
		setResizable(false);
		setVisible(true);
		
		
		
	}

	
}