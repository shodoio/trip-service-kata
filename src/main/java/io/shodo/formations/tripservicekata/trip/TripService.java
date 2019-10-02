package io.shodo.formations.tripservicekata.trip;

import io.shodo.formations.tripservicekata.User;
import io.shodo.formations.tripservicekata.exception.UserNotLoggedInException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TripService {

	@Autowired private TripDAO tripDAO;

	public List<Trip> getTripsByUser(User user, User loggedInUser) throws UserNotLoggedInException {
		validate(loggedInUser);
		
		return user.isFriendsWith(loggedInUser)
						? tripsFrom(user)
						: noTrips();
	}

	private ArrayList<Trip> noTrips() {
		return new ArrayList<Trip>();
	}

	private void validate(User loggedInUser) {
		if (loggedInUser == null) {
			throw new UserNotLoggedInException();
		}
	}

	private List<Trip> tripsFrom(User user) {
		return tripDAO.tripsBy(user);
	}

}
