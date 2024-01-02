package com.ResoTech.Todo.Api.service;

import com.ResoTech.Todo.Api.model.User;
import com.ResoTech.Todo.Api.model.UserAuthenticationToken;
import com.ResoTech.Todo.Api.model.dto.AuthenticationInputDto;
import com.ResoTech.Todo.Api.model.dto.SignInInputDto;
import com.ResoTech.Todo.Api.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    PTokenService pTokenService;

    public String userSignUp(User user) {
        //check if already exist -> Not allowed : try logging in

        String newEmail = user.getUserEmail();

        User existingUser = userRepo.findFirstByUserEmail(newEmail);

        if(existingUser != null)
        {
            return "email already in use";
        }

        // passwords are encrypted before we store it in the table

        String signUpPassword = user.getUserPassword();

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(signUpPassword);

            user.setUserPassword(encryptedPassword);


            // user table - save user
            userRepo.save(user);
            return "User registered";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }
    }

    public String userSignIn(SignInInputDto signInInput) {
        //check if the email is there in your tables
        //sign in only possible if this person ever signed up

        String email = signInInput.getEmail();

        User existingPatient = userRepo.findFirstByUserEmail(email);

        if(existingPatient == null)
        {
            return "Not a valid email, Please sign up first !!!";
        }

        //password should be matched

        String password = signInInput.getPassword();

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(password);

            if(existingPatient.getUserPassword().equals(encryptedPassword))
            {
                // return a token for this sign in
                UserAuthenticationToken token  = new UserAuthenticationToken(existingPatient);

                if(EmailService.sendEmail(email,"otp after login", token.getTokenValue())) {
                    pTokenService.createToken(token);
                    return "check email for otp/token!!!";
                }
                else {
                    return "error while generating token!!!";
                }

            }
            else {
                //password was wrong!!!
                return "Invalid Credentials!!!";
            }

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }
    }

    public String userSignOut(String email,String tokenValue) {
        if(pTokenService.authenticate(email, tokenValue)) {
            pTokenService.deleteToken(tokenValue);
            return "Sign Out successful!!";
        }
        else {
            return "Un Authenticated access!!!";
        }
    }

}
