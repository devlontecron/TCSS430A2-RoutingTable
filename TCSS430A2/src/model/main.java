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
		
		router2.addNode("e1", router1);
		
		router3.addNode("e1", router2);
		router3.addNode("e2", router1);
		
		router3.addNode("e3", router4);
		
		routers.add(router1);
		routers.add(router2);
		routers.add(router3);
		routers.add(router4);
		
		
		routers.remove(rand.nextInt() * 0 + 3);
		

	}

}
