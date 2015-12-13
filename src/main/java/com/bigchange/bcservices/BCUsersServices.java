/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigchange.bcservices;

import com.bigchange.bcservices.dto.GetUserByCodeRequestDTO;
import com.bigchange.bcservices.dto.GenericResponseDTO;
import com.bigchange.bcservices.dto.UpdateUserDTO;
import com.bigchange.bcservices.process.UserProcess;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author wilmeralzate
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class BCUsersServices {

    /**
     * Web service operation
     * @param dto
     * @return 
     */
    @WebMethod(operationName = "getUsersByCode")
    public GenericResponseDTO getUsersByCode(@WebParam(name = "dto") GetUserByCodeRequestDTO dto) {
        //TODO write your implementation code here:
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

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getAllUsers")
    public GenericResponseDTO getAllUsers() {
        //TODO write your implementation code here:
        GenericResponseDTO getUserByCodeResponseDTO = null;
        UserProcess userProcess = new UserProcess();

        try {
            getUserByCodeResponseDTO = userProcess.getAllUsers();
        } catch (Exception ex) {
            getUserByCodeResponseDTO = new GenericResponseDTO();
            getUserByCodeResponseDTO.setCode("3");
            getUserByCodeResponseDTO.setData(ex.getMessage());
            getUserByCodeResponseDTO.setMessage("BAD");
        } finally {

        }
        return getUserByCodeResponseDTO;
    }

    /**
     * Web service operation
     * @param dto
     * @return 
     */
    @WebMethod(operationName = "updateUser")
    public GenericResponseDTO updateUser(@WebParam(name = "dto") UpdateUserDTO dto) {
         //TODO write your implementation code here:
        GenericResponseDTO getUserByCodeResponseDTO = null;
        UserProcess userProcess = new UserProcess();

        try {
            getUserByCodeResponseDTO = userProcess.getAllUsers();
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
