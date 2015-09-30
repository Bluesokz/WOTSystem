
public class Product {

	//All Product variables
	private int product_id = 0;
	private boolean porous_ready=false;
	private String product_name = "";
	private float price = 0.0F;
	
	//Product constructor methods, 
	//All require a product type, 
	//Porous ware is optional
	Product(int id, String name, float price){
		this.product_id = id;
		this.product_name = name;
		this.price = price;
	}
	
	Product(int id, String name, float price, boolean PWready){
		this.product_id = id;
		this.product_name = name;
		this.price = price;
		this.porous_ready=PWready;
	} 
	
	
	//Get and Set Methods:
	//for type
	String getName(){
		return product_name;
	}
	
	void setName(String t){
		this.product_name = t;
	}
	
	//for Porous ware
	boolean getIsPorousReady(){
		return porous_ready;
	}
	
	void setIsPorousReady(boolean PWready){
		this.porous_ready=PWready;
	}
	
	int getId(){
		return this.product_id;
	}
	
	void setId(int num){
		this.product_id = num;
	}
	
	float getPrice(){
		return this.price;
	}
	
	void setPrice(float num){
		this.price = num;
	}
}
