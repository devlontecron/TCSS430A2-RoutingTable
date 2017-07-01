package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author Tommy Warren, Devin Durham,
 * @version 6/27/2017
 *
 */

public class Router {

	private ArrayList<String> ipArr = new ArrayList<String>();
	private ArrayList<Integer> hopsArr = new ArrayList<Integer>();
	private ArrayList<String> portsArr = new ArrayList<String>();
	private ArrayList<String> timeArr = new ArrayList<String>();
	private ArrayList<Router> routerArr = new ArrayList<Router>();

	private Date myTime = new Date();

	public String getIPFromIndex(int x) {
		return this.ipArr.get(x);
	}

	public int getHopsFromIndex(int x) {
		return this.hopsArr.get(x);
	}

	public String getPortFromIndex(int x) {
		return this.portsArr.get(x);
	}

	public String getTimeFromIndex(int x) {
		return this.timeArr.get(x);
	}

	public Router getRouterFromIndex(int x) {
		return this.routerArr.get(x);
	}

	public void setRouterArr(Router route) {
		this.routerArr.add(route);
	}

	public ArrayList<Router> getRouterArr() {
		return this.routerArr;
	}

	public ArrayList<String> getIpArr() {
		return this.ipArr;
	}

	public void setIpArr(String ip) {
		this.ipArr.add(ip);
	}

	public ArrayList<Integer> getHopsArr() {
		return this.hopsArr;
	}

	public void setHopsArr(int hops) {
		this.hopsArr.add(hops);
	}

	public ArrayList<String> getPortsArr() {
		return this.portsArr;
	}

	public void setPortsArr(String ports) {
		this.portsArr.add(ports);
	}

	public ArrayList<String> getTimeArr() {
		return this.timeArr;
	}

	public void setTimeArr(Date time) {
		this.timeArr.add(time.toString());
	}

	public void removeIP(int x) {
		this.ipArr.remove(x);
	}

	public void removeHop(int x) {
		this.hopsArr.remove(x);
	}

	public void removePorts(int x) {
		this.portsArr.remove(x);
	}

	public void removeTime(int x) {
		this.timeArr.remove(x);
	}

	public void removeTableEntryAtIndex(int x) {
		this.timeArr.remove(x);
		this.portsArr.remove(x);
		this.hopsArr.remove(x);
		this.ipArr.remove(x);
	}

	public void addTableEntry(String ip, int hops, String ports, String time) {
		this.timeArr.add(time);
		this.portsArr.add(ports);
		this.hopsArr.add(hops);
		this.ipArr.add(ip);
	}

	public void displayTable() {
		
		System.out.println("\nPort   		Ip Adrress   Hops   	Time");
		for (int i = 0; i < ipArr.size(); i++) {
			System.out.printf("%-15s%-17s%-5s%1s", portsArr.get(i), ipArr.get(i),hopsArr.get(i),timeArr.get(i));
			System.out.println("");
			
		}

		
	}

}
