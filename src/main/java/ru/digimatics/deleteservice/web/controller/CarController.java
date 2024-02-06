package ru.digimatics.deleteservice.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.digimatics.deleteservice.service.impl.CarServiceImpl;
import ru.digimatics.deleteservice.web.dto.DateBeforeDeleteDto;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarServiceImpl carService;

    @PostMapping("/delete")
    public DateBeforeDeleteDto delete(@RequestBody DateBeforeDeleteDto beforeDeleteDto) {
        log.info("Controller " + this.getClass().getSimpleName() + " receive request for delete with date: " + beforeDeleteDto.getBeforeDate());

        carService.deleteBefore(beforeDeleteDto.getBeforeDate());

        log.info("Controller " + this.getClass().getSimpleName() + " processed request");

        return beforeDeleteDto;
    }
}
