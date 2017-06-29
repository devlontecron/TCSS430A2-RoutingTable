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
	private static ArrayList<Date> timeArr = new ArrayList<Date>();
	public  static ArrayList<Router> routerArr = new ArrayList<Router>();
	
	public static void Router(){
		
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
	
	public static Date getTimeFromIndex(int x){
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
	
	public static void addAll(String ip, int hops, String ports, Date time){
		timeArr.add(time);
		portsArr.add(ports);
		hopsArr.add(hops);
		ipArr.add(ip);
	}
		

}
