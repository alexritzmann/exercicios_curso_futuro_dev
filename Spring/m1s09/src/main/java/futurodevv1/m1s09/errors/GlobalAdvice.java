package futurodevv1.m1s09.errors;

import futurodevv1.m1s09.dtos.ErrorResponseDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseDto> exception(NoSuchElementException e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(
                "404",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getSimpleName()
        ));
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> exception(ChangeSetPersister.NotFoundException e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(
                "404",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getSimpleName()
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex)
    {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        return ResponseEntity.badRequest().body(new ErrorResponseDto(
                "400",
                "Validation error",
                errors.toString(),
                ex.getClass().getSimpleName()
        ));
    }

}