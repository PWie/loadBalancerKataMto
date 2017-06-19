package edu.iis.mto.serverloadbalancer;

/**
 * Created by Patryk Wierzyński
 */

public class ServerLoadBalancer {
	public void balance(Server[] servers, Vm[] vms) {
		for (Vm vm : vms) {
			Server leastUsedServer = null;
			for (Server server : servers) {
				if (leastUsedServer == null || leastUsedServer.currentLoadPercentage > server.currentLoadPercentage) {
					leastUsedServer = server;
				}
			}
			leastUsedServer.addVm(vm);
		}
	}
}
