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
	
	private static ArrayList<String> ipArr = new ArrayList<String>();
	private static ArrayList<Integer> hopsArr = new ArrayList<Integer>();
	private static ArrayList<Integer> portsArr = new ArrayList<Integer>();
	private static ArrayList<Date> timeArr = new ArrayList<Date>();
	
	public static void Router(){
		
		
		
	}

	public static ArrayList<String> getIpArr() {
		return ipArr;
	}

	public static void setIpArr(String ip) {
		ipArr.add(ip);
	}

	public static ArrayList<Integer> getHopsArr() {
		return hopsArr;
	}

	public static void setHopsArr(int hops) {
		hopsArr.add(hops);
	}

	public static ArrayList<Integer> getPortsArr() {
		return portsArr;
	}

	public static void setPortsArr(int ports) {
		portsArr.add(ports);
	}

	public static ArrayList<Date> getTimeArr() {
		return timeArr;
	}

	public static void setTimeArr(Date time) {
		timeArr.add(time);
	}
	
		

}
