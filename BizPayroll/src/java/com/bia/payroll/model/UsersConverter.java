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

    public void copy(Users user, UsersDto dto) {

        if (user != null) {
            dto.setFirstname(user.getFirstName());
            dto.setId(user.getId());
            dto.setIsEnabled(user.getEnabled());
            dto.setLastname(user.getLastName());
            dto.setPassword(user.getPassword());
            dto.setUsername(user.getUsername());
        }

    }

    public void copy(UsersDto dto, Users u) {

        if (dto != null) {
            u.setEnabled(dto.getIsEnabled());
            u.setFirstName(dto.getFirstname());
            if (dto.getId() > 0) {
                u.setId(dto.getId());
            }
            u.setLastName(dto.getLastname());
            u.setPassword(dto.getPassword());
            u.setUsername(dto.getUsername());
        }

    }
}
