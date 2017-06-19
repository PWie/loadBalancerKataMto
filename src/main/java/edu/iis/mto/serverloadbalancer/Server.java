package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patryk Wierzyński
 */

public class Server {

	public static final double MAX_LOAD = 100.0d;
	public double currentLoadPercentage;
	public int capacity;

	List<Vm> vms = new ArrayList<Vm>();

	public Server(int capacity) {
		this.capacity = capacity;
	}

	public void addVm(Vm vm) {
		currentLoadPercentage = ((double) vm.size / capacity) * MAX_LOAD;
		vms.add(vm);
	}

	public boolean contains(Vm vm) {
		return true;
	}

	public int vmsCount() {
		return vms.size();
	}
}
