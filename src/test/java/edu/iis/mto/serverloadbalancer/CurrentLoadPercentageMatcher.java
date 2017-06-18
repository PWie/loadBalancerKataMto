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
		return doublesAreEqual(this.expectedPercentage, server.currentLoadPercentage);
	}

	private boolean doublesAreEqual(double d1, double d2) {
		return d1 == d2
				|| Math.abs(d1 - d2) < 0.01d;
	}

	public void describeTo(Description description) {
		description.appendText("a server with load percentage of ").appendValue(expectedPercentage);
	}

	@Override
	protected void describeMismatchSafely(Server server, Description description) {
		description.appendText("a server with load percentage of ").appendValue(server.currentLoadPercentage);
	}

	public static CurrentLoadPercentageMatcher hasLoadPercentageOf(double expectedPercentage) {
		return new CurrentLoadPercentageMatcher(expectedPercentage);
	}
}
