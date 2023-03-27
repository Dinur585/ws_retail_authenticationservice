package groupId.ws_retail_authenticationservice.exception;

public class AccessDeniedException extends RuntimeException{

    public AccessDeniedException(String message){
        super(message);
    }
}
