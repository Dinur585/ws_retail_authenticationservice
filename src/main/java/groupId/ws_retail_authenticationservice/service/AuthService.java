package groupId.ws_retail_authenticationservice.service;

import groupId.ws_retail_authenticationservice.model.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

import java.net.URISyntaxException;

@Service
public class AuthService {

    private Boolean isAuthenticated = false;

    @Autowired
    private VaultTemplate vaultTemplate;

    public void registerUserService(Credentials registerUser) throws URISyntaxException {
        VaultKeyValueOperations vaultKeyValueOperations = vaultTemplate.opsForKeyValue("secret/data/ws_retail_authenticationservice",
                VaultKeyValueOperationsSupport.KeyValueBackend.KV_2);
        vaultKeyValueOperations.put(registerUser.getUsername(), registerUser);
    }

    public Boolean loginUserService(Credentials loginUser) throws URISyntaxException {
        VaultKeyValueOperations vaultKeyValueOperations = vaultTemplate.opsForKeyValue("secret/data/ws_retail_authenticationservice",
                VaultKeyValueOperationsSupport.KeyValueBackend.KV_2);
        VaultResponseSupport response = vaultKeyValueOperations.get(loginUser.getUsername(), Credentials.class);
        Credentials credentials = (Credentials) response.getData();
        if(loginUser.getUsername().equals(credentials.getUsername()) && loginUser.getPassword().equals(credentials.getPassword())){

            isAuthenticated = true;
            return isAuthenticated;
        }
        else {
            return isAuthenticated;
        }
    }
}
