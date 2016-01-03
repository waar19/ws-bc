/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigchange.bcservices.process;

import com.bigchange.bcservices.dto.GenericResponseDTO;
import com.bigchange.bcservices.model.Countries;
import com.bigchange.bcservices.util.db.Persistence;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author wilmeralzate
 */
public class CountryProcess {

    GenericResponseDTO response = new GenericResponseDTO();
    Persistence persistence = new Persistence();
    ObjectMapper mapper = new ObjectMapper();

    public GenericResponseDTO getAllCountries() {

        response = new GenericResponseDTO();
        persistence = new Persistence();
        mapper = new ObjectMapper();
        List<Countries> countrieses;

        try {

            persistence.setQuery(persistence.getEmf().createEntityManager().createNamedQuery("Countries.findAll"));
            countrieses = (List<Countries>) persistence.getQuery().getResultList();

            if (countrieses != null && !countrieses.isEmpty() && countrieses.size() > 0) {
                response.setCode("1");
                response.setData(mapper.writeValueAsString(countrieses));
                response.setMessage("OK");
            } else {
                response.setCode("0");
                response.setMessage("NO RESULT");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                response.setCode("2");
                response.setData(mapper.writeValueAsString(ex));
                response.setMessage("BAD");
            } catch (IOException ex1) {
                Logger.getLogger(UserProcess.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            persistence = null;
            mapper = null;
            countrieses = null;
            System.gc();
        }

        return response;
    }
}
