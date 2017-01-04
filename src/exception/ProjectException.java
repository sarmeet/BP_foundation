package exception;

/**
 * Created by sarmeetsingh on 8/2/16 with love and lots of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class ProjectException extends Exception {
    private String errorCode;

    public ProjectException(String code) {
        this.errorCode = code;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
