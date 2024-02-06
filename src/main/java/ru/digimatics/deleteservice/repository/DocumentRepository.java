package ru.digimatics.deleteservice.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.digimatics.deleteservice.domain.Document;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {

    @Modifying
    @Query("delete from Document d where d.issuanceDate < :beforeDate")
    void deleteAllBeforeDate(LocalDateTime beforeDate);
}
