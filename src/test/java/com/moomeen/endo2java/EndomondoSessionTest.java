package com.moomeen.endo2java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.moomeen.endo2java.error.InvocationException;
import com.moomeen.endo2java.error.LoginException;
import com.moomeen.endo2java.model.AccountInfo;
import com.moomeen.endo2java.model.DetailedWorkout;
import com.moomeen.endo2java.model.Workout;

public class EndomondoSessionTest {

	private static final String EMAIL = "";
	private static final String PASSWORD = "";

	@Test
	@Ignore
	public void loginTest() throws LoginException {
		// given
		EndomondoSession session = new EndomondoSession(EMAIL, PASSWORD);

		// when
		session.login();

		// then no exception
	}

	@Test(expected = LoginException.class)
	public void loginTest_wrongPassword() throws LoginException {
		// given
		String WRONG_PASSWORD = PASSWORD + "qwqew";
		EndomondoSession session = new EndomondoSession(EMAIL, WRONG_PASSWORD);

		// when
		session.login();

		// then exception
	}

	@Test
	@Ignore
	public void getWorkoutsTest() throws InvocationException {
		int MAX_RESULTS = 1;
		// given
		EndomondoSession session = new EndomondoSession(EMAIL, PASSWORD);

		// when
		session.login();
		List<Workout> workouts = session.getWorkouts(MAX_RESULTS);

		// then
		assertEquals(MAX_RESULTS, workouts.size());
	}

	@Test(expected = IllegalStateException.class)
	public void getWorkoutsTest_notLoggedIn() throws InvocationException {
		// given
		EndomondoSession session = new EndomondoSession(EMAIL, PASSWORD);

		// when
		session.getWorkouts(1);

		// then exception
	}

	@Test
	@Ignore
	public void getSingleWorkoutTest() throws InvocationException {
		// given
		EndomondoSession session = new EndomondoSession(EMAIL, PASSWORD);

		// when
		session.login();
		List<Workout> list = session.getWorkouts(1);
		DetailedWorkout workout = session.getWorkout(list.get(0).getId());

		// then
		assertNotNull(workout);
		assertEquals(list.get(0).getId(), workout.getId());
	}

	@Test(expected = IllegalStateException.class)
	public void getSingleWorkoutTest_notLoggedIn() throws InvocationException {
		long DUMMY_WORKOUT_ID = 666;

		// given
		EndomondoSession session = new EndomondoSession(EMAIL, PASSWORD);

		// when
		session.getWorkout(DUMMY_WORKOUT_ID);

		// then exception
	}

	@Test
	@Ignore
	public void getAccountInfoTest() throws InvocationException {
		// given
		EndomondoSession session = new EndomondoSession(EMAIL, PASSWORD);

		// when
		session.login();
		AccountInfo info = session.getAccountInfo();

		// then
		assertNotNull(info);
	}

	@Test(expected = IllegalStateException.class)
	public void getAccountInfoTest_notLoggedIn() throws InvocationException {
		// given
		EndomondoSession session = new EndomondoSession(EMAIL, PASSWORD);

		// when
		session.getAccountInfo();

		// then exception
	}

}
