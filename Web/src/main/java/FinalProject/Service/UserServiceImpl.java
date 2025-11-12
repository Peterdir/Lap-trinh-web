package FinalProject.Service;

import FinalProject.Model.User;
import FinalProject.Repository.UserRepo;
import FinalProject.Repository.UserRepoImpl;

public class UserServiceImpl implements UserService{
	UserRepo userRepo = new UserRepoImpl();
	
	
	@Override
	public User login(String username, String password) {
		User user = this.get(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}
	
	@Override
	 public User get(String username) {
	 return userRepo.get(username);
	}
}
