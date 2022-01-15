package com.example.tweetProject.tweetProjectServiceImpl;

import com.example.tweetProject.tweetProjectException.ResourceNotFoundException;
import com.example.tweetProject.tweetProjectModel.Like;
import com.example.tweetProject.tweetProjectModel.Tweet;
import com.example.tweetProject.tweetProjectRepository.LikeRepository;
import com.example.tweetProject.tweetProjectService.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;

    @Override
    public List<Like> getAllLike() {
        return this.likeRepository.findAll();
    }

    @Override
    public Like postLike(Like like) {
        return this.likeRepository.save(like);
    }

    @Override
    public Like getLikeById(Long id) {
        Optional<Like> likeDb = this.likeRepository.findById(id);
        if (likeDb.isPresent()) {
            return likeDb.get();
        } else {
            throw new ResourceNotFoundException("Like not found :" + id);
        }
    }


    @Override
    public void deleteLikeById(Long id) {
        Optional<Like> likeDb = this.likeRepository.findById(id);
        if (likeDb.isPresent()) {
            this.likeRepository.delete(likeDb.get());
        } else {
            throw new ResourceNotFoundException("Tweet not found :" + id);
        }
    }
}
