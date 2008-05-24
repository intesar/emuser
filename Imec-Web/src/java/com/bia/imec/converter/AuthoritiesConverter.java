/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.converter;

import com.bia.imec.dto.*;
import com.bia.imec.entity.Authorities;

/**
 *
 * @author imran
 */
public class AuthoritiesConverter {

    public void copy(AuthoritiesDto authoritiesDto, Authorities authorities) {
        if (authoritiesDto != null) {

            authorities.getAuthoritiesPK().setUsername(authoritiesDto.getUsername());
            authorities.getAuthoritiesPK().setAuthority(authoritiesDto.getAuthority());

        }
    }

    public void copy(Authorities authorities, AuthoritiesDto authoritiesDto) {
        if (authorities != null) {

            authoritiesDto.setUsername(authorities.getAuthoritiesPK().getUsername());
            authoritiesDto.setAuthority(authorities.getAuthoritiesPK().getAuthority());
        }
    }
}
