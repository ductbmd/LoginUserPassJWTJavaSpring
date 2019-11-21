/**
 * 
 */
package auth.simple.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import auth.simple.contract.ResponseContract;
import auth.simple.model.User;
import auth.simple.repository.UserRepository;
import auth.simple.security.TokenProvider;
import auth.simple.security.UserPrincipal;

/**
 * @author toduc
 *
 */
@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenProvider tokenProvider;

	@Override
	public String login(String userName, String pass) {
		Optional<User> userOptional = userRepository.findByUserName(userName);
		User user = null;
		if (userOptional.isPresent()) {
			user = userOptional.get();
		} else {
			return null;
		}
		
		if (checkPass(pass, user.getUserPass())) {
			UserPrincipal userPrincipal = UserPrincipal.create(user);
			String jwtToken = tokenProvider.createToken(userPrincipal);
			return jwtToken;
		}
		return null;
	}

	@Override
	public ResponseContract<?> create(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String encrytePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	public static boolean checkPass(String pass,String dataBasePass) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(pass, dataBasePass);
	}
}
