package com.malviya.pmp.service;


import com.malviya.pmp.dao.BaseDAO;
import com.malviya.pmp.dao.ContactDAO;
import com.malviya.pmp.domain.Contact;
import com.malviya.pmp.rowmapper.ContactRowMapper;
import com.malviya.pmp.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author The Rp
 */
@Service
public class ContactServiceImpl extends BaseDAO implements ContactService{
    @Autowired
    ContactDAO contactDao;
    
    
   
    public void save(Contact c) {
        contactDao.save(c);
    }


    public void update(Contact c) {
        contactDao.update(c);
    }


    public void delete(Integer contactId) {
        contactDao.delete(contactId);
    }


    public void delete(Integer[] contactId) {
        String ids = StringUtil.toCommaSeparatedString(contactId);
        String query = "DELETE FRoM contact WHERE contactId IN("+ids+")";
        getJdbcTemplate().update(query);
    }


    public List<Contact> findUserContact(Integer userId) {
        return contactDao.findByProperty("userId", userId);
        
    }


    public List<Contact> findUserContact(Integer userId, String txt) {
           
        String query = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId = ? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
        return getJdbcTemplate().query(query, new ContactRowMapper(), userId);    
    }
    
}
