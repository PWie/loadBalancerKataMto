package edu.iis.mto.serverloadbalancer;

import static edu.iis.mto.serverloadbalancer.VmBuilder.vm;

/**
 * Created by Patryk Wierzyński
 */

public class ServerBuilder implements Builder<Server> {
	private int capacity;
	private double initialLoad;

	public ServerBuilder withCapacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public Server build() {
		Server server = new Server(capacity);
		if (initialLoad > 0) {
			int initVmSize = (int) (((double) initialLoad / capacity) * 100.0d);
			Vm initVm = vm().ofSize(initVmSize).build();
			server.addVm(initVm);
		}
		return server;
	}

	public static ServerBuilder server() {
		return new ServerBuilder();
	}

	public ServerBuilder withCurrentLoadOf(double initialLoad) {
		this.initialLoad = initialLoad;
		return this;
	}
}
