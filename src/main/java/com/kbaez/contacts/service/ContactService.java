package com.kbaez.contacts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kbaez.contacts.api.ContactRequest;
import com.kbaez.contacts.api.ContactResponse;
import com.kbaez.contacts.dao.ContactRepository;
import com.kbaez.contacts.dto.Contact;

@Service
public class ContactService {
    @Autowired
    ContactRepository dao;
     
    public Contact save(Contact contact){
        return dao.saveAndFlush(contact);
    }
    
    public List<Contact> findAll(){
    	return dao.findAll();
    }
    
    public void delete(Long id) {
    	try {
			dao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public Contact findById(Long id){
    	return dao.findOne(id);
    }
    
    public void update(Contact contact){
    	try {
    		dao.save(contact);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
