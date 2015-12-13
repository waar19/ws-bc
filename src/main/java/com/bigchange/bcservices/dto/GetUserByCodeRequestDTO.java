/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigchange.bcservices.dto;

import java.io.Serializable;

/**
 *
 * @author wilmeralzate
 */
public class GetUserByCodeRequestDTO implements Serializable{
    
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
