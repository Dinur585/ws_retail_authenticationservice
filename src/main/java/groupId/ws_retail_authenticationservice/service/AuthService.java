package groupId.ws_retail_authenticationservice.service;

import groupId.ws_retail_authenticationservice.model.Credentials;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class AuthService {

    private Boolean isAuthenticated = false;

    public Boolean isAuthenticated(){
        return true;
    }

    public void registerUserService(Credentials registerUser) throws URISyntaxException {
        VaultEndpoint endpoint = VaultEndpoint.from(new URI("http://localhost:8200"));
        VaultTemplate vaultTemplate = new VaultTemplate(endpoint,
                new TokenAuthentication("vault-plaintext-root-token"));
        VaultKeyValueOperations vaultKeyValueOperations = vaultTemplate.opsForKeyValue("secret/data/test3",
                VaultKeyValueOperationsSupport.KeyValueBackend.KV_2);
        vaultKeyValueOperations.put(registerUser.getUsername(), registerUser);
    }

    public Boolean loginUserService(Credentials loginUser) throws URISyntaxException {
        VaultEndpoint endpoint = VaultEndpoint.from(new URI("http://localhost:8200"));
        VaultTemplate vaultTemplate = new VaultTemplate(endpoint,
                new TokenAuthentication("vault-plaintext-root-token"));
        VaultKeyValueOperations vaultKeyValueOperations = vaultTemplate.opsForKeyValue("secret/data/test3",
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
