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
		Date timeStamp = new Date(System.currentTimeMillis());
		
		Router router1 = new Router();
		Router router2 = new Router();
		Router router3 = new Router();
		Router router4 = new Router();
		
		
		
		router1.addTableEntry("192.168.1.0", 0, null, timeStamp.toString());
		router2.addTableEntry("192.168.2.0", 0, null, timeStamp.toString());
		router3.addTableEntry("192.168.3.0", 0, null, timeStamp.toString());
		router4.addTableEntry("192.168.4.0", 0, null, timeStamp.toString());
		
		router1.addTableEntry(router2.getIPFromIndex(0), router2.getHopsFromIndex(0) + 1, "e1", timeStamp.toString());
		router1.addTableEntry("192.168.1.1", 1, "e2", timeStamp.toString());
		router1.addTableEntry(router3.getIPFromIndex(0), router3.getHopsFromIndex(0) + 1, "e3", timeStamp.toString());
		
		
		router2.addTableEntry(router1.getIPFromIndex(0), router1.getHopsFromIndex(0) + 1, "e1", timeStamp.toString());
		router2.addTableEntry("192.168.2.1", 1, "e2", timeStamp.toString());
		router2.addTableEntry(router3.getIPFromIndex(0), router3.getHopsFromIndex(0) + 1, "e3", timeStamp.toString());
		
		router3.addTableEntry(router1.getIPFromIndex(0), router1.getHopsFromIndex(0) + 1, "e1", timeStamp.toString());
		router3.addTableEntry(router2.getIPFromIndex(0), router2.getHopsFromIndex(0) + 1, "e2", timeStamp.toString());
		router3.addTableEntry(router4.getIPFromIndex(0), router4.getHopsFromIndex(0) + 1, "e3", timeStamp.toString());
		
		router4.addTableEntry(router3.getIPFromIndex(0), router3.getHopsFromIndex(0) + 1, "e1", timeStamp.toString());
		
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
				router2.removeTableEntryAtIndex(1);
				router3.removeTableEntryAtIndex(1);
				break;
			
			case 1:
				router1.removeTableEntryAtIndex(1);
				router3.removeTableEntryAtIndex(2);
				break;
			case 2:
				router1.removeTableEntryAtIndex(3);
				router4.removeTableEntryAtIndex(1);
				break;
			case 3:
				router3.removeTableEntryAtIndex(3);
				break;
		
		}
		routers.remove(chosenRouter);
		
		for(Router router : routers){
			router.displayTable();
		}
	}

}
