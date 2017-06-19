package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Patryk Wierzyński
 */

public class ServerVmsCountMatcher extends TypeSafeMatcher<Server> {
	private int expectedVmsCount;

	public ServerVmsCountMatcher(int expectedVmsCount) {
		this.expectedVmsCount = expectedVmsCount;
	}

	protected boolean matchesSafely(Server server) {
		return server.countVms() == expectedVmsCount;
	}

	@Override
	protected void describeMismatchSafely(Server server, Description description) {
		description.appendText("was a server with vms count of").appendValue(server.countVms());
	}

	public void describeTo(Description description) {
		description.appendText("a server with vms count of").appendValue(expectedVmsCount);
	}
}
