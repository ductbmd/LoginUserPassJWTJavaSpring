/**
 * 
 */
package auth.simple.model;

/**
 * @author toduc
 *
 */
public class User {
private int userId;
private String userName;
private String userPass;
private String userRole;
private String name;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPass() {
	return userPass;
}
public void setUserPass(String userPass) {
	this.userPass = userPass;
}
public String getUserRole() {
	return userRole;
}
public void setUserRole(String userRole) {
	this.userRole = userRole;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
