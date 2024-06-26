package umc.study.apiPayload.code;

public interface BaseErrorCode {
    public ErrorReason getReason();

    public ErrorReason getReasonHttpStatus();
}
