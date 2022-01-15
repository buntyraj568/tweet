package com.example.tweetProject.tweetProjectController;

import com.example.tweetProject.tweetProjectModel.Like;
import com.example.tweetProject.tweetProjectModel.Tweet;
import com.example.tweetProject.tweetProjectService.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LikeController {

    @Autowired
    LikeService likeService;

    @PostMapping("/addLike")
    public ResponseEntity <Like> addLike( @RequestBody Like like) {
        return ResponseEntity.ok().body(this.likeService.postLike(like));
    }

    @GetMapping("/like/list")
    public ResponseEntity<List<Like>> getAllLike() {
        return ResponseEntity.ok().body(likeService.getAllLike());
    }

    @GetMapping("/like/{likeId}")
    public ResponseEntity<Like> getLikeById(@PathVariable long likeId){
        return ResponseEntity.ok().body(this.likeService.getLikeById(likeId));
    }

    @DeleteMapping("/like/{likeId}")
    public HttpStatus deleteLikeById(@PathVariable long likeId, Tweet tweet) {
        this.likeService.deleteLikeById(likeId);
        return HttpStatus.OK;
    }
}
