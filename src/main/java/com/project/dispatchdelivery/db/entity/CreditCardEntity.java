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
@Entity
@Table(name = "credit_card")
public class CreditCardEntity implements Serializable {
        private static final long serialVersionUID = 7964993652255519923L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;
        private String holderName;
        private String cardNumber;
        private String billingAddress;
        private String CVV;
        private String zip;
        private String expDate;
        private boolean def = false;

        @ManyToOne(fetch = FetchType.EAGER)
        @JsonIgnore
        private UsersEntity usersEntity;

        @OneToOne(mappedBy = "credit_card")
        private OrderEntity order;

        public CreditCardEntity() {
        }

        public CreditCardEntity(long id, String holderName, String cardNumber, String billingAddress, String CVV, String zip, String expDate, boolean def, UsersEntity usersEntity, OrderEntity order) {
                this.id = id;
                this.holderName = holderName;
                this.cardNumber = cardNumber;
                this.billingAddress = billingAddress;
                this.CVV = CVV;
                this.zip = zip;
                this.expDate = expDate;
                this.def = def;
                this.usersEntity = usersEntity;
                this.order = order;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getHolderName() {
                return holderName;
        }

        public void setHolderName(String holderName) {
                this.holderName = holderName;
        }

        public String getCardNumber() {
                return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
                this.cardNumber = cardNumber;
        }

        public String getBillingAddress() {
                return billingAddress;
        }

        public void setBillingAddress(String billingAddress) {
                this.billingAddress = billingAddress;
        }

        public String getCVV() {
                return CVV;
        }

        public void setCVV(String CVV) {
                this.CVV = CVV;
        }

        public String getZip() {
                return zip;
        }

        public void setZip(String zip) {
                this.zip = zip;
        }

        public String getExpDate() {
                return expDate;
        }

        public void setExpDate(String expDate) {
                this.expDate = expDate;
        }

        public boolean isDef() {
                return def;
        }

        public void setDef(boolean def) {
                this.def = def;
        }

        public UsersEntity getUsersEntity() {
                return usersEntity;
        }

        public void setUsersEntity(UsersEntity usersEntity) {
                this.usersEntity = usersEntity;
        }

        public OrderEntity getOrder() {
                return order;
        }

        public void setOrder(OrderEntity order) {
                this.order = order;
        }
}
