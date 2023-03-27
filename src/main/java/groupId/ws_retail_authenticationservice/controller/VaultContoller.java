package groupId.ws_retail_authenticationservice.controller;

import groupId.ws_retail_authenticationservice.model.Credentials;
import groupId.ws_retail_authenticationservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class VaultContoller {

    //service layer bean
    @Autowired
    private AuthService authService;

    //post mapping for login functionality
    @PostMapping("/login")
    public Boolean loginReq(@RequestBody Credentials loginUser) throws Exception {
        return authService.loginUserService(loginUser);
    }


    //post mapping for register user functionality
    @PostMapping("/register")
    public void registerReq(@RequestBody Credentials registerUser) {
        authService.registerUserService(registerUser);
    }
}
