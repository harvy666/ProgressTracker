package com.example.progresstracker.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserStory {


    private long id;

    @Size(min = 5, max = 100, message = "String length should remain between 5 and 100 characters")
    @NotBlank
    private String storyTitle;

    @Size(min = 1, max = 400, message = "String length should remain between 1 and 400 characters")
    @NotBlank
    private String userStory;

    @Size(min = 1, max = 400, message = "String length should remain between 1 and 400 characters")
    @NotBlank
    private String acceptanceCriteria;

    @DecimalMin("0.5")
    @DecimalMax("40.0")
    @NotBlank
    private double  businessValue;


    private int estimation;

    @Size(min = 1, max = 20, message = "String length should remain between 1 and 20 characters")
    @NotBlank
    private String status;


    public UserStory(String storyTitle, String userStory, String acceptanceCriteria, double businessValue, int estimation, String status) {
        this.storyTitle = storyTitle;
        this.userStory = userStory;
        this.acceptanceCriteria = acceptanceCriteria;
        this.businessValue = businessValue;
        this.estimation = estimation;
        this.status=status;
    }

    public UserStory() {
    }
}
