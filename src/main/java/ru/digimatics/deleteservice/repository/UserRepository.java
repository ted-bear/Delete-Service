package ru.digimatics.deleteservice.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.digimatics.deleteservice.domain.User;

import java.time.LocalDateTime;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Modifying
    @Query("delete from User u where u.registrationDate < :beforeDate")
    void deleteAllBeforeDate(LocalDateTime beforeDate);

}
