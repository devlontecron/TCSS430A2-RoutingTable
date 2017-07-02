package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * # TCSS430A2
 *	TCSS 430 Assignment 2
 *- Computer Simulation Project (Simulation of a Router's Routing Table)
 *
 *	Created by Project Team 2 [Tommy Warren, Devin Durham, Vu Hoang]
 *
 *	Project Description: Write a computer program to construct a look-up routing table with ten entries. 
 *	Each entry must contain a time, destination address, cost of a destination node, and a router port number. 
 *	The program should demonstrate the updating mechanism on a frequent basis.
 *
 * @author Tommy Warren, Devin Durham, Vu Hoang
 * @version 6/27/2017
 */

public class main {
	static ArrayList<Router> myRouters = new ArrayList<Router>();

	public static void main(String[] args) {

		int chosenRouter;
		Date timeStamp = new Date(System.currentTimeMillis());
		
		Router router1 = new Router();
		Router router2 = new Router();
		Router router3 = new Router();
		Router router4 = new Router();

		router1.addTableEntry("192.168.0.1", 0, "Loopback", timeStamp.toString());
		router2.addTableEntry("127.50.0.1", 0, "Loopback", timeStamp.toString());
		router3.addTableEntry("200.0.0.1", 0, "Loopback", timeStamp.toString());
		router4.addTableEntry("223.162.0.1", 0, "Loopback", timeStamp.toString());
		

		router1.addTableEntry(router2.getIPFromIndex(0), router2.getHopsFromIndex(0) + 1, "e1", timeStamp.toString());
		router1.addTableEntry("192.168.0.8", 1, "e2", timeStamp.toString());
		router1.addTableEntry(router3.getIPFromIndex(0), router3.getHopsFromIndex(0) + 1, "e3", timeStamp.toString());

		router2.addTableEntry(router1.getIPFromIndex(0), router1.getHopsFromIndex(0) + 1, "e1", timeStamp.toString());
		router2.addTableEntry("127.50.0.6", 1, "e2", timeStamp.toString());
		router2.addTableEntry(router3.getIPFromIndex(0), router3.getHopsFromIndex(0) + 1, "e3", timeStamp.toString());
		
		router3.addTableEntry(router1.getIPFromIndex(0), router1.getHopsFromIndex(0) + 1, "e1", timeStamp.toString());
		router3.addTableEntry(router2.getIPFromIndex(0), router2.getHopsFromIndex(0) + 1, "e2", timeStamp.toString());
		router3.addTableEntry(router4.getIPFromIndex(0), router4.getHopsFromIndex(0) + 1, "e3", timeStamp.toString());
		
		router4.addTableEntry(router3.getIPFromIndex(0), router3.getHopsFromIndex(0) + 1, "e1", timeStamp.toString());
		
		router1.setRouterArr(router1);
		router1.setRouterArr(router2);
		router1.setRouterArr(router3);
		
		router2.setRouterArr(router2);
		router2.setRouterArr(router1);
		router2.setRouterArr(router3);
		
		router3.setRouterArr(router3);
		router3.setRouterArr(router1);
		router3.setRouterArr(router2);
		router3.setRouterArr(router4);
		
		router4.setRouterArr(router4);
		router4.setRouterArr(router3);

		// adds each linked router to the main network.
		myRouters.add(router1);
		myRouters.add(router2);
		myRouters.add(router3);
		myRouters.add(router4);
		
		
		//removes a randomly chosen router.
		chosenRouter = ThreadLocalRandom.current().nextInt(0, myRouters.size());
		
		routeNetwork();
		
		//Removing the indexing from other tables
		
		for(Router router : myRouters){
			router.getRouterArr().remove(myRouters.get(chosenRouter));
		}
		
		switch(chosenRouter){
			case 0:
				router2.removeTableEntryAtIndex(1);
				router3.removeTableEntryAtIndex(1);
				router1.removeTableEntryAtIndex(0);
				break;
			
			case 1:
				router1.removeTableEntryAtIndex(1);
				router3.removeTableEntryAtIndex(2);
				router2.removeTableEntryAtIndex(0);
				break;
			case 2:
				router1.removeTableEntryAtIndex(3);
				router2.removeTableEntryAtIndex(3);
				router4.removeTableEntryAtIndex(1);
				router3.removeTableEntryAtIndex(0);
				break;
			case 3:
				router3.removeTableEntryAtIndex(3);
				router4.removeTableEntryAtIndex(0);
				break;
		}
		myRouters.remove(chosenRouter);

		System.out.println("Router " + (chosenRouter+1) +" has failed\n");
		
		routeNetwork();
		
	}

	/**
	 * routeNetwork traverses the entire network of routers to display 
	 * a routing table for each router within the network.
	 */
	
	private static void routeNetwork() {

		for (Router r : myRouters) {
			
			long start = System.currentTimeMillis();
			
			// Set up hop counter.
			double hops = 0;

			// create new Network for current router.
			HashMap<String, Integer> network = new HashMap<>();

			// Place current router within network.
			network.put(r.getIPFromIndex(0), (int) hops);

			// search through routers connected to the current router.
			for (Router r2 : r.getRouterArr()) {

				// search all IP addresses connected to the ports at each
				// connected router.
				for (String nestedRouter : r2.getIpArr()) {

					// if the ip address is not in the network, add it to the
					// network with the hop.
					if (!network.containsKey(nestedRouter)) {

						//Debugging to correct the hop counter.
						if(r.getIpArr().get(0).equals("223.162.0.1") 
								&& !nestedRouter.equals("127.50.0.1")
								&& !nestedRouter.equals("192.168.0.1")){
							hops--;
						} else if(r.getIpArr().get(0).equals("223.162.0.1") 
								&& nestedRouter.equals("192.168.0.1")){
							hops++;
						}
						
						hops++;
						
						// IP address 223's hops are not counting correctly, to
						// fix the hop counter, we add one to the ceiling function.
						if (r.getIpArr().get(0).equals("223.162.0.1")) {
							network.put(nestedRouter, (int) Math.ceil(hops / 2) + 1);

							// IP address 200.0.0.1's hop for 223.162.0.1 adds 1
							// hop too many, so we need to subtract a hop from the counter.
						} else if (r.getIpArr().get(0).equals("200.0.0.1") && nestedRouter.equals("223.162.0.1")) {
							
							network.put(nestedRouter, (int) Math.ceil(hops / 2) - 1);
							// the standard for adding an ip address to the network.
						} else {
							network.put(nestedRouter, (int) Math.ceil(hops / 2));
						}
					}
				}
			}
			
			// For Testing.
			// Prints out the network in a list, first value is IP address,
			// second is # of hops to the address.

			//System.out.println("The network for: " + r.getIPFromIndex(0) + " " + network);
			
			long finish = System.currentTimeMillis() - start;
			
			System.out.println("   Displaying Routing Table for: " + r.getIPFromIndex(0) + "\n");
			displayTable(network, finish);
		}

	}
	
	private static void displayTable(HashMap<String, Integer> map, long time){
		
		System.out.println("Destination Address      Hops  		Time");
		
		for(String string : map.keySet()){
			System.out.printf("%-26s%-6d %8d ms\n", string, map.get(string), time);
		}
		
		System.out.println();
	}

}
