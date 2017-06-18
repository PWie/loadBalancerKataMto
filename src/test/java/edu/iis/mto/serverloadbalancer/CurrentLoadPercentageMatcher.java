package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Patryk Wierzyński
 */
public class CurrentLoadPercentageMatcher extends TypeSafeMatcher<Server> {
	private double expectedLoadPercntage;

	public CurrentLoadPercentageMatcher(double expectedLoadPercntage) {

		this.expectedLoadPercntage = expectedLoadPercntage;
	}

	protected boolean matchesSafely(Server server) {
		return server.currentLoadPercentage == expectedLoadPercntage ||
				Math.abs(server.currentLoadPercentage - expectedLoadPercntage) < 0.01d;
	}

	public void describeTo(Description description) {
		description.appendText("server with load percentage of ").appendValue(expectedLoadPercntage);
	}
}
