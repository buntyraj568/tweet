package com.example.tweetProject.tweetProjectController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tweetProject.tweetProjectModel.Tweet;
import com.example.tweetProject.tweetProjectService.TweetService;

@RestController
@RequestMapping("/api")
public class TweetController {
	@Autowired
	TweetService service;

	@PostMapping("/postTweet")
	public ResponseEntity <Tweet> postTweet( @RequestBody Tweet tweet) {
		return ResponseEntity.ok().body(this.service.postTweet(tweet));
	}

	@GetMapping("/tweet/list")
	public ResponseEntity<List<Tweet>> getAllTweet() {
		return ResponseEntity.ok().body(service.getAllTweet());
	}

	@GetMapping("/tweet/{tweetId}")
	public  ResponseEntity<Tweet> getTweetById(@PathVariable long tweetId){
	 	return ResponseEntity.ok().body(this.service.getTweetById(tweetId));
	}

	@PutMapping("/tweet/{tweetId}")
	public ResponseEntity<Tweet> editTweet(@PathVariable long  tweetId,
										   @RequestBody Tweet tweet) {
	 	tweet.setId(tweetId);
		return ResponseEntity.ok().body(this.service.editTweet(tweet));
	}

	@DeleteMapping("/tweet/{tweetId}")
	public HttpStatus deleteTweetById(@PathVariable long tweetId, Tweet tweet) {
	 	this.service.deleteTweetById(tweetId);
		return HttpStatus.OK;
	}
}
