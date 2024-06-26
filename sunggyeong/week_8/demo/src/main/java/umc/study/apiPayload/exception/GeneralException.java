package umc.study.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.ErrorReason;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReason getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReason getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
