package me.employeecrud.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;
    private String email;

}
