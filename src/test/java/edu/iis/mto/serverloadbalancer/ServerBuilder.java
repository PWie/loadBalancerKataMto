package edu.iis.mto.serverloadbalancer;

import static edu.iis.mto.serverloadbalancer.Server.MAX_LOAD;
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
			addInitialLoad(server);
		}
		return server;
	}

	private void addInitialLoad(Server server) {
		int initVmSize = (int) ((initialLoad / (double) capacity) * MAX_LOAD);
		Vm initVm = vm().ofSize(initVmSize).build();
		server.addVm(initVm);
	}

	public static ServerBuilder server() {
		return new ServerBuilder();
	}

	public ServerBuilder withCurrentLoadOf(double initialLoad) {
		this.initialLoad = initialLoad;
		return this;
	}
}
