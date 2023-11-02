package com.example.ex04.controller;

import com.example.ex04.domain.ProductVO;
import com.example.ex04.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/product/*")
public class ProductController {
    private final ProductService productService;

    @GetMapping("list")
    public String list(Model model){
        model.addAttribute("productForm", new ProductVO());
        model.addAttribute("products", productService.getList());
        return "/product";
    }

    @PostMapping("new")
    @ResponseBody
    public void register(@RequestBody ProductVO productVO){
        productService.register(productVO);
    }

    //외부에서 전달받은 json 이 productVO의 필드에 자동으로 매핑(@RequestBody를 사용해야한다.)
}
