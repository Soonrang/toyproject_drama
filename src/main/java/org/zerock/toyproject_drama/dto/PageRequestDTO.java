package org.zerock.toyproject_drama.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.time.LocalDate;
//import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    @Builder.Default
    @Min(value = 1)
    @Positive

    private int page =1;

    @Builder.Default
    // 외부에서 조작하는 것에 대해 대비 (Min과 Max를 설정)
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    //건너뛰기 수를 설정
    public int getSkip() {
        return (page-1) * 10;
    }

}
