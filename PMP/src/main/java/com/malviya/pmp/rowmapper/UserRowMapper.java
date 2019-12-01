package com.malviya.pmp.rowmapper;

import com.malviya.pmp.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author The Rp
 */
public class UserRowMapper implements RowMapper<User>{

    public User mapRow(ResultSet rs, int i) throws SQLException {
        User u = new User();
        u.setUserId(rs.getInt("userId"));
        u.setName(rs.getString("name"));
        u.setEmail(rs.getString("email"));
        u.setPhone(rs.getString("phone"));
        u.setAddress(rs.getString("address"));
        u.setLoginName(rs.getString("loginName"));
//        u.setPassword(rs.getString("password"));
        u.setRole(rs.getInt("role"));
        u.setLoginStatus(rs.getInt("loginStatus"));
        return u;
    }
        
}
