package me.employeecrud.Rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
