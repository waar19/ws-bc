/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigchange.bcservices;

import com.bigchange.bcservices.dto.CreateUserDTO;
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
        GenericResponseDTO getAllUserResponseDTO = null;
        UserProcess userProcess = new UserProcess();

        try {
            getAllUserResponseDTO = userProcess.getAllUsers();
        } catch (Exception ex) {
            getAllUserResponseDTO = new GenericResponseDTO();
            getAllUserResponseDTO.setCode("3");
            getAllUserResponseDTO.setData(ex.getMessage());
            getAllUserResponseDTO.setMessage("BAD");
        } finally {

        }
        return getAllUserResponseDTO;
    }

    /**
     * Web service operation
     * @param dto
     * @return 
     */
    @WebMethod(operationName = "updateUser")
    public GenericResponseDTO updateUser(@WebParam(name = "dto") UpdateUserDTO dto) {
         //TODO write your implementation code here:
        GenericResponseDTO updateUserResponseDTO = null;
        UserProcess userProcess = new UserProcess();

        try {
            updateUserResponseDTO = userProcess.updateUser(dto);
        } catch (Exception ex) {
            updateUserResponseDTO = new GenericResponseDTO();
            updateUserResponseDTO.setCode("3");
            updateUserResponseDTO.setData(ex.getMessage());
            updateUserResponseDTO.setMessage("BAD");
        } finally {

        }
        return updateUserResponseDTO;
    }

    /**
     * Web service operation
     * @param dto
     * @return 
     */
    @WebMethod(operationName = "createUser")
    public GenericResponseDTO createUser(@WebParam(name = "dto") CreateUserDTO dto) {
        //TODO write your implementation code here:
        GenericResponseDTO createUserResponseDTO = null;
        UserProcess userProcess = new UserProcess();

        try {
            createUserResponseDTO = userProcess.createUser(dto);
        } catch (Exception ex) {
            createUserResponseDTO = new GenericResponseDTO();
            createUserResponseDTO.setCode("3");
            createUserResponseDTO.setData(ex.getMessage());
            createUserResponseDTO.setMessage("BAD");
        } finally {

        }
        return createUserResponseDTO;
    }
    
}
