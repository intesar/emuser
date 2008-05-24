/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.service.ajax;

import com.bia.imec.converter.UserConverter;
import com.bia.imec.dto.UserDto;
import com.bia.imec.entity.User;
import com.bia.imec.service.ajax.util.DateUtil;
import com.bia.imec.services.ServiceFactory;
import com.bia.imec.services.UserService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author intesar
 */
public class UserAjaxService {

    public List<UserDto> getAll(String userDto) {
        List<User> users = userService.getAll(null).getResults();
        List<UserDto> dtos = new ArrayList<UserDto>();
        for (User u : users) {
            UserDto dto = new UserDto();
            userConverter.copy(u, dto);
            dtos.add(dto);
        }
        return dtos;
    }

    public String createUser(UserDto userDto) {
        User user = new User();
        userConverter.copy(userDto, user);
        try {
            userService.createUser(user);
            return " Created User on " + DateUtil.getDate();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    public String updateUser(UserDto userDto) {
        User user = new User();
        userConverter.copy(userDto, user);
        try {
            userService.createUser(user);
            return " Updated User on " + DateUtil.getDate();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    private UserService userService = (UserService) ServiceFactory.getService("userServiceImpl");
    private UserConverter userConverter = new UserConverter();
}
