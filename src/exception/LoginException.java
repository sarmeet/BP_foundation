package exception;

/**
 * Created by sarmeetsingh on 7/31/16.
 */
public class LoginException extends Exception {
    private String errorCode;

    public LoginException(String errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
