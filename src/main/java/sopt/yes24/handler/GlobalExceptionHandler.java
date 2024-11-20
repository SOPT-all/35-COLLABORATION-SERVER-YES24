package sopt.yes24.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 400 Bad Request
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleBadRequest(Exception exception) {
        Map<String, String> response = new HashMap<>();
        response.put("code", "error");
        response.put("message", "입자의 형식이 올바르지 않습니다.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // 404 Not Found
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(Exception exception) {
        Map<String, String> response = new HashMap<>();
        response.put("code", "error");
        response.put("message", "존재하지 않는 api 입니다.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // 500 Internal Server Error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleInternalServerError(Exception exception) {
        Map<String, String> response = new HashMap<>();
        response.put("code", "error");
        response.put("message", "서버 내부 오류입니다. 잠시 후 다시 시도해주세요.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
