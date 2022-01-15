package com.example.tweetProject.tweetProjectServiceImpl;

import java.util.List;
import java.util.Optional;

import com.example.tweetProject.tweetProjectException.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tweetProject.tweetProjectModel.Tweet;
import com.example.tweetProject.tweetProjectRepository.TweetRepository;
import com.example.tweetProject.tweetProjectService.TweetService;
@Service
public class TweetServiceImpl implements TweetService{
	@Autowired
	private TweetRepository repository;

	@Override
	public List<Tweet> getAllTweet() {
		return this.repository.findAll();
	}

	@Override
	public Tweet postTweet(Tweet  tweet) {
        return this.repository.save(tweet);
	}

	@Override
	public Tweet getTweetById(Long id) {
		Optional<Tweet> tweetDb = this.repository.findById(id);

		if (tweetDb.isPresent()) {
			return tweetDb.get();
		} else {
			throw new ResourceNotFoundException("Tweet not found :"+id);
		}
	}

	@Override
	public void deleteTweetById(Long id) {
		Optional<Tweet> tweetDb = this.repository.findById(id);
		if (tweetDb.isPresent()) {
			this.repository.delete(tweetDb.get());
		} else {
			throw new ResourceNotFoundException("Tweet not found :" + id);
		}
	}

	@Override
	public Tweet editTweet(Tweet tweet) {
		Optional<Tweet> tweetDb=this.repository.findById(tweet.getId());
		if(tweetDb.isPresent()) {
			Tweet updateTweet = tweetDb.get();
			updateTweet.setId(tweet.getId());
			updateTweet.setText(tweet.getText());
			updateTweet.setCreatedDate(tweet.getCreatedDate());
			updateTweet.setEditedDate(tweet.getEditedDate());
			repository.save(updateTweet);
			return updateTweet;
		}
		else {
			throw new ResourceNotFoundException("Tweet not found :"+tweet.getId());
		}
	}
}
