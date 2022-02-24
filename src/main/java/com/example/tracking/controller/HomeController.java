package com.example.tracking.controller;

import com.example.tracking.model.ResultData;
import com.example.tracking.service.PrefixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    private final PrefixService prefixService;

    @Autowired
    public HomeController(PrefixService prefixService) {
        this.prefixService = prefixService;
    }

    @GetMapping("/home")
    public String getYourDestiny(){
        return "home";
    }


    @PostMapping("/findcontainer") //это кнопка action, если void, то GetMapping на /search должен быть
    public String searchPage(@RequestParam("fullnamecontainer") String request, RedirectAttributes redirectAttributes) {
        System.out.println(request);
        redirectAttributes.addAttribute("fullnamecontainer", request);
        //String url = prefixService.getURLforSearch(request); работает
        //prefixService.toJSON(request); //работает
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String resultPage(@RequestParam("fullnamecontainer") String request, Model model) { //передает request c PostMapping
        model.addAttribute("output", request);
        ResultData result = prefixService.getCommonResult(request);
        model.addAttribute("result", result);
        result.getDateOfLoading();
        return "result";
    }
}
