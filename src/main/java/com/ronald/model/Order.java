package com.ronald.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//JPA
@Entity
@Table(name = "Orders")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idOrder;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;
    @Column(length = 3, nullable = false)
    private String idProduct;
    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private double finalPrice;

}
