package io.davidarchanjo.code.projections;

public interface PersonSummary {

	String getName();
	AddressSummary getAddress();

	interface AddressSummary {
		String getCity();
	}
}