package umc.study.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.study.apiPayload.code.BaseCode;
import umc.study.apiPayload.code.Reason;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    _OK(HttpStatus.OK, "200", "Request was successful"),
    _CREATED(HttpStatus.CREATED, "201", "Resource was created successfully");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public Reason getReasonHttpStatus() {
        return Reason.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
    @Override
    public Reason getReason() {
        return Reason.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }


}
