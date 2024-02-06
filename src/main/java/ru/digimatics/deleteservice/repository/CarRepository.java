package ru.digimatics.deleteservice.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.digimatics.deleteservice.domain.Car;

import java.time.LocalDateTime;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    @Modifying
    @Query("delete from Car c where c.startExploitationDate < :beforeDate")
    void deleteAllBeforeDate(LocalDateTime beforeDate);

}
