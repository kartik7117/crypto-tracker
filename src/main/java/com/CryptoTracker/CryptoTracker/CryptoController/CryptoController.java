package com.CryptoTracker.CryptoTracker.CryptoController;

import com.CryptoTracker.CryptoTracker.CryptoService.CryptoService;
import com.CryptoTracker.CryptoTracker.model.CryptoCoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Controller
public class CryptoController {
    @Autowired
    private CryptoService cryptoService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/track")
    public String track(@RequestParam String coins, Model model){
        List<String> coinlist= Arrays.asList(coins.split(","));
        List<CryptoCoin> result=cryptoService.getcryptoprices(coinlist);
        model.addAttribute("coins",result);
        return "result";
    }
}
