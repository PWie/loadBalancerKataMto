package edu.iis.mto.serverloadbalancer;

/**
 * Created by Patryk Wierzyński
 */

public class Server {

	public double currentLoadPercentage;

	public Server(int capacity) {
		this.capacity = capacity;
	}

	public int capacity;

	public boolean contains(Vm theVm) {
		return true;
	}
}
