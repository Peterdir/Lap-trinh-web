package FinalProject.Service.impl;

import FinalProject.Model.User;
import FinalProject.Repository.UserRepo;
import FinalProject.Repository.impl.UserRepoImpl;
import FinalProject.Service.UserService;

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
	
	@Override
    public String forgotPassword(String email) {
        if (email == null || email.trim().isEmpty()) {
            return "Vui lòng nhập địa chỉ email!";
        }

        boolean exists = userRepo.checkEmailExists(email);
        if (exists) {
            return "Hệ thống đã gửi hướng dẫn đặt lại mật khẩu tới email: " + email;
        } else {
            return "Email không tồn tại trong hệ thống!";
        }
    }
	
	@Override
	public boolean checkEmailExists(String email) {
	    return userRepo.checkEmailExists(email);
	}

	@Override
	public boolean updatePassword(String email, String newPassword) {
	    return userRepo.updatePassword(email, newPassword);
	}
}
