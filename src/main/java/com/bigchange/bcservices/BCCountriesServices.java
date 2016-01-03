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
import com.bigchange.bcservices.process.CountryProcess;
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
public class BCCountriesServices {

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getAllCountries")
    public GenericResponseDTO getAllCountries() {
        //TODO write your implementation code here:
        
        GenericResponseDTO getAllCountriesResponseDTO = null;
        CountryProcess conCountryProcess = new CountryProcess();
        try {
            getAllCountriesResponseDTO = conCountryProcess.getAllCountries(); 
        } catch (Exception ex) {
            getAllCountriesResponseDTO = new GenericResponseDTO();
            getAllCountriesResponseDTO.setCode("3");
            getAllCountriesResponseDTO.setData(ex.getMessage());
            getAllCountriesResponseDTO.setMessage("BAD");
        } finally {

        }
        return getAllCountriesResponseDTO;
    }

    
    
}
