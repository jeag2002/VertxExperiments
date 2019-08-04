/**
 * 
 */
package com.raidentrance.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.raidentrance.model.User;

/**
 * @author raidentrance
 *
 */
public class UserService {
	private List<User> users = new ArrayList<>();

	public UserService() {
		users.add(new User("raidentrance", "superSecret"));
		users.add(new User("root", "superExtraSecret"));
		users.add(new User("dummy", "notSecret"));
	}

	public List<User> findAll() {
		return users;
	}

	public Optional<User> findByUsername(String username) {
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return Optional.of(user);
			}
		}
		return Optional.empty();
	}

	public void create(User user) {
		users.add(user);
	}

}
