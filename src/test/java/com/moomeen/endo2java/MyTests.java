package com.moomeen.endo2java;

import java.util.List;

import com.moomeen.endo2java.error.InvocationException;
import com.moomeen.endo2java.model.AccountInfo;
import com.moomeen.endo2java.model.Workout;

public class MyTests {
	private static final String EMAIL = "";
	private static final String PASSWORD = "";

	public static void main(String[] args) throws InvocationException {
		EndomondoSession session = new EndomondoSession(EMAIL, PASSWORD);

		// when
		session.login();
		AccountInfo info = session.getAccountInfo();
		System.out.println(info);
		List<Workout> list = session.getWorkouts(1);
		for (Workout workout : list) {
			System.out.println(workout);
		}
		// DetailedWorkout workout = session.getWorkout(list.get(0).getId());
		// System.out.println(workout);
	}

}
