package ru.digimatics.deleteservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.digimatics.deleteservice.repository.UserRepository;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;

    @Transactional
    public void deleteBefore(LocalDateTime beforeDate) {
        log.info(this.getClass().getSimpleName() + " begin deleting data");
        userRepository.deleteAllBeforeDate(beforeDate);
        log.info(this.getClass().getSimpleName() + " end deleting data");
    }
}
