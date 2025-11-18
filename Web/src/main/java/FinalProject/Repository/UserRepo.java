package FinalProject.Repository;

import FinalProject.Model.User;

public interface UserRepo {
	User get(String username);
	boolean updatePassword(String email, String newPassword);
	boolean checkEmailExists(String email);
}
