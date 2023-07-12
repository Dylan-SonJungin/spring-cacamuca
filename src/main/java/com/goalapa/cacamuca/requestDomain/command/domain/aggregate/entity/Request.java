package com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity;

import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestCountry;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestFoodType;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestMemberNo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_no")
    private Integer requestNo;

    @Column(name = "request_food")
    private String requestedFood;

    @Column(name = "request_price")
    private Integer requestPrice;

    @Embedded
    private RequestMemberNo requestMemberNo;

    @Embedded
    private RequestCountry requestCountry;

    @Embedded
    private RequestFoodType requestFoodType;

    @Column(name = "request_content")
    private String requestContent;

    public Request(String requestedFood, Integer requestPrice, RequestMemberNo memberNo,
                   RequestCountry country, RequestFoodType foodType, String requestContent) { }
}
