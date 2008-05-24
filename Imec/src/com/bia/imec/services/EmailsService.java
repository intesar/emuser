/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.imec.services;

import com.bia.imec.entity.Emails;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface EmailsService {

    public List<Emails> getAll(String status);
}
