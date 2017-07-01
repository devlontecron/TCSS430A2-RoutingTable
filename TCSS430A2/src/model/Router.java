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
	
	public ArrayList<Router> routerArr = new ArrayList<Router>();
	
	public String getIPFromIndex(int x) {
		return ipArr.get(x);
	}

	public int getHopsFromIndex(int x) {
		return hopsArr.get(x);
	}

	public String getPortFromIndex(int x) {
		return portsArr.get(x);
	}

	public String getTimeFromIndex(int x) {
		return timeArr.get(x);
	}

	public Router getRouterFromIndex(int x) {
		return routerArr.get(x);
	}

	public void setRouterArr(Router route) {
		routerArr.add(route);
	}

	public ArrayList<Router> getRouterArr() {
		return routerArr;
	}

	public ArrayList<String> getIpArr() {
		return new ArrayList<String>(ipArr);
	}

	public void setIpArr(String ip) {
		ipArr.add(ip);
	}

	public ArrayList<Integer> getHopsArr() {
		return hopsArr;
	}

	public void setHopsArr(int hops) {
		hopsArr.add(hops);
	}

	public ArrayList<String> getPortsArr() {
		return portsArr;
	}

	public void setPortsArr(String ports) {
		portsArr.add(ports);
	}

	public ArrayList<String> getTimeArr() {
		return timeArr;
	}

	public void setTimeArr(Date time) {
		timeArr.add(time.toString());
	}

	public void removeIP(int x) {
		ipArr.remove(x);
	}

	public void removeHop(int x) {
		hopsArr.remove(x);
	}

	public void removePorts(int x) {
		portsArr.remove(x);
	}

	public void removeTime(int x) {
		timeArr.remove(x);
	}

	public void removeTableEntryAtIndex(int x) {
		timeArr.remove(x);
		portsArr.remove(x);
		hopsArr.remove(x);
		ipArr.remove(x);
	}

	public void addTableEntry(String ip, int hops, String ports, String time) {
		timeArr.add(time);
		portsArr.add(ports);
		hopsArr.add(hops);
		ipArr.add(ip);
	}

	public void displayTable() {
		
		for (int i = 0; i < routerArr.size() ; i++) {
			System.out.printf("%-25s%-5s%1s\n", ipArr.get(i), hopsArr.get(i), timeArr.get(i));
		}
	}

}
