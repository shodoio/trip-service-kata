package io.shodo.formations.tripservicekata;

import java.util.ArrayList;
import java.util.List;

import io.shodo.formations.tripservicekata.exception.UserNotLoggedInException;
import io.shodo.formations.tripservicekata.trip.Trip;
import io.shodo.formations.tripservicekata.trip.TripDAO;
import io.shodo.formations.tripservicekata.user.User;
import io.shodo.formations.tripservicekata.user.UserSession;

public class TripService_Original {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		User loggedUser = UserSession.getInstance().getLoggedUser();
		boolean isFriend = false;
		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = TripDAO.findTripsByUser(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}
	
}
