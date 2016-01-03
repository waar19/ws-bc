/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigchange.bcservices;

import com.bigchange.bcservices.dto.GenericResponseDTO;
import com.bigchange.bcservices.dto.GetUserByCodeRequestDTO;
import com.bigchange.bcservices.process.UserProcess;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author wilmeralzate
 */
@Path("/BCUsersRestFullServices")
public class BCUsersRestFullServices {
    
    @POST
    @Path("/get_users_by_code")
    @Produces({"application/xml", "application/json"})
    public GenericResponseDTO getUsersByCode(@WebParam(name = "dto") GetUserByCodeRequestDTO dto){
    
        GenericResponseDTO getUserByCodeResponseDTO = null;
        UserProcess userProcess = new UserProcess();

        try {
            getUserByCodeResponseDTO = userProcess.getUserByCode(dto);
        } catch (Exception ex) {
            getUserByCodeResponseDTO = new GenericResponseDTO();
            getUserByCodeResponseDTO.setCode("3");
            getUserByCodeResponseDTO.setData(ex.getMessage());
            getUserByCodeResponseDTO.setMessage("BAD");
        } finally {

        }
        return getUserByCodeResponseDTO;
    
    }
    
}
