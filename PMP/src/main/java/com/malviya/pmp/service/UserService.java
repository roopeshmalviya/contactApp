package com.malviya.pmp.service;


import com.malviya.pmp.domain.User;
import com.malviya.pmp.exception.UserBlockedException;
import java.util.List;

/**
 *
 * @author The Rp
 */
public interface UserService {
    public static final Integer LOGIN_STATUS_ACTIVE=1;
    public static final Integer LOGIN_STATUS_BLOCKED=2;
    
    public static final Integer ROLE_ADMIN=1;
    public static final Integer ROLE_USER=2;
    
    /**
     * The Method handles the user registration part
     * @param u 
     */
    public void register(User u);
    /**
     * If The LogIn is successful we well get user object, if the credential is wrong, then it will return null
     * and if the user is blocked then UserBlockedException will be thrown.
     * @param userName
     * @param password
     * @throws UserBlockedException 
     */
    public User logIn(String userName, String password) throws UserBlockedException;
    /**
     * Admin can see the user list so this method will return the list of users
     * @return 
     */
    public List<User> getUserList();
    
    /**
     * This method will change the login Status of the user. because admin can block and unblock the user.
     * @param userId
     * @param loginStatus 
     */    
    public void changeLoginStatus(Integer userId, Integer loginStatus);
    
}
