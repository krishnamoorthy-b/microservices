package com.krishnaedu.edu_identity.service;

import com.krishnaedu.edu_identity.exception.AuthException;
import com.krishnaedu.edu_identity.exception.BusinessException;
import com.krishnaedu.edu_identity.utils.JWTUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String generateToken(){
        return JWTUtil.createToken();
    }

    public String verifyToken(String token) throws BusinessException {
            JWTUtil.verifyToken(token);
            return "Token valid";
    }
}
