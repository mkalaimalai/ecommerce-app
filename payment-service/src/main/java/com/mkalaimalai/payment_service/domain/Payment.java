package com.mkalaimalai.payment_service.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "Customer")
public class Payment {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer paymentId;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "is_payed")
    private Boolean isPayed;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

}

