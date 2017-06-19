package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Patryk Wierzyński
 */

public class ServerLoadPercentageMatcher extends TypeSafeMatcher<Server> {
	private double expectedLoadPercentage;

	public ServerLoadPercentageMatcher(double expectedLoadPercentage) {
		this.expectedLoadPercentage = expectedLoadPercentage;
	}

	protected boolean matchesSafely(Server server) {
		return expectedLoadPercentage == server.currentLoadPercentage ||
				Math.abs(expectedLoadPercentage - server.currentLoadPercentage) < 0.01d;
	}

	public void describeTo(Description description) {
		description.appendText("a server with load percentage of").appendValue(expectedLoadPercentage);
	}
}
