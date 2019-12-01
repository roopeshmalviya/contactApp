package com.malviya.pmp.dao;
import com.malviya.pmp.domain.Contact;
import com.malviya.pmp.rowmapper.ContactRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

    public void save(Contact c) {
        String query = "INSERT INTO contact(userId, name, phone, email, address, remark) VALUES(:userId, :name, :phone, :email, :address, :remark)";
        Map m = new HashMap();
        
        m.put("userId", c.getUserId());
        m.put("name", c.getName());
        m.put("phone", c.getPhone());
        m.put("email", c.getEmail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        
        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(query, ps, kh);
        Integer contactId = kh.getKey().intValue();
        c.setContactId(contactId);        
    }

    public void update(Contact c) {
        String query = "UPDATE contact SET "
                + "         userId=:userId "
                + "         ,name=:name "
                + "         ,phone=:phone "
                + "         ,email=:email "
                + "         ,address=:address "
                + "         ,remark=:remark "
                + "     WHERE contactId = :contactId ";
        Map m = new HashMap();
        m.put("userId", c.getUserId());
        m.put("name", c.getName());
        m.put("phone", c.getPhone());
        m.put("email", c.getEmail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        m.put("contactId", c.getContactId());
//        m.put("userId", c.getUserId());

        System.out.println("the query is " + query);
        System.out.println("data is " + m);
        getNamedParameterJdbcTemplate().update(query, m);
    }


    public void delete(Contact c) {
        this.delete(c.getContactId());
    }


    public void delete(Integer contactId) {
       String query = "DELETE FROM contact WHERE contactId=?";
       getJdbcTemplate().update(query, contactId);       
    }


    public Contact findById(Integer contactId) {
        String query="SELECT contactId, userId, name, phone, email, address, remark from contact WHERE contactId=?";
        Contact c = getJdbcTemplate().queryForObject(query, new ContactRowMapper(), contactId);
        return c;
    }

    public List<Contact> findAll() {
        String query="SELECT contactId, userId, name, phone, email, address, remark from contact";
        List<Contact> c = getJdbcTemplate().query(query, new ContactRowMapper());
        return c;
    }


    public List<Contact> findByProperty(String propName, Object propValue) {
        String query = "SELECT contactId, userId, name, phone, email, address, remark from contact WHERE "+propName+" =?";
        List<Contact> c = getJdbcTemplate().query(query, new ContactRowMapper(), propValue);
        return c;
    }

}
