package ru.digimatics.deleteservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.digimatics.deleteservice.repository.batch.BatchRepository;
import ru.digimatics.deleteservice.service.BatchService;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;

    @Override
    public void updateUsersTable() {
        batchRepository.add4MillionsUsers();
    }

    @Override
    public void updateCarsTable() {
        batchRepository.add4MillionsCars();
    }

    @Override
    public void updateDocumentsTable() {
        batchRepository.add4MillionsDocuments();
    }
}
