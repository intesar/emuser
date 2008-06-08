/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.service;

import com.bia.imec.entity.Users;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface UsersService {

    public List<Users> getAll();

    public void createUser(Users users);

    public Users getUsers(Integer id);
    
    public void updateUsers ( Users users);

    void mailPassword(String username);
}
