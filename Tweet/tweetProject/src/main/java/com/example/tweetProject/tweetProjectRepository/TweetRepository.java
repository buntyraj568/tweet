package com.example.tweetProject.tweetProjectRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tweetProject.tweetProjectModel.Tweet;
@Repository
public interface TweetRepository extends JpaRepository<Tweet , Long> {

}
