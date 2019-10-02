package io.shodo.formations.tripservicekata.trip.test;

import io.shodo.formations.tripservicekata.User;
import io.shodo.formations.tripservicekata.exception.UserNotLoggedInException;
import io.shodo.formations.tripservicekata.trip.Trip;
import io.shodo.formations.tripservicekata.trip.TripDAO;
import io.shodo.formations.tripservicekata.trip.TripService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static io.shodo.formations.tripservicekata.user.test.UserBuilder.aUser;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceTest {
	
	private static final User UNUSED_USER = null;
	private static final User ANOTHER_USER = new User();
	private static final Trip TO_BRAZIL = new Trip();
	private static final User GUEST = null;
	private static final User LOGGED_IN_USER = new User();
	private static final Trip TO_LONDON = new Trip();
	
	@Mock 
	private TripDAO tripDAO;
	
	@InjectMocks 
	private TripService realTripService = new TripService();
	
	@Test(expected = UserNotLoggedInException.class) public void 
	should_throw_an_exception_when_user_is_not_logged_in() {
		 realTripService.getTripsByUser(UNUSED_USER, GUEST);
	}
	
	@Test public void 
	should_not_return_any_trips_when_users_are_not_friends() {
		User friend = aUser()
							.friendsWith(ANOTHER_USER)
							.withTrips(TO_BRAZIL)
							.build();
		
		List<Trip> friendTrips = realTripService.getTripsByUser(friend, LOGGED_IN_USER);
		 
		assertThat(friendTrips.size(), is(0));
	}
	
	@Test public void 
	should_return_trips_when_users_are_friends() {
		User friend = aUser()
							.friendsWith(ANOTHER_USER, LOGGED_IN_USER)
							.withTrips(TO_BRAZIL, TO_LONDON)
							.build();
		given(tripDAO.tripsBy(friend)).willReturn(friend.trips());
		
		List<Trip> friendTrips = realTripService.getTripsByUser(friend, LOGGED_IN_USER);
		
		assertThat(friendTrips.size(), is(2));
	}
	
}
