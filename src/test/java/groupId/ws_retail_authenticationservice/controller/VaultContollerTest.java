package groupId.ws_retail_authenticationservice.controller;

import static org.mockito.Mockito.mock;

import groupId.ws_retail_authenticationservice.model.Credentials;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class VaultContollerTest {

    @Test
    @Disabled("TODO: Complete this test")
    void testLoginReq() throws Exception {

        VaultContoller vaultContoller = new VaultContoller();
        vaultContoller.loginReq(new Credentials("janedoe", "iloveyou"));
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testLoginReq2() throws Exception {

        (new VaultContoller()).loginReq(mock(Credentials.class));
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterReq() throws URISyntaxException {

        VaultContoller vaultContoller = new VaultContoller();
        vaultContoller.registerReq(new Credentials("janedoe", "iloveyou"));
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterReq2() throws URISyntaxException {
        (new VaultContoller()).registerReq(mock(Credentials.class));
    }
}

