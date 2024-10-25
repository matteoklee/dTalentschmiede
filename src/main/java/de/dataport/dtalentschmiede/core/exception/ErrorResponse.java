package de.dataport.dtalentschmiede.core.exception;

/**
 * Class "ErrorResponse" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 23.10.2024
 */
public class ErrorResponse {

    private int statusCode;
    private String message;
    private String timestamp;

    public ErrorResponse(int statusCode, String message, String timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
