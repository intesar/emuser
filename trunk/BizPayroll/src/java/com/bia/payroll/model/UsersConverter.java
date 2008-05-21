/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.payroll.model;

import com.bia.payroll.entity.Users;

/**
 *
 * @author intesar
 */
public class UsersConverter {

    public UsersDto convert ( Users user) {
        UsersDto dto = new UsersDto();
        if ( user != null ) {
            dto.setFirstname(user.getFirstName());
            dto.setId(user.getId());
            dto.setIsEnabled(user.getEnabled());
            dto.setLastname(user.getLastName());
            dto.setPassword(user.getPassword());
            dto.setUsername(user.getUsername());
        }
        return dto;        
    }
    
    public Users convert ( UsersDto dto) {
        Users u = new Users();
        if ( dto != null ) {
            u.setEnabled(dto.getIsEnabled());
            u.setFirstName(dto.getFirstname());
            u.setId(dto.getId());
            u.setLastName(dto.getLastname());
            u.setPassword(dto.getPassword());
            u.setUsername(dto.getUsername());
        }
        return u;
    }
}
