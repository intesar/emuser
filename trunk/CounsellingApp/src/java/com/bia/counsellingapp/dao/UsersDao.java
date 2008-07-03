/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.counsellingapp.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.counsellingapp.entity.Users;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface UsersDao extends GenericDao<Users, Integer>{
    List<Users> findByHallTicketNos(Integer hallTicketNo1, Integer hallTicketNo2 );
    Users findByUsername(String username);
    List<Users> findAllOrderbyRank();
    Users findByHallTicketNo(Integer hallTicketNo);

}
