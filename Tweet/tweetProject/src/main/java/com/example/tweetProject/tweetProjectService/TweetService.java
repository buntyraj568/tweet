package com.example.tweetProject.tweetProjectService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tweetProject.tweetProjectModel.Tweet;

@Service
public interface TweetService {
	List<Tweet> getAllTweet();
	Tweet postTweet(Tweet tweet);
	Tweet getTweetById(Long id);
	void deleteTweetById(Long id);
	Tweet editTweet(Tweet tweet);
}
