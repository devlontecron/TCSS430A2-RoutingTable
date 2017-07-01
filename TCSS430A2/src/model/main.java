package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Tommy Warren, Devin Durham
 *	@version 6/27/2017
 */
public class main {

	public static void main(String[] args) {
		
		ArrayList<Router> routersArray = new ArrayList<Router>();
		Random rand = new Random(System.currentTimeMillis());
		int chosenRouter;
		Date timeStamp = new Date(System.currentTimeMillis());
		
		Router router1 = new Router();
		Router router2 = new Router();
		Router router3 = new Router();
		Router router4 = new Router();
		
		
		//Adding each routers loop-back to their table
		router1.addTableEntry("192.168.1.0", 0, null, timeStamp.toString());
		router2.addTableEntry("192.168.2.0", 0, null, timeStamp.toString());
		router3.addTableEntry("192.168.3.0", 0, null, timeStamp.toString());
		router4.addTableEntry("192.168.4.0", 0, null, timeStamp.toString());
		
		//Adding entries for each routers tables
		router1.addTableEntry(router2.getIPFromIndex(0),1, "a1", timeStamp.toString());
		router1.addTableEntry(router3.getIPFromIndex(0),1, "a2", timeStamp.toString());
		
		router2.addTableEntry(router1.getIPFromIndex(0),1, "b1", timeStamp.toString());
		router2.addTableEntry(router3.getIPFromIndex(0),1, "b2", timeStamp.toString());
		
		router3.addTableEntry(router1.getIPFromIndex(0),1, "c1", timeStamp.toString());
		router3.addTableEntry(router2.getIPFromIndex(0),1, "c2", timeStamp.toString());
		router3.addTableEntry(router4.getIPFromIndex(0),1, "c3", timeStamp.toString());
		
		router4.addTableEntry(router3.getIPFromIndex(0),1, "d1", timeStamp.toString());
		
		//adding routers to list of routers
		routersArray.add(router1);
		routersArray.add(router2);
		routersArray.add(router3);
		routersArray.add(router4);
		
		//randomly choosing a router to remove
		chosenRouter = rand.nextInt() * 0 + routersArray.size() - 1;
		
		
		for(Router router : routersArray){
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
		routersArray.remove(chosenRouter);
		
		System.out.println("\nRouter " + (chosenRouter+1) +" has failed");
		
		for(Router router : routersArray){
			router.displayTable();
		}
	}
	
	public static void dfs(){
		//TODO
	}
	
	

}
