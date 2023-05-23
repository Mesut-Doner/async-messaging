package com.mdoner.training.RabbitmqTutorial.shipping.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_shipping")
@Builder
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String emailAddress;
    private String notes;
    private String phoneNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Shipping shipping = (Shipping) o;
        return getId() != null && Objects.equals(getId(), shipping.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
