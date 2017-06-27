package model;

/**
 * 
 * @author Tommy Warren
 *	@version 6/27/2017
 */
public class main {

	public static void main(String[] args) {
		Router router1 = new Router();
		Router router2 = new Router();
		Router router3 = new Router();
		Router router4 = new Router();
		
		router1.addNode("e1", "192.168.1.0");
		router1.addNode("e2", router2);
		router2.addNode("e1", router1);
		router3.addNode("e2", router2);
		router1.addNode("e1", "192.168.1.0");
		router1.addNode("e2", router2);

	}

}
