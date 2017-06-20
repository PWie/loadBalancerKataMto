package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patryk Wierzyński
 */

public class ServerLoadBalancer {
	public void balance(Server[] servers, Vm[] vms) {
		for (Vm vm : vms) {
			addVmToLeastUsedServer(servers, vm);
		}
	}

	private void addVmToLeastUsedServer(Server[] servers, Vm vm) {
		List<Server> capableServers = new ArrayList<Server>();
		for (Server server : servers) {
			if (server.canFit(vm)) {
				capableServers.add(server);
			}
		}
		Server leastUsedServer = getLeastUsedServer(capableServers);
		if (leastUsedServer != null) {
			leastUsedServer.addVm(vm);
		}
	}

	private Server getLeastUsedServer(List<Server> servers) {
		Server leastUsedServer = null;
		for (Server server : servers) {
			if (leastUsedServer == null || leastUsedServer.currentLoadPercentage > server.currentLoadPercentage) {
				leastUsedServer = server;
			}
		}
		return leastUsedServer;
	}
}
