package groupId.ws_retail_authenticationservice.service;

import groupId.ws_retail_authenticationservice.exception.AccessDeniedException;
import groupId.ws_retail_authenticationservice.model.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class AuthService {

    private Boolean isAuthenticated = false;

    @Autowired
    private BCryptPasswordEncoder encoder;

    // configure VaultTemplate bean from env properties
    @Autowired
    private VaultTemplate vaultTemplate;

    //method to register user credentials to vault
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUserService(Credentials registerUser) {
        VaultKeyValueOperations vaultKeyValueOperations = vaultTemplate.opsForKeyValue("secret/data/ws_retail_authenticationservice",
                VaultKeyValueOperationsSupport.KeyValueBackend.KV_2);
        VaultResponseSupport response = vaultKeyValueOperations.get(registerUser.getUsername(), Credentials.class);
        String password = registerUser.getPassword();
        String encryptedPassword = encoder.encode(password);
        registerUser.setPassword(encryptedPassword);
        vaultKeyValueOperations.put(registerUser.getUsername(), registerUser);
        if(response == null){
            vaultKeyValueOperations.put(registerUser.getUsername(), registerUser);
        }
        else{
            throw new RuntimeException("User already exits");
        }
    }

    //method to check if login creds are present in vault and return a boolean if credentials are present or not
    public Boolean loginUserService(Credentials loginUser) throws AccessDeniedException{
        VaultKeyValueOperations vaultKeyValueOperations = vaultTemplate.opsForKeyValue("secret/data/ws_retail_authenticationservice",
                VaultKeyValueOperationsSupport.KeyValueBackend.KV_2);
        VaultResponseSupport response = vaultKeyValueOperations.get(loginUser.getUsername(), Credentials.class);


        if (response==null){
            throw new AccessDeniedException("Access denied");
        }
        //cast response object to credentials model
        Credentials credentials = (Credentials) response.getData();
        if(loginUser.getUsername().equals(credentials.getUsername()) && encoder.matches(loginUser.getPassword(), credentials.getPassword())){

            isAuthenticated = true;
            return isAuthenticated;
        }
        else {
            throw new AccessDeniedException("Access denied");
        }
    }
}
