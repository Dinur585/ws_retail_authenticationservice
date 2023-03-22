package groupId.ws_retail_authenticationservice.controller;

import groupId.ws_retail_authenticationservice.model.User;
import groupId.ws_retail_authenticationservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@EnableConfigurationProperties(User.class)
@RequestMapping("/api/v1/auth")
public class VaultContoller {

    private User user;

    public VaultContoller(User user) {
        this.user = user;
    }

    @Autowired
    private AuthService authService;

    @GetMapping
    public User getAuthDetails(){
        return new User(user.getUsername(), user.getPassword());
    }

    @PostMapping("/login")
    public Boolean loginReq(@RequestBody User loginUser){
        return authService.loginUserService(loginUser);
    }

    @PostMapping("/register")
    public Boolean registerReq(@RequestBody User registerUser){
        return authService.registerUserService(registerUser);
    }
}
