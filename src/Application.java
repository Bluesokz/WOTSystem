import java.sql.*;
import java.util.ArrayList;


public class Application {
	
	static int orderCount = 0;
	static ArrayList<Order> orders = new ArrayList<Order>();
	static Connection conn = null;
	static Statement stmt = null;

	static void createOrder(){
		try{
			stmt = conn.createStatement();
			String sql = "INSERT INTO `wots`.`customer_order` (`state`, `quantity`, `idproduct`) VALUES ('0', '1', '22');";
			stmt.executeUpdate(sql);	
		}catch(SQLException se){
			  System.out.println("SQL Exception");
		      se.printStackTrace();
	    }catch(Exception e){
		      e.printStackTrace();
		}finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
		      }
		}
	}
	
	static void deleteOrder(String index){
		try{
			stmt = conn.createStatement();
			String sql = "DELETE FROM `wots`.`customer_order` WHERE `idorder`='"+index+"';";
			stmt.executeUpdate(sql);	
		}catch(SQLException se){
			  System.out.println("SQL Exception");
		      se.printStackTrace();
	    }catch(Exception e){
		      e.printStackTrace();
		}finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
		      }
		}
	}
	
	String viewOrders(){
		String text = "";
		try{
			stmt = conn.createStatement();
			String sql = "SELECT idorder FROM customer_order";
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()){
		       int id  = rs.getInt("idorder");
		       
		       text += "OrderID: " + id + "\n";

		       orderCount=id;
		    }
			rs.close();
			
		}catch(SQLException se){
			  System.out.println("SQL Exception");
		      se.printStackTrace();
	    }catch(Exception e){
		      e.printStackTrace();
		}finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
		      }
		}
		return text;
	}
	
	String viewOrder(int i){
		String output = "";
		try{
			stmt = conn.createStatement();
			String sql;
			
			sql = "SELECT * FROM new_view WHERE (`idorder` ="+i+")";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int id  = rs.getInt("idorder");
		        int quantity  = rs.getInt("quantity");
		        int idproduct  = rs.getInt("idproduct");
		        String name = rs.getString("productname");
		        String desc = rs.getString("description"); 
		        output+="Order Id: "+ id+"\nQuantity: "+quantity+"\nProduct Id: "+idproduct+"\nProduct Name: "+name+"\nDescription: "+desc;
			}
			rs.close();
		}catch(SQLException se){
			  System.out.println("SQL Exception");
		      se.printStackTrace();
	    }catch(Exception e){
		      e.printStackTrace();
		}finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
		      }
		}
		
		return output;
	}
	
	int checkStatus(int i){
		int output = 0;
		try{
			stmt = conn.createStatement();
			String sql;
			
			sql = "SELECT state FROM new_view WHERE (`idorder` ="+i+")";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
		        output  = rs.getInt("state");
			}
			rs.close();
			
		}catch(SQLException se){
			  System.out.println("SQL Exception");
		      se.printStackTrace();
	    }catch(Exception e){
		      e.printStackTrace();
		}finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
		      }
		}
		
		return output;
	}
	
	void checkOut(int i){
		try{
			stmt = conn.createStatement();
			String sql;
			
			sql = "UPDATE `wots`.`customer_order` SET `state`='1' WHERE `idorder`='"+i+"';";
			
			stmt.executeUpdate(sql);	
		}catch(SQLException se){
			  System.out.println("SQL Exception");
		      se.printStackTrace();
	    }catch(Exception e){
		      e.printStackTrace();
		}finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
		      }
		}
		
	}
	
	void checkIn(String i){
		try{
			stmt = conn.createStatement();
			String sql;

			sql = "UPDATE `wots`.`customer_order` SET `state`='0' WHERE `idorder`='"+i+"';";
			
			stmt.executeUpdate(sql);	
		}catch(SQLException se){
			  System.out.println("SQL Exception");
		      se.printStackTrace();
	    }catch(Exception e){
		      e.printStackTrace();
		}finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
		      }
		}
		
	}
		
	void initiate(){
		try{
			
			String host = "jdbc:mysql://10.50.15.58:3306/wots";
			String username = "root"; 
			String password = "password";
			conn = DriverManager.getConnection(host,username,password);
			
		}catch(SQLException se){
			  System.out.println("SQL Exception");
		      se.printStackTrace();
	    }catch(Exception e){
		      e.printStackTrace();
		}finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
		      }
		}
	}
}