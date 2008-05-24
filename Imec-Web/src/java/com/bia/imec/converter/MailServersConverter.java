/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.converter;

import com.bia.imec.dto.*;
import com.bia.imec.entity.MailServers;

/**
 *
 * @author imran
 */
public class MailServersConverter {

    public void copy(MailServersDto mailserversDto, MailServers mailservers) {

        if (mailserversDto != null) {
            mailservers.setId(mailserversDto.getId());
            mailservers.setHost(mailserversDto.getHost());
            mailservers.setUsername(mailserversDto.getUsername());
            mailservers.setPassword(mailserversDto.getPassword());
        }

    }

    public void copy(MailServers mailservers, MailServersDto mailserversDto) {

        if (mailservers != null) {
            mailserversDto.setId(mailservers.getId());
            mailserversDto.setHost(mailservers.getHost());
            mailserversDto.setUsername(mailservers.getUsername());
            mailserversDto.setPassword(mailservers.getPassword());
        }
    }
}