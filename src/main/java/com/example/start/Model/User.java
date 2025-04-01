package com.example.start.Model;

import com.example.start.Validators.EmailConstraint;
import com.example.start.Validators.PasswordConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@AllArgsConstructor
public class User {
    private final long id;

    @NotBlank(message = "{required}")
    private String name;

    @EmailConstraint
    private String email;

    @PasswordConstraint
    private String password;

    @NotNull
    @Min(18)
    @Max(120)
    private Integer age;
}
