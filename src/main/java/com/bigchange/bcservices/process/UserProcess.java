/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigchange.bcservices.process;

import com.bigchange.bcservices.dto.GenericResponseDTO;
import com.bigchange.bcservices.dto.GetUserByCodeRequestDTO;
import com.bigchange.bcservices.dto.UpdateUserDTO;
import com.bigchange.bcservices.model.Users;
import com.bigchange.bcservices.util.db.Persistence;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author wilmeralzate
 */
public class UserProcess {

    GenericResponseDTO response = new GenericResponseDTO();
    Persistence persistence = new Persistence();
    Users user;
    List<Users> users;
    ObjectMapper mapper = new ObjectMapper();

    public GenericResponseDTO getUserByCode(GetUserByCodeRequestDTO dto) {

        response = new GenericResponseDTO();
        persistence = new Persistence();
        mapper = new ObjectMapper();

        try {
            persistence.setQuery(persistence.getEmf().createEntityManager().createNamedQuery("Users.findByCode"));
            persistence.getQuery().setParameter("code", dto.getCode().trim());

            try {
                user = (Users) persistence.getQuery().getSingleResult();

                if (user != null && user.getId() != null) {
                    response.setCode("1");
                    response.setData(mapper.writeValueAsString(user));
                    response.setMessage("OK");
                } else {
                    response.setCode("0");
                    response.setMessage("NO RESULT");
                }
            } catch (NoResultException nre) {
                response.setCode("0");
                response.setMessage("NO RESULT");
            }
        } catch (Exception ex) {
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
            user = null;
            System.gc();
        }

        return response;

    }

    public GenericResponseDTO getAllUsers() {

        response = new GenericResponseDTO();
        persistence = new Persistence();
        mapper = new ObjectMapper();

        try {

            persistence.setQuery(persistence.getEmf().createEntityManager().createNamedQuery("Users.findAll"));
            users = (List<Users>) persistence.getQuery().getResultList();

            if (users != null && !users.isEmpty() && users.size() > 0) {
                response.setCode("1");
                response.setData(mapper.writeValueAsString(users));
                response.setMessage("OK");
            } else {
                response.setCode("0");
                response.setMessage("NO RESULT");
            }

        } catch (Exception ex) {
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
            user = null;
            System.gc();
        }

        return response;

    }

    public GenericResponseDTO updateUser(UpdateUserDTO dto) {

        return null;
    }

}
