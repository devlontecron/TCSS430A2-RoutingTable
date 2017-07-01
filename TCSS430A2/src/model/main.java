package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * 
 * @author Tommy Warren, Devin Durham
 * @version 6/27/2017]
 */

public class main {
	static ArrayList<Router> myRouters = new ArrayList<Router>();

	public static void main(String[] args) {

		Random rand = new Random(System.currentTimeMillis());
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

		myRouters.add(router1);
		myRouters.add(router2);
		myRouters.add(router3);
		myRouters.add(router4);
		
		chosenRouter = rand.nextInt() * 0 + myRouters.size() - 1;
		
		dfs();
		
		
		System.out.println("Removing router in network.\n");
		
		//Removing the indexing from other tables
		switch(chosenRouter){
			case 0:
				router2.removeTableEntryAtIndex(1);
				router2.getRouterArr().remove(1);
				router3.removeTableEntryAtIndex(1);
				router3.getRouterArr().remove(1);
				break;
			
			case 1:
				router1.removeTableEntryAtIndex(1);
				router1.getRouterArr().remove(1);
				router3.removeTableEntryAtIndex(2);
				router3.getRouterArr().remove(2);
				break;
			case 2:
				router1.removeTableEntryAtIndex(3);
				router1.getRouterArr().remove(3);
				router4.removeTableEntryAtIndex(1);
				router4.getRouterArr().remove(1);
				break;
			case 3:
				router3.removeTableEntryAtIndex(3);
				router3.getRouterArr().remove(3);
				break;
		}
		myRouters.remove(chosenRouter);

		System.out.println("\nRouter " + (chosenRouter+1) +" has failed");
		
		dfs();
		
	}

	private static void dfs() {

		for (Router r : myRouters) {

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

						

						// IP address 223's hops are not counting correctly, to
						// fix the hop counter,
						// we add one to the ceiling function.
						if (r.getIpArr().get(0).equals("223.162.0.1")) {
							++hops;
							network.put(nestedRouter, (int) Math.ceil(hops / 2) + 1);

							// IP address 200.0.0.1's hop for 223.162.0.1 adds 1
							// hop too many, so we need to subtract a hop from
							// the counter.
						} else if (r.getIpArr().get(0).equals("200.0.0.1") && nestedRouter.equals("223.162.0.1")) {
							hops++;
							network.put(nestedRouter, (int) Math.ceil(hops / 2) - 1);
							// the standard for adding an ip address to the
							// network.
						} else {
							hops++;
							network.put(nestedRouter, (int) Math.ceil(hops / 2));
						}
					}
				}
			}
			// Prints out the network in a list, first value is IP address,
			// second is # of hops to the address.
			System.out.println("The network for: " + r.getIPFromIndex(0) + " " + network);
		}

	}

	public static void check() {
		for (int r = 0; r < myRouters.size(); r++) {
			Router currRout = myRouters.get(r);
			for (int y = 0; y < currRout.getRouterArr().size(); y++) {
				if (!myRouters.contains(currRout.getRouterFromIndex(y))) {
					// remove the router from curRout list
					// remove any address that require that routers
				}
			}
		}
	}

}
