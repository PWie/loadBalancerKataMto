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
		return doublesAreEqual(this.expectedLoadPercentage, server.currentLoadPercentage);
	}

	private boolean doublesAreEqual(double d1, double d2) {
		return d1 == d2 || Math.abs(d1 - d2) < 0.01d;
	}

	public void describeTo(Description description) {
		description.appendText("a server with load percentage of").appendValue(expectedLoadPercentage);
	}

	public static ServerLoadPercentageMatcher hasLoadPercentageOf(double expectedLoadPercentage) {
		return new ServerLoadPercentageMatcher(expectedLoadPercentage);
	}
}
