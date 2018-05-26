package com.kbaez.contacts.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kbaez.contacts.api.ContactRequest;
import com.kbaez.contacts.dto.Contact;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MappingTest {
	
	@Autowired
	Mapper mapper;
	
	@Test
	public void fromRequestToEntity() {
		Contact c = new Contact(1L, "kar", "Perez", "+57 312 222 3344", "kbaez@mail.com"); 
		ContactRequest req = mapper.map(c, ContactRequest.class);
		
		assertThat(req)
			.hasFieldOrPropertyWithValue("id", c.getId())
			.hasFieldOrPropertyWithValue("firstName", c.getFirstName())
			.hasFieldOrPropertyWithValue("lastName", c.getLastName())
			.hasFieldOrPropertyWithValue("phoneNumber", c.getPhoneNumber())
			.hasFieldOrPropertyWithValue("email", c.getEmail());
	}

}
