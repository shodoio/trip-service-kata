package io.shodo.formations.tripservicekata.trip;

import java.util.List;

import io.shodo.formations.tripservicekata.User;
import io.shodo.formations.tripservicekata.exception.DependendClassCallDuringUnitTestException;

public class TripDAO {

	public static List<Trip> findTripsByUser(User user) {
		throw new DependendClassCallDuringUnitTestException(
				"TripDAO should not be invoked on an unit test.");
	}
	
	public List<Trip> tripsBy(User user) {
		return TripDAO.findTripsByUser(user);
	}	
	
}
