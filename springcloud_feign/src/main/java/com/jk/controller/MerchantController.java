package com.jk.controller;

import com.jk.service.MerchantServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("merchant")
public class MerchantController {

    @Autowired
    private MerchantServiceFeign merchantService;
}
