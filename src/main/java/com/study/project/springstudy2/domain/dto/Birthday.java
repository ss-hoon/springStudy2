package com.study.project.springstudy2.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable // Person.birthday와 연결
@NoArgsConstructor
@Data
public class Birthday {

    private Integer yearOfBirthday;

    private Integer monthOfBirthday;

    private Integer dayOfBirthday;

    private Birthday(@NotNull LocalDate birthday){
        this.yearOfBirthday = birthday.getYear();
        this.monthOfBirthday = birthday.getMonthValue();
        this.dayOfBirthday = birthday.getDayOfMonth();
    }

    public static Birthday of(LocalDate birthday){
        return new Birthday(birthday);
    }
}
