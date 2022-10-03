package com.example.progresstracker.service;

import com.example.progresstracker.dao.UserStoryDAO;
import com.example.progresstracker.model.UserStory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStoryService {

    private final UserStoryDAO dao;

    public UserStoryService(UserStoryDAO dao) {
        this.dao = dao;
    }

    public void addUserStory(UserStory userStory) {
        dao.addUserStory(userStory);
    }

    public List<UserStory> getUserStoryList() {
        return dao.getUserStoryList();
    }

    public UserStory getUserStoryByID(long id) {
        return dao.getUserStoryByID(id);
    }

    public void updateUserStory(UserStory userStory, long id) {
        dao.updateUserStory(userStory, id);
    }
}
