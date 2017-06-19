package edu.iis.mto.serverloadbalancer;

/**
 * Created by Patryk Wierzyński
 */

public class ServerLoadBalancer {
	public void balance(Server[] servers, Vm[] vms) {
		if (vms.length > 0) {
			servers[0].addVm(vms[0]);
		}
	}
}
