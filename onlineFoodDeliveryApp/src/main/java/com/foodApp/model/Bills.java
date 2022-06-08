package com.foodApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer billId;
    @NotNull
    private LocalDateTime billDate;
    @NotNull
    private Integer BillCount;
    private Integer totalCost;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private Orders orders;
}
