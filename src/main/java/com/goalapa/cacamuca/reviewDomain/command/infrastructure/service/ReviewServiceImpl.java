package com.goalapa.cacamuca.reviewDomain.command.infrastructure.service;

import com.goalapa.cacamuca.reviewDomain.command.application.dto.ReviewDTO;
import com.goalapa.cacamuca.reviewDomain.command.domain.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Override
    public void saveReview(ReviewDTO reviewDTO) {
        System.out.println("reviewDTO = " + reviewDTO);
    }
}
