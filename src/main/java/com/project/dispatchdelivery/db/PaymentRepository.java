package com.project.dispatchdelivery.db;


import com.project.dispatchdelivery.db.entity.PaymentEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends ListCrudRepository<PaymentEntity, Long> {

    @Modifying
    @Query("INSERT INTO payment (card_number, holder_name, expired_date, cvv, billing_address, city, state, zip_code) VALUES (:cardNumber, :holderName, :expiredDate, :cvv, :billingAddress, :city, :state, :zipCode)")
    void createPayment(String cardNumber, String holderName, String expiredDate, String cvv,
                       String billingAddress, String city, String state, String zipCode);

}
