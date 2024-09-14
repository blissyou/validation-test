package org.example.validation.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.validation.annotation.PhoneNumber;
import org.example.validation.annotation.YearMonth;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {
    //@NotNull  // != null
    //@NotEmpty // !=null && name != ""
    //@NotBlank // !=null && name != "" && name != " "
    private String name;

    private String nickname;

    @Size(min = 1,max =12)
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @YearMonth(patten = "yyyyMM")
    private String birthDayYearMonth;

    @AssertTrue(message = "name or nickname 은 반드시 1개가 존재해야 합니다.")
    private boolean isNameCheck(){
        if (Objects.nonNull(name) && !name.isBlank()){
            return true;
        }
        if (Objects.nonNull(nickname) && !nickname.isBlank()){
            return true;
        }
        return false;
    }
}
