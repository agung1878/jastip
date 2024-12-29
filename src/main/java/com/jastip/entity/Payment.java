package com.jastip.entity;


import com.jastip.constants.PaymentMethod;
import com.jastip.constants.PaymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Payment extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "id_order", nullable = false, columnDefinition = "varchar(36)")
    private Order order;

    private BigDecimal amount;
    private PaymentType paymentType;
    private PaymentMethod paymentMethod;

}
