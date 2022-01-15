package com.example.tweetProject.tweetProjectRepository;

import com.example.tweetProject.tweetProjectModel.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
