import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class myGui extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 597963664276031084L;
	static JPanel panel;
	static JPanel panel2;
	static JPanel panel3;

	static String[] listArray = new String[15];
	static JButton[] buttonArray = new JButton[15];
	static int buttonCount = 0;
	static Application app = new Application();
	static JTextArea alpha = new JTextArea();
	static JButton checkoutButton = new JButton("Checkout Order");
	static int y = 0;
	static JComboBox<String> c;
	static String[] checklist;
	static int checklistCount;
	
	static boolean windowOpen = false; 
	ActionListener go = new ActionListener(){
									public void actionPerformed(ActionEvent e) {
										app.checkOut(Integer.parseInt(getId(listArray[y])));
										redraw();
										emptyBox();
										createBox(c);
									}
								};
								
	ActionListener delete = new ActionListener(){
									public void actionPerformed(ActionEvent e){
										if(c.getSelectedIndex()!=-1){
											app.deleteOrder(checklist[c.getSelectedIndex()]);
											buildList();
											redraw();
											emptyBox();
											createBox(c);
										}
									}
								};
								
	ActionListener checkIn = new ActionListener(){
									public void actionPerformed(ActionEvent e){
										if(c.getSelectedIndex()!=-1){
											app.checkIn(checklist[c.getSelectedIndex()]);
											redraw();
											emptyBox();
											createBox(c);
										}
									}
								};
	
	ActionListener createOrder = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(!windowOpen){
				windowOpen = true;
				orderForm of = new orderForm();
				of.addWindowListener(new WindowAdapter()
		        {
		            @Override
		            public void windowClosing(WindowEvent e)
		            {
		                e.getWindow().dispose();
		                windowOpen = false;
		                if(buttonCount<15)
		                app.createOrder();
						buildList();
						redraw();
						emptyBox();
						createBox(c);
		            }
		        });
			}
		}
	};
								
	public myGui(){
		super("WOTS");
		setLayout(new BorderLayout());
		panel = new JPanel();
		panel2= new JPanel();
		panel3= new JPanel();
		
		panel.setBackground(Color.WHITE);
		panel2.setBackground(Color.WHITE);
		panel3.setBackground(Color.WHITE);
		
		panel.setSize(new Dimension(250,20));
		JButton button=new JButton("View Orders");
		JButton create=new JButton("Create Order");
		JButton butt = new JButton("Check-in Order");
		JButton del = new JButton("Delete Order");
		c = new JComboBox<String>();
		
		button.setFont(button.getFont().deriveFont(20.0f));
		create.setFont(button.getFont().deriveFont(20.0f));
		butt.setFont(button.getFont().deriveFont(20.0f));
		del.setFont(button.getFont().deriveFont(20.0f));
		add(panel3,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		add(panel2,BorderLayout.SOUTH);
		panel3.add(button);
		panel3.add(create);
		panel2.add(butt);
		panel2.add(c);
		panel2.add(del);
		button.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1050,500));
		this.setLocation(300,300);
		checkoutButton.addActionListener(go);
		butt.addActionListener(checkIn);
		create.addActionListener(createOrder);
		del.addActionListener(delete);
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt)
	{
	
		redraw();
		emptyBox();
		createBox(c);
		
	}
	
	public static void createBox(JComboBox<String> c){
		checklist = new String[buttonCount];
		checklistCount = 0;
		for(int i = 0; i < buttonCount; i++){
			if(buttonArray[i].getBackground().equals(Color.GRAY)){
				c.addItem(getId(listArray[i]));
				checklist[checklistCount++] = getId(listArray[i]);
			}
		}
	}
	
	public static void emptyBox(){
		c.removeAllItems();
	}
	
	public void redraw(){
		panel.removeAll();
		panel.remove(checkoutButton);
		panel.revalidate();
		panel.repaint();
		for(int i = 0; i < buttonCount; i++){
			 panel.add(buttonArray[i]);
			 buttonArray[i].setFont(buttonArray[i].getFont().deriveFont(40.0f));
			 if(app.checkStatus(Integer.parseInt(getId(listArray[i])))==1){
					buttonArray[i].setBackground(Color.GRAY);
			 }else{
				 buttonArray[i].setBackground(Color.LIGHT_GRAY);
			 }
	
			 final int x = i;
			 
			 if(buttonArray[i].getBackground().equals(Color.GRAY)){
				 buttonArray[i].setEnabled(false);
			 }else{
				 buttonArray[i].setEnabled(true);
				 buttonArray[i].addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	for(int j=0; j < buttonCount; j++){
			            		panel.remove(buttonArray[j]);
			            	}
			            	
			            	y = x;
			            	
			            	panel.remove(alpha);
			            	panel.remove(checkoutButton);
			            	
			            	panel.revalidate();
			            	panel.repaint();
			            	alpha = new JTextArea("\n"+app.viewOrder(Integer.parseInt(getId(listArray[x]))));
			            	alpha.setFont(alpha.getFont().deriveFont(40.0f));
			            	panel.add(alpha);
			            	
			            	panel.add(checkoutButton);
			            	panel.revalidate();
			            	validate();
			            }
			        });
			 }
			 panel.revalidate();
			 panel.repaint();
			 validate();
		}
	}
	
	static public String getId(String l){
		String[] check = new String[2];
		check = l.split(" ");
		return check[1];
	}
	
	public static void main(String[]args)
	{
		myGui gui=new myGui();
		app.initiate();
		buildList();
		gui.toFront();
	}
	
	static void buildList(){
		buttonCount = 0;
		String list = app.viewOrders();
		listArray = list.split("\n");
		for(int i=0; i < listArray.length; i++){
			buttonArray[i] = new JButton(listArray[i]);
			buttonCount++;
			if(buttonCount==15)break;
		}
		createBox(c);
	}
	
}