package com.example.tweetProject.tweetProjectController;

import com.example.tweetProject.tweetProjectModel.Follower;
import com.example.tweetProject.tweetProjectModel.Like;
import com.example.tweetProject.tweetProjectModel.Reply;
import com.example.tweetProject.tweetProjectModel.Tweet;
import com.example.tweetProject.tweetProjectService.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FollowerController {

    @Autowired
    FollowerService followerService;

    @PostMapping("/addFollower")
    public  ResponseEntity <Follower> addFollower(@RequestBody Follower follower) {
        return ResponseEntity.ok().body(this.followerService.addFollower(follower));
    }

    @GetMapping("/follower/list")
    public ResponseEntity<List<Follower>> getAllFollower() {
        return ResponseEntity.ok().body(followerService.getAllFollower());
    }

    @GetMapping("/follower/{followerId}")
    public ResponseEntity<Follower> getFollowerById(@PathVariable long followerId){
        return ResponseEntity.ok().body(this.followerService.getFollowerById(followerId));
    }

    @DeleteMapping("/follower/{followerId}")
    public HttpStatus deleteFollower(@PathVariable long followerId, Follower follower) {
        this.followerService.removeFollowerById(followerId);
        return HttpStatus.OK;
    }
}
