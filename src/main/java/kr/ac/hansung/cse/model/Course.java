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
    @Size(min=7, max=7, message="7개의 문자를 입력해야 합니다")
    public String code;

    @NotNull(message="빈칸을 입력할 수 없습니다")
    @Digits(integer=4, fraction=0, message="4자리의 숫자로 입력해야 합니다.")
    public int year;

    @Min(value=1, message="학기는 1 또는 2로 입력해야 합니다.")
    @Max(value=2, message="학기는 1 또는 2로 입력해야 합니다.")
    public int semester;

    @NotEmpty(message="빈칸을 입력할 수 없습니다")
    public String subjectName;

    @NotEmpty(message="빈칸을 입력할 수 없습니다")
    public String subjectClassification;

    @NotEmpty(message="빈칸을 입력할 수 없습니다")
    public String professor;

    @Min(value=1, message="학점은 1에서 3사이여야 합니다.")
    @Max(value=3, message="학점은 1에서 3사이여야 합니다.")
    public int grade;
}
