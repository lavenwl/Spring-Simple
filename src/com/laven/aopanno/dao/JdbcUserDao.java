package com.laven.aopanno.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.laven.aopanno.entity.User;
import com.laven.aopanno.mapper.UserMapper;

@Repository("jdbcUserDao")
public class JdbcUserDao extends JdbcDaoSupport implements UserDao{

	@Override
	public void save(User user) { 
		System.out.println("采用JDBC技术保存用户信息!"); 
		String sql = "insert into d_user " +
			"(email,nickname,password," +
			"user_integral,is_email_verify," + 
			"email_verify_code,last_login_time,last_login_ip) " + 
			"values (?,?,?,?,?,?,?,?)";
		this.getJdbcTemplate().update(sql,
						new Object[]{user.getEmail(),
									 user.getNickname(), 
									 user.getPassword(), 
									 user.getUserIntegral(), 
									 user.isEmailVerify()?"Y":"N", 
									 user.getEmailVerifyCode(), 
									 user.getLastLoginTime(), 
									 user.getLastLoginIp()});
						
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		System.out.println("Dao,采用jdbc技术更新用户信息");
		String sql = "update d_user set email=?," +
				"nickname=?," + "password=?," +
				"user_integral=?," + "is_email_verify=?," + "email_verify_code=?," + "last_login_time=?," + "last_login_ip=? " + "where id=?";
		this.getJdbcTemplate().update(sql,
				new Object[]{user.getEmail(),
							 user.getNickname(), 
							 user.getPassword(), 
							 user.getUserIntegral(), 
							 user.isEmailVerify()?"Y":"N", 
							 user.getEmailVerifyCode(), 
							 user.getLastLoginTime(), 
							 user.getLastLoginIp()});
	}
	
	public void deleteById(int id){
		String sql = "delete from d_user where id=?";
		this.getJdbcTemplate().update(sql, new Object[]{id});
	}
	
	public User findById(int id) {
		String sql = "select * from d_user where id=?"; 
		return (User)this.getJdbcTemplate()
		.queryForObject(sql,new Object[]{id}, new UserMapper());
	}
	
	public List<User> findAll() {
		String sql = "select * from d_user";
		List list = this.getJdbcTemplate().query(sql,new UserMapper());
		return list; 
	}
	
	public int count() {
		String sql = "select count(*) from d_user"; 
		return this.getJdbcTemplate().queryForInt(sql);
	}
}
