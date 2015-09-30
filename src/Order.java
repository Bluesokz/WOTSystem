import java.util.ArrayList;


public class Order {
	
	//Order variables
	private int id;
	private float total=0.0F;
	private boolean checkedIn = true;
	private ArrayList<Product> orderContents = new ArrayList<Product>();
	
	//Order Constructors
	Order(int idnumber){
		id = idnumber;
	}
	
	float totalOrder(){
		total=0;
		for(int i = 0; i < orderContents.size(); i++){
			total+=orderContents.get(i).getPrice();
		}
		
		return total;
	}
	
	int getId(){
		return this.id;
	}
	
	void setId(int newId){
		this.id = newId;
	}
	
	Product getProduct(int position){
		return orderContents.get(position);
	}
	
	void setProduct(int position, Product alpha){
		orderContents.set(position, alpha);
	}
	
	void addProduct(Product alpha){
		orderContents.add(alpha);
	}
	
	int getSize(){
		return orderContents.size();
	}
	
	boolean getCheckedIn(){
		return this.checkedIn;
	}
	
	void setCheckedIn(boolean status){
		this.checkedIn = status;
	}
}
