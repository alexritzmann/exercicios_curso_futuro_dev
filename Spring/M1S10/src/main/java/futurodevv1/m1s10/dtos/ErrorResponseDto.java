package futurodevv1.m1s10.dtos;

import java.util.List;

public record ErrorResponseDto(
        String code,
        String message,
        String cause,
        String exceptionClassName,
        List<String> errors
)
{
    public ErrorResponseDto(String code, String message, String cause, String exceptionClassName)
    {
        this(code, message, cause, exceptionClassName, null);
    }
}