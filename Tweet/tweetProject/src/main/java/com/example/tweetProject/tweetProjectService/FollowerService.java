package com.example.tweetProject.tweetProjectService;

import com.example.tweetProject.tweetProjectModel.Follower;
import com.example.tweetProject.tweetProjectModel.Like;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FollowerService {
    List<Follower> getAllFollower();
    Follower addFollower(Follower follower);
    Follower getFollowerById(Long id);
    void removeFollowerById(Long id);
}
