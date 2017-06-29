package model;

import java.util.ArrayList;
import java.util.Date;
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
		int chosenRouter;
		final int NUM_OF_PORTS = 3;
		
		Router router1 = new Router();
		Router router2 = new Router();
		Router router3 = new Router();
		Router router4 = new Router();
		
		
		
		router1.addTableEntry("192.168.1.0", 0, null, new Date(System.currentTimeMillis()));
		router2.addTableEntry("192.168.2.0", 0, null, new Date(System.currentTimeMillis()));
		router3.addTableEntry("192.168.3.0", 0, null, new Date(System.currentTimeMillis()));
		router4.addTableEntry("192.168.4.0", 0, null, new Date(System.currentTimeMillis()));
		
		router1.addAll(router2.getIPFromIndex(0), router2.getHopsFromIndex(0) + 1, "e1", new Date(System.currentTimeMillis()));
		router1.addAll("192.168.1.1", 1, "e2", new Date(System.currentTimeMillis()));
		router1.addAll(router3.getIPFromIndex(0), router3.getHopsFromIndex(0) + 1, "e3", new Date(System.currentTimeMillis()));
		
		
		router2.addAll(router1.getIPFromIndex(0), router1.getHopsFromIndex(0) + 1, "e1", new Date(System.currentTimeMillis()));
		router2.addAll("192.168.2.1", 1, "e2", new Date(System.currentTimeMillis()));
		router2.addAll(router3.getIPFromIndex(0), router3.getHopsFromIndex(0) + 1, "e3", new Date(System.currentTimeMillis()));
		
		router3.addAll(router1.getIPFromIndex(0), router1.getHopsFromIndex(0) + 1, "e1", new Date(System.currentTimeMillis()));
		router3.addAll(router2.getIPFromIndex(0), router2.getHopsFromIndex(0) + 1, "e2", new Date(System.currentTimeMillis()));
		router3.addAll(router4.getIPFromIndex(0), router4.getHopsFromIndex(0) + 1, "e3", new Date(System.currentTimeMillis()));
		
		router4.addAll(router3.getIPFromIndex(0), router3.getHopsFromIndex(0) + 1, "e1", new Date(System.currentTimeMillis()));
		
		
		routers.add(router1);
		routers.add(router2);
		routers.add(router3);
		routers.add(router4);
		
		chosenRouter = rand.nextInt() * 0 + routers.size() - 1;
		
		for(Router router : routers){
			router.displayTable();
		}
		
		switch(chosenRouter){
			case 0:
				router2.removeAllAtIndex(1);
				router3.removeAllAtIndex(1);
				
				break;
			
			case 1:
				router1.removeAllAtIndex(1);
				router3.removeAllAtIndex(2);
				break;
			case 2:
				router1.removeAllAtIndex(3);
				router4.removeAllAtIndex(1);
				break;
			case 3:
				router3.removeAllAtIndex(3);
				break;
		
		}
		routers.remove(chosenRouter);
		
		for(Router router : routers){
			router.displayTable();
		}
		
		
	}

}
