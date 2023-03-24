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



    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Boolean loginReq(@RequestBody Credentials loginUser) throws URISyntaxException {
        return authService.loginUserService(loginUser);
    }

    @PostMapping("/register")
    public void registerReq(@RequestBody Credentials registerUser) throws URISyntaxException {
        authService.registerUserService(registerUser);
    }
}
