package com.project.dispatchdelivery.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table("credit_card")
public class CreditCardEntity implements Serializable {
        private static final long serialVersionUID = 7964993652255519923L;

        @Id
        private long id;
        private String holderName;
        private String cardNumber;
        private String billingAddress;
        private String CardLabel;
        private String CVV;
        private String zip;
        private String expDate;
        private boolean def = false;

        @ManyToOne(fetch = FetchType.EAGER)
        @JsonIgnore
        private UsersEntity usersEntity;

        @OneToOne(mappedBy = "credit_card")
        private OrderEntity order;


}
