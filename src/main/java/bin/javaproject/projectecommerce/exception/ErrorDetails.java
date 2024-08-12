package bin.javaproject.projectecommerce.exception;

import lombok.Data;
import java.util.Date;
import org.springframework.http.HttpStatus;

@Data
public class ErrorDetails {
    private Date timestamp;
    private HttpStatus status;
    private String message;
    private String details;

    public ErrorDetails(HttpStatus status, String message, String details) {
        super();
        this.timestamp = new Date();
        this.status = status;
        this.message = message;
        this.details = details;
    }
}
