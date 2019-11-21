/**
 * 
 */
package auth.simple.service;

import auth.simple.contract.ResponseContract;
import auth.simple.model.User;

/**
 * @author toduc
 *
 */
public interface IUserService {
	public String login(String userName,String pass);
	public ResponseContract<?> create(User user);
	
}
