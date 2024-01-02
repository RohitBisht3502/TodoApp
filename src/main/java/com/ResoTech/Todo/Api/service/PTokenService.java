package com.ResoTech.Todo.Api.service;

import com.ResoTech.Todo.Api.model.UserAuthenticationToken;
import com.ResoTech.Todo.Api.model.dto.AuthenticationInputDto;
import com.ResoTech.Todo.Api.repo.IPTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PTokenService {

    @Autowired
    IPTokenRepo ipTokenRepo;

    public void createToken(UserAuthenticationToken token) {
        ipTokenRepo.save(token);
    }

    public boolean authenticate(String email, String tokenValue) {
        //find thr actual token -> get the connected patient -> get its email-> verify with passed email

        //return ipTokenRepo.findFirstByTokenValue(tokenValue).getPatient().getPatientEmail().equals(email);

        UserAuthenticationToken token =  ipTokenRepo.findFirstByTokenValue(tokenValue);
        if(token!=null)
        {
            return token.getUser().getUserEmail().equals(email);
        }
        else
        {
            return false;
        }
    }

    public void deleteToken(String tokenValue) {
        UserAuthenticationToken token =  ipTokenRepo.findFirstByTokenValue(tokenValue);
        ipTokenRepo.delete(token);
    }
}
