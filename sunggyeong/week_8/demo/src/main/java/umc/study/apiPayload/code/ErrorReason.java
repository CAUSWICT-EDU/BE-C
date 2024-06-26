package umc.study.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ErrorReason {
    private final String message;
    private final String code;
    private final boolean isSuccess;
    private final HttpStatus httpStatus;

}
