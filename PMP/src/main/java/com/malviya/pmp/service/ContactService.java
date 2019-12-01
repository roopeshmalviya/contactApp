package com.malviya.pmp.service;

import com.malviya.pmp.domain.Contact;
import java.util.List;

/**
 *
 * @author The Rp
 */
public interface ContactService {

    public void save(Contact c);

    public void update(Contact c);

    public void delete(Integer contactId);

    public void delete(Integer[] contactId);
    
   /**
    * This method return all the user contacts based on the given userId id when user is login.
    * @param userId
    * @return 
    */
    public List<Contact> findUserContact(Integer userId);
    
    /**
     * This method will find all the contact of the given userId who just loged in on the basis of free text.
     * @param userId
     * @param str
     * @return it will return of the all the contacts of the user who loged in.
     */
    public List<Contact> findUserContact(Integer userId, String str);

}
