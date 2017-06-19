package edu.iis.mto.serverloadbalancer;

/**
 * Created by Patryk Wierzyński
 */

public class Server {

	public double currentLoadPercentage;
	public int capacity;

	public Server(int capacity) {
		this.capacity = capacity;
	}
}
