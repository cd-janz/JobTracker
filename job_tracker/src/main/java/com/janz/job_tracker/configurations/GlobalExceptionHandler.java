package com.janz.job_tracker.configurations;

import com.janz.job_tracker.models.ApiResponse;
import com.janz.job_tracker.utils.ResponseUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebInputException;

import java.nio.file.AccessDeniedException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Void>> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseUtil.error("Invalid argument: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, List<String>>>> handleValidationError(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errorsMap = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(DefaultMessageSourceResolvable::getDefaultMessage, Collectors.toList())
                ));

        return ResponseUtil.error("Validation failed", HttpStatus.BAD_REQUEST, errorsMap);
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<ApiResponse<Map<String, List<String>>>> handleWebFluxValidationError(WebExchangeBindException ex) {
        Map<String, List<String>> errorsMap = ex.getFieldErrors()
                .stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(DefaultMessageSourceResolvable::getDefaultMessage, Collectors.toList())
                ));

        return ResponseUtil.error("Validation failed", HttpStatus.BAD_REQUEST, errorsMap);
    }

    @ExceptionHandler(ServerWebInputException.class)
    public ResponseEntity<ApiResponse<Map<String, List<String>>>> handleServerWebInput(ServerWebInputException ex) {
        ex.getMostSpecificCause();
        String message = ex.getMostSpecificCause().getMessage();

        Map<String, List<String>> fieldErrors = new HashMap<>();

        Pattern pattern = Pattern.compile("(?<=\\[\")\\w+(?=\"])");
        Matcher matcher = pattern.matcher(message);
        String field = matcher.find() ? matcher.group() : "unknown";

        String cleanMsg;
        String lower = message.toLowerCase();
        if (lower.contains("missing") || lower.contains("null")) {
            cleanMsg = "Field is required";
        } else if (message.contains("Cannot deserialize")) {
            cleanMsg = "Invalid data type";
        } else {
            cleanMsg = "Invalid value";
        }

        fieldErrors.put(field, Collections.singletonList(cleanMsg));

        return ResponseUtil.error("Invalid request body", HttpStatus.BAD_REQUEST, fieldErrors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<Void>> handleUnreadableHttpMessage(HttpMessageNotReadableException ex) {
        ex.getMostSpecificCause();
        return ResponseUtil.error(
                "Malformed JSON request or incorrect types: " + ex.getMostSpecificCause().getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<ApiResponse<Void>> handleSecurityException(SecurityException ex) {
        return ResponseUtil.error("Authentication error: " + ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleAuthenticationCredentialsNotFoundException(AuthenticationCredentialsNotFoundException ex) {
        return ResponseUtil.error("Authentication error: " + ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<ApiResponse<Void>> handleAuthorizationDeniedException(AuthorizationDeniedException ex) {
        return ResponseUtil.error("You don't have permissions to access", HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ApiResponse<Void>> handleExpiredJwtException(ExpiredJwtException ex) {
        return ResponseUtil.error("Token expired: " + ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse<Void>> handleAccessDeniedException(AccessDeniedException ex) {
        return ResponseUtil.error("Access denied: " + ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(ValidationException ex) {
        return ResponseUtil.error("Validation failed: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception ex) {
        logger.error("Unhandled exception", ex);
        return ResponseUtil.error("Unexpected error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}