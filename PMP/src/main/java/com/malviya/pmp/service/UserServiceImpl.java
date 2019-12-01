package com.malviya.pmp.service;

import com.malviya.pmp.dao.BaseDAO;
import com.malviya.pmp.dao.UserDAO;
import com.malviya.pmp.domain.User;
import com.malviya.pmp.exception.UserBlockedException;
import com.malviya.pmp.rowmapper.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author The Rp
 */

@Service
public class UserServiceImpl extends BaseDAO implements UserService{
    @Autowired
    private UserDAO userDAO;
    

    public void register(User u) {
        userDAO.save(u);
    }


    public User logIn(String userName, String password) throws UserBlockedException {
        String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus from user "
                + " WHERE loginName = :ln AND password = :ps";
        Map m = new HashMap();
        m.put("ln", userName);
        m.put("ps", password);
        try {
            User u=getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
            if(u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)){
                throw new UserBlockedException("Your account is blocked, Contact to Administrator");
            }else{
                return u;
            }
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
        
        
    }


    public List<User> getUserList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void changeLoginStatus(Integer userId, Integer loginStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
