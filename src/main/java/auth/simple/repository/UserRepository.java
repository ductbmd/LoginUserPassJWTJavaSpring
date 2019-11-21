/**
 * 
 */
package auth.simple.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import auth.simple.model.User;

/**
 * @author toduc
 *
 */
@Repository
public class UserRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	public User create(User user) {
		String sql="INSERT INTO `tbl_users` (`user_name`, `user_pass`, `user_role`, `name`) VALUES (:userName, :userPass, :userRole, :name);";
		SqlParameterSource params = new BeanPropertySqlParameterSource(user);
		jdbcTemplate.update(sql, params);
		return findByUserName(user.getUserName()).orElseGet(null);
	}
	public Optional<User> findByUserName(String userName) {
		String sql="SELECT * FROM auth.tbl_users where user_name =:userName;";
		Map<String, Object> argMap = new HashMap<>();
		argMap.put("userName", userName);
		try {
			return Optional
					.ofNullable(jdbcTemplate.queryForObject(sql, argMap, new BeanPropertyRowMapper<User>(User.class)));
		} catch (Exception e) {
			return Optional.ofNullable(null);
		
	}
	}
	public Optional<User> findByUserId(int userId) {
		String sql="SELECT * FROM auth.tbl_users where user_id =:userId;";
		Map<String, Object> argMap = new HashMap<>();
		argMap.put("userId", userId);
		try {
			return Optional
					.ofNullable(jdbcTemplate.queryForObject(sql, argMap, new BeanPropertyRowMapper<User>(User.class)));
		} catch (Exception e) {
			return Optional.ofNullable(null);
		
	}
	}
}
