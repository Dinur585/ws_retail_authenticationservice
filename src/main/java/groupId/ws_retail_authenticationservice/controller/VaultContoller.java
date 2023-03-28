package groupId.ws_retail_authenticationservice.controller;

import groupId.ws_retail_authenticationservice.exception.AccessDeniedException;
import groupId.ws_retail_authenticationservice.model.Credentials;
import groupId.ws_retail_authenticationservice.model.ResponseHandler;
import groupId.ws_retail_authenticationservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class VaultContoller {

    //service layer bean
    @Autowired
    private AuthService authService;

    private Boolean isAuthenticated;

    //post mapping for login functionality
    @PostMapping("/login")
    public ResponseEntity<Object> loginReq(@RequestBody Credentials loginUser) {

        try{
            isAuthenticated = authService.loginUserService(loginUser);
            return ResponseHandler.generateResponse("Successfully logged in", HttpStatus.OK, isAuthenticated);
        }
        catch (AccessDeniedException e){
            isAuthenticated = false;
            return ResponseHandler.generateResponse("Invalid Credentials", HttpStatus.UNAUTHORIZED, isAuthenticated);
        }
    }


    //post mapping for register user functionality
    @PostMapping("/register")
    public ResponseEntity<Object> registerReq(@RequestBody Credentials registerUser) {
        try {
            authService.registerUserService(registerUser);
            return ResponseHandler.generateResponse("Successfully Registered User", HttpStatus.CREATED);
        }
        catch (RuntimeException e){
            return ResponseHandler.generateResponse("User Already exists", HttpStatus.CONFLICT);
        }
    }
}
