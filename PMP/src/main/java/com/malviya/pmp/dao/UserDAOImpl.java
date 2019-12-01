package com.malviya.pmp.dao;

import com.malviya.pmp.domain.User;
import com.malviya.pmp.rowmapper.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author The Rp
 */
@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {


    public void save(User u) {
        String query = "INSERT INTO user(name, phone, email, address, loginName, password, role, loginStatus) "
                + "     VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());
        m.put("loginName", u.getLoginName());
        m.put("password", u.getPassword());
        m.put("role", u.getRole());
        m.put("loginStatus", u.getLoginStatus());

        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(query, ps, kh);
        Integer userId = kh.getKey().intValue();
        u.setUserId(userId);

    }


    public void update(User u) {
        String query = "UPDATE user SET "
                + "          name=:name "
                + "         ,phone=:phone "
                + "         ,email=:email "
                + "         ,address=:address "
                + "         ,role=:role "
                + "         ,loginStatus=:loginStatus "
                + "     WHERE userId = :userId ";
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());
        m.put("role", u.getRole());
        m.put("loginStatus", u.getLoginStatus());
        m.put("userId", u.getUserId());

        System.out.println("the query is " + query);
        System.out.println("data is " + m);
        getNamedParameterJdbcTemplate().update(query, m);

    }


    public void delete(Integer userId) {
        String query = "DELETE FROM user WHERE userId=?";
        getJdbcTemplate().update(query, userId);
    }


    public void delete(User u) {
        this.delete(u.getUserId());

    }


    public User findById(Integer userId) {

        String query = "SELECT userId, name, phone, email, address, loginName, role, loginStatus "
                + "FROM user WHERE userId=?";
        User u = getJdbcTemplate().queryForObject(query, new UserRowMapper(), userId);
        return u;
    }


    public List<User> findAll() {
        String query = "SELECT * FROM user";
        List<User> users = getJdbcTemplate().query(query, new UserRowMapper());
        System.out.println("Users hi to hai");
        return users;
    }

    public List<User> findByProperty(String propName, Object propValue) {
        String query = "SELECT * FROM user"
                + " WHERE "+propName+"=?";
        return getJdbcTemplate().query(query, new UserRowMapper(), propValue);
        
    }

}