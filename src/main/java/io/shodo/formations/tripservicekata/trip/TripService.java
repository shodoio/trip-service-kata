package io.shodo.formations.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import io.shodo.formations.tripservicekata.exception.UserNotLoggedInException;
import io.shodo.formations.tripservicekata.user.User;
import org.springframework.beans.factory.annotation.Autowired;

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
