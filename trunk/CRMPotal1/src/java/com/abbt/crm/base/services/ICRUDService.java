/*
 * ICRUDService.java
 *
 * Created on April 6, 2007, 9:54 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.services;

import com.abbt.crm.base.services.exceptions.InvalidEntityException;
import com.abbt.crm.base.services.exceptions.UniqueEntityException;
import com.abbt.crm.base.services.exceptions.VariableNotNullException;

/**
 *
 * @author shannan
 *
 *  create an instance of it i am calling it iCRUDService
 *  start transaction do whatever you like then decide to commit or rollback
 *  iCRUDService.startTransaction();
 *  iCRUDService.save( new Contact(..));
 *  iCRUDService.update ( Account..);
 *  iCRUDService.commit();
 *  or if any exception and you decided to rollback then 
 *  iCRUDService.rollback();
 */
public interface ICRUDService {
    void beginTransaction();
    void commit();
    void rollback();
    void save(Object entity) throws UniqueEntityException, VariableNotNullException;
    void update (Object entity) throws InvalidEntityException, VariableNotNullException;
    void delete ( Object entity ) throws InvalidEntityException, VariableNotNullException;
}
