package edu.iis.mto.serverloadbalancer;


import org.hamcrest.Matcher;
import org.junit.Test;

import static edu.iis.mto.serverloadbalancer.ServerBuilder.server;
import static edu.iis.mto.serverloadbalancer.ServerLoadPercentageMatcher.hasLoadPercentageOf;
import static edu.iis.mto.serverloadbalancer.VmBuilder.vm;
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

	@Test
	public void balancingOneVms_oneServerIsFilled() throws Exception {
		Server theServer = a(server().withCapacity(1));
		Vm theVm = a(vm().ofSize(1));

		balance(aListOfServersWith(theServer), aListOfVmsWith(theVm));

		assertThat(theServer, hasLoadPercentageOf(100.0d));
	}

	@Test
	public void balancingOneVms_oneServerIsFilledInTenPercent() throws Exception {
		Server theServer = a(server().withCapacity(10));
		Vm theVm = a(vm().ofSize(1));

		balance(aListOfServersWith(theServer), aListOfVmsWith(theVm));

		assertThat(theServer, hasLoadPercentageOf(10.0d));
	}

	@Test
	public void balancingTwoVms_andOneServer() throws Exception {
		Server theServer = a(server().withCapacity(10));
		Vm theFirstVm = a(vm().ofSize(1));
		Vm theSecondVm = a(vm().ofSize(1));

		balance(aListOfServersWith(theServer), aListOfVmsWith(theFirstVm, theSecondVm));

		assertThat(theServer, hasVmsCountOf(2));
		assertThat("the server should contain first vm", theServer.contains(theFirstVm));
		assertThat("the server should contain second vm", theServer.contains(theSecondVm));
	}

	private Matcher<? super Server> hasVmsCountOf(int expectedVmsCount) {
		return new ServerVmsCountMatcher(expectedVmsCount);
	}

	private void balance(Server[] servers, Vm[] vms) {
		new ServerLoadBalancer().balance(servers, vms);
	}

	private Server[] aListOfServersWith(Server... servers) {
		return servers;
	}

	private Vm[] aListOfVmsWith(Vm... vms) {
		return vms;
	}

	private Vm[] anEmptyListOfVms() {
		return new Vm[0];
	}

	private <T> T a(Builder<T> builder) {
		return builder.build();
	}

}
