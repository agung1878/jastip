package com.jastip.entity;


import com.jastip.constants.OrderStatus;
import com.jastip.entity.security.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "t_order")
public class Order extends BaseEntity{

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private List<Product> products = new ArrayList<>();

    private OrderStatus orderStatus;


}
