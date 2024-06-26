package umc.study.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class Reason {
    private String code;
    private String message;
    private final boolean isSuccess;
    private final HttpStatus httpStatus;
}
