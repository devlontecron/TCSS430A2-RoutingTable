package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Tommy Warren
 *	@version 6/27/2017
 */
public class main {

	public static void main(String[] args) {
		
		ArrayList<Router> routers = new ArrayList<Router>();
		Random rand = new Random(System.currentTimeMillis());
		
		
		Router router1 = new Router();
		Router router2 = new Router();
		Router router3 = new Router();
		Router router4 = new Router();
		
		
		router1.addNode("e1", "192.168.1.0");
		router1.addNode("e2", router2);
		router1.addNote("e3", router3);
		
		router2.addNode("e1", router1);
		router2.addNode("e2", "192.168.2.0");
		router2.addNode("e3", router3);
		
		router3.addNode("e1", router2);
		router3.addNode("e2", router1);
		router3.addNode("e3", router4);
		
		router4.addNode("e1", "192.168.3.0");
		router4.addNode("e2", "192.168.4.0");
		router4.addNode("e3", "192.168.5.0");
		
		routers.add(router1);
		routers.add(router2);
		routers.add(router3);
		routers.add(router4);
		
		for(Router router : routers){
			router.displayTable();
		}
		
		// Remove a random router from the network.
		routers.remove(rand.nextInt() * 0 + routers.size() - 1);
		
		
		for(Router router : routers){
			router.updateTable();
			router.displayTable();
		}
		
		
	}
	
	public static void addNode(String ipAddress){
		
		
	}

}
