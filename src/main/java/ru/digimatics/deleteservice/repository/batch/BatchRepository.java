package ru.digimatics.deleteservice.repository.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.digimatics.deleteservice.domain.Car;
import ru.digimatics.deleteservice.domain.Document;
import ru.digimatics.deleteservice.domain.User;
import ru.digimatics.deleteservice.utils.BatchUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BatchRepository {

    private final JdbcTemplate jdbcTemplate;

    public void add4MillionsUsers() {
        List<User> users = BatchUtils.create2MillionsUsersAfter2005Year();
        users.addAll(BatchUtils.create2MillionsUsersBefore2005Year());

        jdbcTemplate.batchUpdate("insert into Users (username, registration_date) values (?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, users.get(i).getUsername());
                        ps.setTimestamp(2, Timestamp.valueOf(users.get(i).getRegistrationDate()));
                    }

                    @Override
                    public int getBatchSize() {
                        return users.size();
                    }
                });
    }

    public void add4MillionsCars() {
        List<Car> cars = BatchUtils.create2MillionsCarsBefore2005Year();
        cars.addAll(BatchUtils.create2MillionsCarsAfter2005Year());

        jdbcTemplate.batchUpdate("insert into Cars (brand, start_exploitation_date) values (?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, cars.get(i).getBrand());
                        ps.setTimestamp(2, Timestamp.valueOf(cars.get(i).getStartExploitationDate()));
                    }

                    @Override
                    public int getBatchSize() {
                        return cars.size();
                    }
                });
    }

    public void add4MillionsDocuments() {
        List<Document> documents = BatchUtils.create2MillionsDocumentsBefore2005Year();
        documents.addAll(BatchUtils.create2MillionsDocumentsAfter2005Year());

        jdbcTemplate.batchUpdate("insert into Documents (username, registration_date) values (?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setInt(1, documents.get(i).getNumber());
                        ps.setTimestamp(2, Timestamp.valueOf(documents.get(i).getIssuanceDate()));
                    }

                    @Override
                    public int getBatchSize() {
                        return documents.size();
                    }
                });
    }

}
