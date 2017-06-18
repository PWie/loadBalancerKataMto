package edu.iis.mto.serverloadbalancer;

/**
 * Created by Patryk Wierzyński
 */

public class Server {

	public static final double MAX_LOAD = 100.0d;
	public double currentLoadPercentage;
	public double capacity;

	public Server(double capacity) {
		this.capacity = capacity;
	}

	public boolean contains(Vm vm) {
		return true;
	}

	public void addVm(Vm vm) {
		currentLoadPercentage = (double)vm.size / capacity * MAX_LOAD;
	}
}
