/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.converter;

import com.bia.imec.dto.*;
import com.bia.imec.entity.User;

/**
 *
 * @author imran
 */
public class UserConverter {

    public void copy(UserDto userDto, User user) {

        if (userDto != null) {
            user.setUsersname(userDto.getUsersname());
            user.setPassword(userDto.getPassword());
            user.setFirstname(userDto.getFirstname());
            user.setLastname(userDto.getLastname());
            user.setEnable(userDto.getEnable());
            user.setIsadmin(userDto.getIsadmin());
        }
    }

    public void copy(User user, UserDto userDto) {

        if (user != null) {
            userDto.setUsersname(user.getUsersname());
            userDto.setPassword(user.getPassword());
            userDto.setFirstname(user.getFirstname());
            userDto.setLastname(user.getLastname());
            userDto.setEnable(user.getEnable());
            userDto.setIsadmin(user.getIsadmin());
        }
    }
}