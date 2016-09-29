package com.laven.aopanno.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.laven.aopanno.entity.User;

public class UserMapper implements RowMapper {
	private static final String ID = "id";
	@Override
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(ID));
		if(rs.getString("email") != null){
		user.setEmail(rs.getString("email"));	
		}
		user.setNickname(rs.getString("nickname"));
		if(rs.getString("is_email_verify").equals("Y")){
			user.setEmailVerify(true);
		}
		return user;
	}
	
}
