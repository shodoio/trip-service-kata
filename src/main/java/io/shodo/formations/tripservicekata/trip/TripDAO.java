package io.shodo.formations.tripservicekata.trip;

import java.util.List;

import io.shodo.formations.tripservicekata.exception.CollaboratorCallException;
import io.shodo.formations.tripservicekata.user.User;

public class TripDAO {

	public static List<Trip> findTripsByUser(User user) {
		throw new CollaboratorCallException(
				"TripDAO should not be invoked on an unit test.");
	}
	
}
