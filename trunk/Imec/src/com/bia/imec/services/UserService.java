/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.imec.services;

import com.bia.imec.entity.User;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface UserService {

    public List<User> getAll(String users);
    
    public void createUser(String users);
    
    public void updateUser(String users);
    
}