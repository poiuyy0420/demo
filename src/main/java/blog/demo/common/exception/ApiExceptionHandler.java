package blog.demo.common.exception;

import blog.demo.common.code.CodeEnum;
import blog.demo.common.domain.BaseResult;
import blog.demo.common.domain.BaseResultFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public BaseResult unknownException(Exception ex) {
        log.error("message: {}, class: {}", ex.getMessage(), ex.getClass().getName());
        return BaseResultFactory.create(CodeEnum.UNKNOWN_EXCEPTION);
    }

    @ExceptionHandler(WebClientResponseException.class)
    public BaseResult WebClientResponseException(WebClientResponseException ex) {
        log.error("message: {}, class: {}", ex.getMessage(), ex.getClass().getName());
        return BaseResultFactory.create(CodeEnum.API_FAIL);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public BaseResult DataIntegrityViolationException(DataIntegrityViolationException ex) {
        log.error("message: {}, class: {}", ex.getMessage(), ex.getClass().getName());
        return BaseResultFactory.create(CodeEnum.DB_EXCEPTION);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult MethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("message: {}, class: {}", ex.getMessage(), ex.getClass().getName());
        return BaseResultFactory.create(CodeEnum.BIND_FAIL);
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResult RuntimeException(RuntimeException ex) {
        log.error("message: {}, class: {}", ex.getMessage(), ex.getClass().getName());
        return BaseResultFactory.create(CodeEnum.RUNTIME_EXCEPTION);
    }

}
