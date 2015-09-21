
public class Product {

	//All Product variables
	private boolean isPorous=false;
	private String type = "";
	
	//Product constructor methods, 
	//All require a product type, 
	//Porous ware is optional
	Product(String type){
		this.type = type;
	}
	
	Product(String type, boolean isPW){
		this.type = type;
		this.isPorous=isPW;
	} 
	
	
	//Get and Set Methods:
	//for type
	String getType(){
		return type;
	}
	
	void setType(String t){
		this.type = t;
	}
	
	//for Porous ware
	boolean getIsPorous(){
		return isPorous;
	}
	
	void setIsPorous(boolean isPW){
		this.isPorous=isPW;
	}
}
