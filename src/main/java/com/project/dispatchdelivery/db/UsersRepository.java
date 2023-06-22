package com.project.dispatchdelivery.db;

import com.project.dispatchdelivery.db.entity.UsersEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface UsersRepository extends ListCrudRepository<UsersEntity, Long> {
    List<UsersEntity> findByLastName(String lastName);
    List<UsersEntity> findByFirstName(String firstName);

    UsersEntity findByUsername(String username);
    @Modifying
    @Query("UPDATE users SET first_name = :firstName, last_name = :lastName WHERE username = :username")
    void updateNameByUsername(String username, String firstName, String lastName);

    @Modifying
    @Query("UPDATE users SET phone_number = :phoneNumber, email_address = :emailAddress WHERE username = :username")
    void updatePhoneEmailByUsername(String username, String phoneNumber, String emailAddress);
}
