package groupId.ws_retail_authenticationservice.service;

import groupId.ws_retail_authenticationservice.model.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(User.class)
public class AuthService {

    private User user;

    public AuthService(User user) {
        this.user = user;
    }

    public Boolean isAuthenticated(){
        return true;
    }

    public Boolean registerUserService(User registerUser){
        return true;
    }

    public Boolean loginUserService(User loginUser){
        if(loginUser.getUsername().equals(user.getUsername()) && loginUser.getPassword().equals(user.getPassword())){
            return true;
        }
        else {
            return false;
        }
    }
}
