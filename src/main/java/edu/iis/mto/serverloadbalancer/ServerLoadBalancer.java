package edu.iis.mto.serverloadbalancer;

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
		Server leastUsedServer = getLeastUsedServer(servers);
		leastUsedServer.addVm(vm);
	}

	private Server getLeastUsedServer(Server[] servers) {
		Server leastUsedServer = null;
		for (Server server : servers) {
			if (leastUsedServer == null || leastUsedServer.currentLoadPercentage > server.currentLoadPercentage) {
				leastUsedServer = server;
			}
		}
		return leastUsedServer;
	}
}
