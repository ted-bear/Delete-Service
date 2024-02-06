package ru.digimatics.deleteservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.digimatics.deleteservice.service.BatchService;

@Controller
@RequestMapping("/batch/update")
@RequiredArgsConstructor
public class BatchController {

    private final BatchService batchService;

    @GetMapping("/users")
    public void updateUsers() {
        batchService.updateUsersTable();
    }

    @GetMapping("/cars")
    public void updateCars() {
        batchService.updateCarsTable();
    }

    @GetMapping("/documents")
    public void updateDocuments() {
        batchService.updateDocumentsTable();
    }
}
