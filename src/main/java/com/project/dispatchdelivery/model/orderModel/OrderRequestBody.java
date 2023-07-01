package com.project.dispatchdelivery.model.orderModel;
import com.fasterxml.jackson.annotation.JsonProperty;


public record OrderRequestBody(
        @JsonProperty("user_id")
        Long userId,
        @JsonProperty("sender_address")
        String senderAddress,
        @JsonProperty("sender_city")
        String senderCity,
        @JsonProperty("sender_state")
        String senderState,
        @JsonProperty("sender_email")
        String senderEmail,
        @JsonProperty("sender_phone")
        SenderPhone senderPhone,
        @JsonProperty("receiver_address")
        String receiverAddress,
        @JsonProperty("receiver_city")
        String receiverCity,
        @JsonProperty("receiver_state")
        String receiverState,
        @JsonProperty("receiver_email")
        String receiverEmail,
        @JsonProperty("receiver_phone")
        ReceiverPhone receiverPhone
)
{
}
//public record OrderRequestBody(
//
//        @JsonProperty("Address")
//        String address,
//        @JsonProperty("City")
//        String city,
//        @JsonProperty("Email")
//        String email,
//        @JsonProperty("Name")
//        String name,
//        @JsonProperty("State")
//        String state,
//
//)
//{
//}

