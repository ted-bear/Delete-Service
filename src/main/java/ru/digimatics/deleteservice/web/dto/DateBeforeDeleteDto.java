package ru.digimatics.deleteservice.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DateBeforeDeleteDto {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime beforeDate;

}
