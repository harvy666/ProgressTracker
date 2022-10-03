package com.example.progresstracker.dao;

import com.example.progresstracker.model.UserStory;

import java.util.List;

public interface UserStoryDAO {

    void addUserStory(UserStory userStory);
    List<UserStory> getUserStoryList();
    UserStory getUserStoryByID(long id);
    void updateUserStory(UserStory userStory, long id);

}
