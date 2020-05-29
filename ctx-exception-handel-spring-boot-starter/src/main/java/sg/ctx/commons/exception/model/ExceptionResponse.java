package sg.ctx.commons.exception.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

/**
 * @author yu.miao
 */
@JsonPropertyOrder({"id", "timestamp", "status","error","message"})
public class ExceptionResponse {
    private String id;
    private Date timestamp;
    private int status;
    private String error;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
