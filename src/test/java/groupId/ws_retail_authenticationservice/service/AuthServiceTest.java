//package groupId.ws_retail_authenticationservice.service;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import groupId.ws_retail_authenticationservice.model.Credentials;
//
//import java.net.URISyntaxException;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.vault.core.VaultKeyValueOperations;
//import org.springframework.vault.core.VaultKeyValueOperationsSupport;
//import org.springframework.vault.core.VaultTemplate;
//import org.springframework.vault.support.VaultResponseSupport;
//
//@ContextConfiguration(classes = {AuthService.class})
//@ExtendWith(SpringExtension.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//class AuthServiceTest {
//    @Autowired
//    private AuthService authService;
//
//    @MockBean
//    private VaultTemplate vaultTemplate;
//
//    @Test
//    void testRegisterUserService3() {
//        VaultKeyValueOperations vaultKeyValueOperations = mock(VaultKeyValueOperations.class);
//        doNothing().when(vaultKeyValueOperations).put((String) any(), (Object) any());
//        when(vaultTemplate.opsForKeyValue((String) any(), (VaultKeyValueOperationsSupport.KeyValueBackend) any()))
//                .thenReturn(vaultKeyValueOperations);
//        authService.registerUserService(new Credentials("janedoe", "iloveyou"));
//        verify(vaultTemplate).opsForKeyValue((String) any(), (VaultKeyValueOperationsSupport.KeyValueBackend) any());
//        verify(vaultKeyValueOperations).put((String) any(), (Object) any());
//    }
//
//
//    @Test
//    void testLoginUserService3() throws Exception {
//        VaultResponseSupport<Credentials> vaultResponseSupport = new VaultResponseSupport<>();
//        vaultResponseSupport.setAuth(new HashMap<>());
//        vaultResponseSupport.setData(new Credentials("janedoe", "iloveyou"));
//        vaultResponseSupport.setLeaseDuration(1L);
//        vaultResponseSupport.setLeaseId("42");
//        vaultResponseSupport.setMetadata(new HashMap<>());
//        vaultResponseSupport.setRenewable(true);
//        vaultResponseSupport.setRequestId("42");
//        vaultResponseSupport.setWarnings(new ArrayList<>());
//        vaultResponseSupport.setWrapInfo(new HashMap<>());
//        VaultKeyValueOperations vaultKeyValueOperations = mock(VaultKeyValueOperations.class);
//        when(vaultKeyValueOperations.get((String) any(), (Class<Credentials>) any())).thenReturn(vaultResponseSupport);
//        when(vaultTemplate.opsForKeyValue((String) any(), (VaultKeyValueOperationsSupport.KeyValueBackend) any()))
//                .thenReturn(vaultKeyValueOperations);
//        assertTrue(authService.loginUserService(new Credentials("janedoe", "iloveyou")));
//        verify(vaultTemplate).opsForKeyValue((String) any(), (VaultKeyValueOperationsSupport.KeyValueBackend) any());
//        verify(vaultKeyValueOperations).get((String) any(), (Class<Credentials>) any());
//    }
//
//
//    @Test
//    void testLoginUserService4() throws Exception {
//        VaultResponseSupport<Credentials> vaultResponseSupport = new VaultResponseSupport<>();
//        vaultResponseSupport.setAuth(new HashMap<>());
//        vaultResponseSupport.setData(new Credentials("janedoe", "iloveyou"));
//        vaultResponseSupport.setLeaseDuration(1L);
//        vaultResponseSupport.setLeaseId("42");
//        vaultResponseSupport.setMetadata(new HashMap<>());
//        vaultResponseSupport.setRenewable(true);
//        vaultResponseSupport.setRequestId("42");
//        vaultResponseSupport.setWarnings(new ArrayList<>());
//        vaultResponseSupport.setWrapInfo(new HashMap<>());
//        VaultKeyValueOperations vaultKeyValueOperations = mock(VaultKeyValueOperations.class);
//        when(vaultKeyValueOperations.get((String) any(), (Class<Credentials>) any())).thenReturn(vaultResponseSupport);
//        when(vaultTemplate.opsForKeyValue((String) any(), (VaultKeyValueOperationsSupport.KeyValueBackend) any()))
//                .thenReturn(vaultKeyValueOperations);
//        assertFalse(
//                authService.loginUserService(new Credentials("secret/data/ws_retail_authenticationservice", "iloveyou")));
//        verify(vaultTemplate).opsForKeyValue((String) any(), (VaultKeyValueOperationsSupport.KeyValueBackend) any());
//        verify(vaultKeyValueOperations).get((String) any(), (Class<Credentials>) any());
//    }
//}
//
