
public class Application {
	public static void main (String[] args){
		Product alpha = new Product("Gnomeo", true);
		Product beta = new Product("Juliet", true);
		Order order1 = new Order(32);
				
		order1.addProduct(alpha);
		order1.addProduct(beta);
		
		for(int i = 0; i < order1.getSize(); i++){
			System.out.println(order1.getProduct(i).getType());
		}
	}
}
