package exception;

/**
 * Created by sarmeetsingh on 8/16/16 with love and lots of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class CompanyException extends Exception {
    private String errorCode;

    public CompanyException(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
