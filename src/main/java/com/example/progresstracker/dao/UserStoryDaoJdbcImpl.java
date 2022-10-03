package com.example.progresstracker.dao;

import com.example.progresstracker.mapper.UserStoryMapper;
import com.example.progresstracker.model.UserStory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserStoryDaoJdbcImpl implements UserStoryDAO{

    private JdbcTemplate template;
    private UserStoryMapper mapper;

    public UserStoryDaoJdbcImpl(JdbcTemplate template, UserStoryMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }



    @Override
    public void addUserStory(UserStory userStory) {
        String sql = "INSERT INTO userstory(story_title,user_story,acceptance_criteria,business_value,estimation,status) VALUES (?,?,?,?,?,?)";
        template.update(sql,userStory.getStoryTitle(),userStory.getUserStory(),userStory.getAcceptanceCriteria(),
                userStory.getBusinessValue(),userStory.getEstimation(),userStory.getStatus());
    }



    @Override
    public List<UserStory> getUserStoryList() {
        String sql = "SELECT id,story_title,user_story,acceptance_criteria,business_value, estimation, status FROM userstory";
        return template.query(sql,mapper);

    }

    @Override
    public UserStory getUserStoryByID(long id) {
        String sql = "SELECT id,story_title,user_story,acceptance_criteria,business_value, estimation, status FROM userstory WHERE id=? ";
        return template.queryForObject(sql,mapper,id);

    }

    @Override
    public void updateUserStory(UserStory userStory, long id) {
        String sql = "UPDATE userstory  SET story_title=?,user_story=?,acceptance_criteria=?,business_value=?, estimation=?, status=? WHERE id=?";
        template.update(sql,userStory.getStoryTitle(),userStory.getUserStory(),userStory.getAcceptanceCriteria(),userStory.getBusinessValue(),userStory.getEstimation(),userStory.getStatus(),id);

    }
}
