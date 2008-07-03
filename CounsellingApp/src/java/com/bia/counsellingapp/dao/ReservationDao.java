/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.counsellingapp.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.counsellingapp.entity.Reversation;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface ReservationDao extends GenericDao<Reversation, String> {
    
    List<Reversation> findAllByPriority();

}
