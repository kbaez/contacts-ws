package com.kbaez.contacts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kbaez.contacts.dto.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
