/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.service.ajax;

import com.bia.imec.converter.UserConverter;
import com.bia.imec.dto.UserDto;
import com.bia.imec.entity.User;
import com.bia.imec.service.ajax.util.AcegiUtil;
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

    public List<UserDto> getAll() {
        String username = AcegiUtil.getUsername();
        List<User> users = userService.getAll(username, null).getResults();
        List<UserDto> dtos = new ArrayList<UserDto>();
        for (User u : users) {
            UserDto dto = new UserDto();
            userConverter.copy(u, dto);
            dtos.add(dto);
        }
        return dtos;
    }

    public String createUser(UserDto userDto) {
        String username = "a";//AcegiUtil.getUsername();
        User user = new User();
        userConverter.copy(userDto, user);
        try {
            userService.createUser(username, user);
            return " Created User on " + DateUtil.getDate();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

   

    public String emailPassword(String username) {
        try {
            userService.mailPassword(username);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return " Password Mailed to " + username;
    }
    
    public static void main(String []args) {
        UserAjaxService uas = new UserAjaxService();
        UserDto dto = new UserDto();
        //dto.setId(3);
        dto.setFirstname("Fn");
        dto.setLastname("ln");
        dto.setUsername("zaryab.khan14941@gmail.com");
        dto.setPassword("pass");
                
        uas.createUser(dto);
    }
    private UserService userService = (UserService) ServiceFactory.getService("userServiceImpl");
    private UserConverter userConverter = new UserConverter();
}
