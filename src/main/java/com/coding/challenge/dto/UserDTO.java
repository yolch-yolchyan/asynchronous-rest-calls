package com.coding.challenge.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;

    private String name;

    private String username;

    private String email;

    private Address address;

    private String phone;

    private String website;

    private Company company;

    @Data
    private static class Address {

        private String street;

        private String suite;

        private String city;

        private String zipcode;

        private Geo geo;

    }

    @Data
    private static class Geo {

        private String lat;

        private String lng;

    }

    @Data
    private static class Company {

        private String name;

        private String catchPhrase;

        private String bs;

    }

}
