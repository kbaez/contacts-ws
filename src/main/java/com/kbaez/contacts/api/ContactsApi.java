package com.kbaez.contacts.api;

import java.util.List;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kbaez.contacts.dto.Contact;
import com.kbaez.contacts.service.ContactService;

@RestController
public class ContactsApi {
	
	@Autowired
	ContactService contactService;
	
	// Inyecta mapper de Dozer
	@Autowired
	Mapper mapper;
	 
	@RequestMapping(value="/contact", method=RequestMethod.POST)
	public ContactResponse updateOrSave(@RequestBody @Valid ContactRequest contactRequest){
		// Mapeo request dto ==> entity
		Contact contact = mapper.map(contactRequest, Contact.class);
	    
		// Invoca lógica de negocio
		Contact updatedContact = contactService.save(contact);
	    
		// Mapeo entity ==> response dto
	    ContactResponse contactResponse = mapper.map(updatedContact, ContactResponse.class); 
	    
	    return contactResponse;
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public List<Contact> getAll(){
		return contactService.findAll();
	}
	
	@RequestMapping(value="/contact/{id}", method=RequestMethod.GET)
	public Contact getById(@PathVariable Long id){
		return contactService.findById(id);
	}
	
	@RequestMapping(value="/contact/{id}", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable Long id){
		contactService.delete(id);
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.PUT)
	public void update(@RequestBody Contact contact){
		contactService.update(contact);
	}
	
}
