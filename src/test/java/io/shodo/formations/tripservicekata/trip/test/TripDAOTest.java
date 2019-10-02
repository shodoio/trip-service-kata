package io.shodo.formations.tripservicekata.trip.test;

import io.shodo.formations.tripservicekata.User;
import io.shodo.formations.tripservicekata.exception.DependendClassCallDuringUnitTestException;
import io.shodo.formations.tripservicekata.trip.TripDAO;
import org.junit.Test;

public class TripDAOTest {

    @Test(expected = DependendClassCallDuringUnitTestException.class)
    public void should_throw_an_exception_when_return_trips_from_user() {
        new TripDAO().tripsBy(new User());
    }

}
