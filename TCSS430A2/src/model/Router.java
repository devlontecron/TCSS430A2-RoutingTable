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
	
	public static void removeIP(int x){
		ipArr.remove(x);
	}
	
	public static void removeHop(int x){
		hopsArr.remove(x);
	}
	
	public static void removePorts(int x){
		portsArr.remove(x);
	}
	
	public static void removeTime(int x){
		timeArr.remove(x);
	}
	
	public static void removeAllAtIndex(int x){
		timeArr.remove(x);
		portsArr.remove(x);
		hopsArr.remove(x);
		ipArr.remove(x);
	}
	
	public static void addAll(String ip, int hops, int ports, Date time){
		timeArr.add(time);
		portsArr.add(ports);
		hopsArr.add(hops);
		ipArr.add(ip);
	}
		

}
