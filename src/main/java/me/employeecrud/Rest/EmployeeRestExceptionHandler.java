package me.employeecrud.Rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> employeeNotFound(EmployeeNotFoundException exception){
        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
        employeeErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        employeeErrorResponse.setMessage(exception.getMessage());
        employeeErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> defaultHandler(Exception exception){
        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();

        employeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        employeeErrorResponse.setMessage(exception.getMessage());
        employeeErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
