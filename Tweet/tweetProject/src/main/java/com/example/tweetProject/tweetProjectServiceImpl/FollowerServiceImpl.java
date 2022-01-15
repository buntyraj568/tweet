package com.example.tweetProject.tweetProjectServiceImpl;

import com.example.tweetProject.tweetProjectException.ResourceNotFoundException;
import com.example.tweetProject.tweetProjectModel.Follower;
import com.example.tweetProject.tweetProjectModel.Tweet;
import com.example.tweetProject.tweetProjectRepository.FollowerRepository;
import com.example.tweetProject.tweetProjectService.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowerServiceImpl implements FollowerService {

    @Autowired
    FollowerRepository followerRepository;

    @Override
    public List<Follower> getAllFollower() {
        return this.followerRepository.findAll();
    }

    @Override
    public Follower addFollower(Follower follower) {
        return this.followerRepository.save(follower);
    }

    @Override
    public Follower getFollowerById(Long id) {
        Optional<Follower> followerDb = this.followerRepository.findById(id);
        if (followerDb.isPresent()) {
            return followerDb.get();
        } else {
            throw new ResourceNotFoundException("Follower not found :" + id);
        }
    }

    @Override
    public void removeFollowerById(Long id) {
        Optional<Follower> followerDb = this.followerRepository.findById(id);
        if (followerDb.isPresent()) {
            this.followerRepository.delete(followerDb.get());
        } else {
            throw new ResourceNotFoundException("Follower not found :" + id);
        }
    }
}
