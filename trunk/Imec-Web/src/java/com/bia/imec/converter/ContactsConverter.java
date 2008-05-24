/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.converter;

import com.bia.imec.dto.ContactsDto;
import com.bia.imec.entity.Contacts;

/**
 *
 * @author imran
 */
public class ContactsConverter {

    public void copy(Contacts contacts, ContactsDto contactsDto) {
        if (contacts != null) {
            contactsDto.setEmail(contacts.getEmail());
            contactsDto.setFirstname(contacts.getFirstname());
            contactsDto.setLastname(contacts.getLastname());
            contactsDto.setSex(contacts.getSex());
            contactsDto.setCity(contacts.getCity());
            contactsDto.setPhone(contacts.getPhone());
        }
    }

    public void copyToDetail(ContactsDto contactsDto, Contacts contacts) {
        if (contactsDto != null) {
            contacts.setEmail(contactsDto.getEmail());
            contacts.setFirstname(contactsDto.getFirstname());
            contacts.setLastname(contactsDto.getLastname());
            contacts.setSex(contactsDto.getSex());
            contacts.setCity(contactsDto.getCity());
            contacts.setPhone(contactsDto.getPhone());
        }
    }
}
           