package com.example.ex03.controller;

import com.example.ex03.domain.ProductVO;
import com.example.ex03.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product/*")
public class ProductController {
    private final ProductService productService;

    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("productVO", new ProductVO());
        return "/product/product-register";
    }

    @PostMapping("register")
    public RedirectView register(ProductVO productVO){
        productService.register(productVO);
        return new RedirectView("/product/list");
    }

    @GetMapping("list")
    public String list(Model model){
        model.addAttribute("products", productService.getList());
        return "/product/product-list";
    }
}
