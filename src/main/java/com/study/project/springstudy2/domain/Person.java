package com.study.project.springstudy2.domain;

import com.study.project.springstudy2.controller.dto.PersonDto;
import com.study.project.springstudy2.domain.dto.Birthday;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Where(clause = "deleted = false")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NonNull
    @Min(1)
    private int age;

    private String hobby;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String bloodType;

    private String address;

    @Valid
    @Embedded
    private Birthday birthday;

    private String job;

    @ToString.Exclude
    private String phoneNumber;

    // 현업에서 사용하는 soft delete 방식
    @ColumnDefault("0")
    private boolean deleted;

    // EAGER Type : 처음에 바로 left outer join (optional = false를 사용하면 inner join)
    // LAZY Type : 필요한 시점에 select
    // orphanRemoval = true : Person 엔티티가 삭제될 때 참조가 끊어진 연관된 Block 엔티티도 삭제해라는 의미
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) // Person과 Block의 연속성을 함께 관리
    @ToString.Exclude
    private Block block;

    public void set(@NotNull PersonDto personDto){
        if(personDto.getAge() != 0){
            this.setAge(personDto.getAge());
        }

        if(!StringUtils.isEmpty(personDto.getHobby())){
            this.setHobby(personDto.getHobby());
        }

        if(!StringUtils.isEmpty(personDto.getBloodType())){
            this.setBloodType(personDto.getBloodType());
        }

        if(!StringUtils.isEmpty(personDto.getAddress())){
            this.setAddress(personDto.getAddress());
        }

        if(!StringUtils.isEmpty(personDto.getJob())){
            this.setJob(personDto.getJob());
        }

        if(!StringUtils.isEmpty(personDto.getPhoneNumber())){
            this.setPhoneNumber(personDto.getPhoneNumber());
        }
    }
}
