package io.shodo.formations.tripservicekata.user.test;

import static io.shodo.formations.tripservicekata.user.test.UserBuilder.aUser;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import io.shodo.formations.tripservicekata.user.User;
import org.junit.Test;

public class UserTest {

	private static final User BOB  = new User();
	private static final User PAUL = new User();

	@Test public void 
	should_inform_when_users_are_not_friends() {
		 User user = aUser()
				 		.friendsWith(BOB)
				 		.build();
		 
		assertThat(user.isFriendsWith(PAUL), is(false));		 		
	}
	
	@Test public void 
	should_inform_when_users_are_friends() {
		User user = aUser()
				.friendsWith(BOB, PAUL)
				.build();
		
		assertThat(user.isFriendsWith(PAUL), is(true));		 				 
	}
	
}
