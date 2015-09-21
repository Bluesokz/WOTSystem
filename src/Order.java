import java.util.ArrayList;


public class Order {
	
	//Order variables
	private int id;
	private ArrayList<Product> orderContents = new ArrayList<Product>();
	
	//Order Constructors
	Order(int idnumber){
		id = idnumber;
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
}
