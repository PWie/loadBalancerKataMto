package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patryk Wierzyński
 */

public class ServerLoadBalancer {

	public void balance(Server[] servers, Vm[] vms) {
		for (Vm vm : vms) {
			addVmToLeastUsedCapableServer(servers, vm);
		}
	}

	private void addVmToLeastUsedCapableServer(Server[] servers, Vm vm) {
		List<Server> capableServers = getCapableServers(servers, vm);
		Server leastUsedServer = getLeastUsedServer(capableServers);
		if (leastUsedServer != null) {
			leastUsedServer.addVm(vm);
		}
	}

	private List<Server> getCapableServers(Server[] servers, Vm vm) {
		List<Server> capableServers = new ArrayList<Server>();
		for (Server server : servers) {
			if (server.canFit(vm)) {
				capableServers.add(server);
			}
		}
		return capableServers;
	}

	private Server getLeastUsedServer(List<Server> servers) {
		Server leastUsedServer = null;
		for (Server server : servers) {
			if (leastUsedServer == null || leastUsedServer.getCurrentLoadPercentage() > server.getCurrentLoadPercentage()) {
				leastUsedServer = server;
			}
		}
		return leastUsedServer;
	}
}
