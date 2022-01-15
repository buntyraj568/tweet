package com.example.tweetProject.tweetProjectService;

import com.example.tweetProject.tweetProjectModel.Reply;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReplyService {
    List<Reply> getAllReply();
    Reply postReply(Reply reply);
    Reply getReplyById(Long id);
    void deleteReplyById(Long id);
    Reply editReply(Reply reply);

}
