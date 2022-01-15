package com.example.tweetProject.tweetProjectService;


import com.example.tweetProject.tweetProjectModel.Like;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikeService {
    List<Like> getAllLike();
    Like postLike(Like like);
    Like getLikeById(Long id);
    void deleteLikeById(Long id);
}
