package edu.iis.mto.serverloadbalancer;

/**
 * Created by Patryk Wierzyński
 */

public class Server {

	public static final double MAX_LOAD = 100.0d;
	public double currentLoadPercentage;

	public Server(int capacity) {
		this.capacity = capacity;
	}

	public int capacity;

	public boolean contains(Vm theVm) {
		return true;
	}

	public void addVm(Vm vm) {
		currentLoadPercentage = (double)vm.size / capacity * MAX_LOAD;
	}
}
