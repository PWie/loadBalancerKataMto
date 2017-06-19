package edu.iis.mto.serverloadbalancer;


import org.junit.Test;

import static edu.iis.mto.serverloadbalancer.ServerBuilder.server;
import static edu.iis.mto.serverloadbalancer.ServerLoadPercentageMatcher.hasLoadPercentageOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ServerLoadBalancerTest {
	@Test
	public void itCompiles() {
		assertThat(true, equalTo(true));
	}

	@Test
	public void balancingNoVms_serverStaysEmpty() throws Exception {
		Server theServer = a(server().withCapacity(1));

		balance(aListOfServersWith(theServer), anEmptyListOfVms());

		assertThat(theServer, hasLoadPercentageOf(0.0d));
	}

	private void balance(Server[] servers, Vm[] vms) {
		new ServerLoadBalancer().balance(servers, vms);
	}

	private Server[] aListOfServersWith(Server... servers) {
		return servers;
	}

	private Vm[] anEmptyListOfVms() {
		return new Vm[0];
	}

	private Server a(ServerBuilder builder) {
		return builder.build();
	}
}
