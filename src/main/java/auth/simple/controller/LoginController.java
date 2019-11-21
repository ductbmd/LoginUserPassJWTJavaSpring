/**
 * 
 */
package auth.simple.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import auth.simple.contract.ResponseContract;
import auth.simple.service.IUserService;

/**
 * @author toduc
 *
 */
@RestController
public class LoginController {
@Autowired IUserService userService;
@PostMapping("/login")
public ResponseContract<?> login(@RequestBody Map<String, String> body){
	String jwt=userService.login(body.get("userName"), body.get("userPass"));
	if (jwt==null) {
		return new ResponseContract<String>("FAIL", "login FAIL", "User name or password incorrect!");
	}
	return new ResponseContract<String>("SUCCESS", "login SUCCESS", jwt);
}
@GetMapping("demo")
public ResponseContract<?> demo(){
	return new ResponseContract<String>("200", "Passjwt", "ok hihi");
}
}
