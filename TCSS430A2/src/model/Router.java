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
	private static ArrayList<String> portsArr = new ArrayList<String>();
	private static ArrayList<String> timeArr = new ArrayList<String>();
	public  static ArrayList<Router> routerArr = new ArrayList<Router>();
	
	private static Date myTime = new Date();
	
	public static void Router(){
		
		addTableEntry("192",0,"PORT", myTime.toString());
		
	}
	
	public static String getIPFromIndex(int x){
		return ipArr.get(x);
	}
	
	public static int getHopsFromIndex(int x){
		return hopsArr.get(x);
	}
	
	public static String getPortFromIndex(int x){
		return portsArr.get(x);
	}
	
	public static String getTimeFromIndex(int x){
		return timeArr.get(x);
	}
	
	public static Router getRouterFromIndex(int x){
		return routerArr.get(x);
	}
	
	public static void setRouterArr(Router route) {
		routerArr.add(route);
	}
	
	public static ArrayList<Router> getRouterArr(){
		return routerArr;
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

	public static ArrayList<String> getPortsArr() {
		return portsArr;
	}

	public static void setPortsArr(String ports) {
		portsArr.add(ports);
	}

	public static ArrayList<String> getTimeArr() {
		return timeArr;
	}

	public static void setTimeArr(Date time) {
		timeArr.add(time.toString());
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
	

	
	public static void removeTableEntryAtIndex(int x){
		timeArr.remove(x);
		portsArr.remove(x);
		hopsArr.remove(x);
		ipArr.remove(x);
	}
	
	public static void addTableEntry(String ip, int hops, String ports, String time){
		timeArr.add(time);
		portsArr.add(ports);
		hopsArr.add(hops);
		ipArr.add(ip);
	}
	
	public void displayTable(){
		//TODO
	}

}
