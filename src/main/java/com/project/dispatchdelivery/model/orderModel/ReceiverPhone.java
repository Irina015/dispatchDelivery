package com.project.dispatchdelivery.model.orderModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReceiverPhone(
        @JsonProperty("countryCode")
        Integer countryCode,
        @JsonProperty("areaCode")
        Integer areaCode,
        @JsonProperty("phoneNumber")
        String phoneNumber,
        @JsonProperty("isoCode")
        String isoCode,
        @JsonProperty("valid")
        Boolean valid
) {
}
