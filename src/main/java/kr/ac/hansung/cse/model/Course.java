package kr.ac.hansung.cse.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Course {
    @Size(min=7, max=7, message="Text must be exactly 7 chars")
    public String code;

    @NotNull(message="The field cannot be null")
    @Digits(integer=4, fraction=0, message="The year must be a number")
    public int year;

    @Min(value=1, message="Semester must be either 1 or 2")
    @Max(value=2, message="Semester must be either 1 or 2")
    public int semester;

    @NotEmpty(message="The field cannot be empty")
    public String subjectName;

    @NotEmpty(message="The field cannot be empty")
    public String subjectClassification;

    @NotEmpty(message="The field cannot be empty")
    public String professor;

    @Min(value=1, message="Grade must be between 1 and 4")
    public int grade;
}
