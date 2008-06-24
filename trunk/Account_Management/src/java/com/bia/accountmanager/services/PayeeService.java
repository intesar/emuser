/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.accountmanager.services;

/**
 *
 * @author intesar
 */
public interface PayeeService {
    void addPayeecategory(String name);
    void addPayee(String name,String description,String category);
    void getAllPayees();

}
