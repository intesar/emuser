/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.counsellingapp.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.counsellingapp.entity.ReservationRule;
import com.bia.counsellingapp.entity.ReservationRulePK;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface ReservationRuleDao extends GenericDao<ReservationRule, ReservationRulePK> {
    
    ReservationRule findByNameAndMaxSeats(String name, Integer maxSeats);
    List<ReservationRule> findByMaxSeats(Integer maxSeats);

}
