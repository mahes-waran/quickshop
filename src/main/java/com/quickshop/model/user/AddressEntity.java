package com.quickshop.model.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses",schema = "user_mgmt")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "street_line1", nullable = false)
    private String streetLine1;

    @Column(name = "street_line2")
    private String streetLine2;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "state", nullable = false, length = 100)
    private String state;

    @Column(name = "postal_code", nullable = false, length = 20)
    private String postalCode;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @Column(name = "is_default_shipping", nullable = false)
    private Boolean isDefaultShipping;

    @Column(name = "is_default_billing", nullable = false)
    private Boolean isDefaultBilling;
}