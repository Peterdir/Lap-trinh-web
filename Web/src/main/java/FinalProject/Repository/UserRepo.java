package FinalProject.Repository;

import FinalProject.Model.User;

public interface UserRepo {
	User get(String username);
}
