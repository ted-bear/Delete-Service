package ru.digimatics.deleteservice.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.digimatics.deleteservice.service.impl.DocumentServiceImpl;
import ru.digimatics.deleteservice.web.dto.DateBeforeDeleteDto;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/document")
public class DocumentController {

    private final DocumentServiceImpl documentService;


    @PostMapping("/delete")
    public DateBeforeDeleteDto deleteAllBeforeDate(@RequestBody DateBeforeDeleteDto dateBeforeDeleteDto) {
        log.info("Controller " + this.getClass().getSimpleName() + " receive request for delete with date: " + dateBeforeDeleteDto.getBeforeDate());
        documentService.deleteBefore(dateBeforeDeleteDto.getBeforeDate());
        log.info("Controller " + this.getClass().getSimpleName() + " processed request");

        return dateBeforeDeleteDto;
    }

}
