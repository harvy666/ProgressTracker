package com.example.progresstracker.controller;


import com.example.progresstracker.model.UserStory;
import com.example.progresstracker.service.UserStoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")

public class UserStoryController {

    private final UserStoryService service;
    public UserStoryController(UserStoryService service) {
        this.service = service;
    }


    @GetMapping("/")
    public String getUserStories(Model model) {
        model.addAttribute("userStories",service.getUserStoryList() );
        return "index";
    }



    @PostMapping("/story")
    public String addStory(@RequestParam String storytitle, @RequestParam String userstory, @RequestParam String acceptancecriteria, @RequestParam double businessvalue, @RequestParam int estimation) {
        service.addUserStory(new UserStory(storytitle, userstory, acceptancecriteria, businessvalue, estimation, "in progress"));
        return "redirect:/";

    }


    @GetMapping("/story")
    public String story() {
        return "story";
    }

    // UPDATE PART

    @GetMapping("/story/{id}")

    public String fillUpdateForm(@PathVariable long id, Model model){
        UserStory userStory=service.getUserStoryByID(id);
        model.addAttribute("story", userStory);
        return "update";
    }


    @PostMapping("/story/{id}")
    public String updateStory(@PathVariable long id, @RequestParam String storytitle, @RequestParam String userstory, @RequestParam String acceptancecriteria, @RequestParam double businessvalue, @RequestParam int estimation, @RequestParam String status) {
        service.updateUserStory(new UserStory(storytitle, userstory, acceptancecriteria, businessvalue, estimation, status),id);
        return "redirect:/";
    }



}
