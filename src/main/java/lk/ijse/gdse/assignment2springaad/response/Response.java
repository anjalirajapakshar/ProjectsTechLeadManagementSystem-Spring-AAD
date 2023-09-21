package lk.ijse.gdse.assignment2springaad.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Response {
    private int statusCode;
    private String message;
    private Object data;
}
