package com.example.progresstracker.mapper;

import com.example.progresstracker.model.UserStory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserStoryMapper implements RowMapper<UserStory> {
    @Override
    public UserStory mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserStory story = new UserStory();
        story.setId(rs.getInt("id"));
        story.setStoryTitle(rs.getString("story_title"));
        story.setUserStory(rs.getString("user_story"));
        story.setAcceptanceCriteria(rs.getString("acceptance_criteria"));
        story.setBusinessValue(rs.getDouble("business_value"));
        story.setEstimation(rs.getInt("estimation"));
        story.setStatus(rs.getString("status"));
        return story;
    }
}
