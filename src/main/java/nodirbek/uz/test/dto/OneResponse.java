package nodirbek.uz.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OneResponse {
    private String message;
    private Object response;
}
