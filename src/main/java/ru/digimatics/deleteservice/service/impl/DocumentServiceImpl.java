package ru.digimatics.deleteservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.digimatics.deleteservice.repository.DocumentRepository;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentServiceImpl {

    private final DocumentRepository documentRepository;

    @Transactional
    public void deleteBefore(LocalDateTime beforeDate) {
        log.info(this.getClass().getSimpleName() + " begin deleting data");
        documentRepository.deleteAllBeforeDate(beforeDate);
        log.info(this.getClass().getSimpleName() + " end deleting data");
    }

}
