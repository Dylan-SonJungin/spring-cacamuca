package com.goalapa.cacamuca.reviewDomain.query.application.controller;

import com.goalapa.cacamuca.memberDomain.command.application.dto.CustomUser;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.service.SelectReviewService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/*")
public class SelectReviewController {
    private final SelectReviewService selectReviewService;
    private static final Logger logger = LoggerFactory.getLogger(SelectReviewController.class);

    public SelectReviewController(SelectReviewService selectReviewService) {
        this.selectReviewService = selectReviewService;
    }


    @GetMapping("/selectReviews")
    public String selectReviews(Model model){
//        List<QueryReviewPicDTO> reviewPictures = selectReviewService.getPictures();
//        model.addAttribute("reviewPictures", reviewPictures);

        List<QueryReviewDTO> reviews = selectReviewService.findAllReviews();

        model.addAttribute("reviews", reviews);

        return "selectReviews";
    }

    @GetMapping("/detail")
    public String selectReview(Model model, @RequestParam int no, @RequestParam(defaultValue = "1") int member){
        model.addAttribute("review", selectReviewService.findReviewByNo(no));

        QueryReviewDTO review = selectReviewService.findReviewByNo(no);
//        logger.info(String.valueOf(review.getReviewRate()));

        model.addAttribute("no", no);
        model.addAttribute("member", member);

        return "reviewDetail";
    }
}
