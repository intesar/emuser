/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.service.ajax;

import com.bia.imec.converter.ContactsConverter;
import com.bia.imec.dto.ContactsDto;
import com.bia.imec.entity.Contacts;
import com.bia.imec.services.ContactService;
import com.bia.imec.services.ServiceFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author intesar
 */
public class ContactsAjaxService {

    public List<ContactsDto> getAll() {
        List<Contacts> contacts = contactService.getAll(null).getResults();
        List<ContactsDto> dtos = new ArrayList<ContactsDto> ();
        for (Contacts c : contacts) {
            ContactsDto dto = new ContactsDto();
            contactsConverter.copy(c, dto);
            dtos.add(dto);
        }
        return dtos;
    }
    private ContactsConverter contactsConverter = new ContactsConverter();
    private ContactService contactService = (ContactService) ServiceFactory.getService("contactServiceImpl");
}
