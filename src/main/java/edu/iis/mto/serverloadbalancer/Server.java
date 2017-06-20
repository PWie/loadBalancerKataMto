package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patryk Wierzyński
 */

public class Server {

	public static final double MAX_LOAD = 100.0d;
	private double currentLoadPercentage;
	private int capacity;

	private List<Vm> vms = new ArrayList<Vm>();

	public Server(int capacity) {
		this.capacity = capacity;
	}

	public void addVm(Vm vm) {
		currentLoadPercentage += vmLoad(vm);
		vms.add(vm);
	}

	private double vmLoad(Vm vm) {
		return ((double) vm.getSize() / capacity) * MAX_LOAD;
	}

	public boolean contains(Vm vm) {
		return vms.contains(vm);
	}

	public int vmsCount() {
		return vms.size();
	}

	public boolean canFit(Vm vm) {
		return currentLoadPercentage + vmLoad(vm) <= MAX_LOAD;
	}

	public double getCurrentLoadPercentage() {
		return currentLoadPercentage;
	}

	public int getCapacity() {
		return capacity;
	}
}
