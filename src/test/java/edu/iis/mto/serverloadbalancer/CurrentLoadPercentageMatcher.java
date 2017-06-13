package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Patryk Wierzyński
 */

public class CurrentLoadPercentageMatcher extends TypeSafeMatcher<Server> {
	private double expectedPercentage;

	public CurrentLoadPercentageMatcher(double expectedPercentage) {

		this.expectedPercentage = expectedPercentage;
	}

	protected boolean matchesSafely(Server server) {
		return expectedPercentage == server.currentLoadPercentage
				|| Math.abs(expectedPercentage - server.currentLoadPercentage) < 0.01d;
	}

	public void describeTo(Description description) {
		description.appendText("a server with load percentage of ").appendValue(expectedPercentage);
	}
}
