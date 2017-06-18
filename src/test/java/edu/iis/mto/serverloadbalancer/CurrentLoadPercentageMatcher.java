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
		return doublesAreEqual(server.currentLoadPercentage, this.expectedLoadPercntage);
	}

	private boolean doublesAreEqual(double d1, double d2) {
		return d1 == d2 ||
				Math.abs(d1 - d2) < 0.01d;
	}

	public void describeTo(Description description) {
		description.appendText("server with load percentage of ").appendValue(expectedLoadPercntage);
	}

	public static CurrentLoadPercentageMatcher hasLoadPercentageOf(double expectedLoadPercntage) {
		return new CurrentLoadPercentageMatcher(expectedLoadPercntage);
	}
}
