package FinalProject.Service;

import FinalProject.Model.User;

public interface UserService {
	User login(String username, String password);
	User get(String username);
}
