package com.goalapa.cacamuca.foodDomain.command.application.controller;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodDTO;
import com.goalapa.cacamuca.foodDomain.command.application.service.FoodRegistService;
import com.goalapa.cacamuca.foodDomain.command.domain.service.SaveFoodFromRequest;
import com.goalapa.cacamuca.foodDomain.command.domain.service.SaveFoodPicFromRequest;
import com.goalapa.cacamuca.requestDomain.command.application.service.DeleteRequestImpl;
import com.goalapa.cacamuca.requestDomain.command.application.service.DeleteRequestPicImpl;
import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/food-regist")
public class FoodController {

    private final SaveFoodFromRequest saveFoodFromRequest;
    private final SaveFoodPicFromRequest saveFoodPicFromRequest;
    private final FoodRegistService foodRegistService;

    private final DeleteRequestImpl deleteRequestImpl;
    private final DeleteRequestPicImpl deleteRequestPicImpl;

    public FoodController(SaveFoodFromRequest saveFoodFromRequest, SaveFoodPicFromRequest saveFoodPicFromRequest, FoodRegistService foodRegistService, DeleteRequestImpl deleteRequestImpl, DeleteRequestPicImpl deleteRequestPicImpl) {
        this.saveFoodFromRequest = saveFoodFromRequest;
        this.saveFoodPicFromRequest = saveFoodPicFromRequest;
        this.foodRegistService = foodRegistService;
        this.deleteRequestImpl = deleteRequestImpl;
        this.deleteRequestPicImpl = deleteRequestPicImpl;
    }

    @PostMapping("/request-list/view/save-request")
    public String saveRequest(@ModelAttribute FindRequestDTO findRequestDTO, @RequestParam("imageUrl") String url) {

        FoodDTO food = new FoodDTO();
        food.setFoodName(findRequestDTO.getRequestFood());
        food.setFoodPrice(findRequestDTO.getRequestPrice());
        food.setFoodType(findRequestDTO.getRequestFoodType());
        food.setCountry(findRequestDTO.getRequestCountry());

        saveFoodFromRequest.saveFoodFromRequest(food);
        saveFoodPicFromRequest.saveFoodPicFromRequest(url);

        deleteRequestImpl.deleteRequest(findRequestDTO.getRequestNo());
        deleteRequestPicImpl.deleteRequestPic(findRequestDTO.getRequestNo());

        return "redirect:/request-list";
    }

    //식품 등록
//    @GetMapping("")
//    public String foodRegist() {
//        return "food-regist";
//    }
//
//    @PostMapping("")
//    public String registFood(@RequestParam MultipartFile registPic, @ModelAttribute FoodDTO foodDTO) throws IOException {
//
//
//        foodRegistService.saveFood(foodDTO, registPic);
//
//
//        return "food-regist";
//    }
//
//
//    //식품 삭제
//    @GetMapping("/test")
//    public void deleteFood(@PathVariable int foodNo) {
//
//        foodRegistService.deleteFood(foodNo);
//        foodRegistService.deleteFoodPic(foodNo);
//    }
}
