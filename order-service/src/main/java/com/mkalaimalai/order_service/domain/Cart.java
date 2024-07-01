package com.mkalaimalai.order_service.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name = "carts")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"orders"})
@Data
@Builder
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", unique = true, nullable = false, updatable = false)
    private Long cartId;

    @Column(name = "user_id")
    private Integer userId;

    @JsonIgnore
    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> orders;

}

