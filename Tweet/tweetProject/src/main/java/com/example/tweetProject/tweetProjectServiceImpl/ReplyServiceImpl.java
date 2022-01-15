package com.example.tweetProject.tweetProjectServiceImpl;

import com.example.tweetProject.tweetProjectException.ResourceNotFoundException;
import com.example.tweetProject.tweetProjectModel.Reply;
import com.example.tweetProject.tweetProjectModel.Tweet;
import com.example.tweetProject.tweetProjectRepository.ReplyRepository;
import com.example.tweetProject.tweetProjectService.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyRepository replyRepository;

    @Override
    public List<Reply> getAllReply() {
        return this.replyRepository.findAll();
    }

    @Override
    public Reply postReply(Reply reply) {
        return this.replyRepository.save(reply);
    }

    @Override
    public Reply getReplyById(Long id) {
        Optional<Reply> replyDb = this.replyRepository.findById(id);

        if (replyDb.isPresent()) {
            return replyDb.get();
        } else {
            throw new ResourceNotFoundException("Reply not found :" + id);
        }
    }

    @Override
    public void deleteReplyById(Long id) {
        Optional<Reply> replyDb = this.replyRepository.findById(id);
        if (replyDb.isPresent()) {
            this.replyRepository.delete(replyDb.get());
        } else {
            throw new ResourceNotFoundException("Reply not found :" + id);
        }
    }

    @Override
    public Reply editReply(Reply reply) {
        Optional<Reply> tweetDb=this.replyRepository.findById(reply.getId());
        if(tweetDb.isPresent()) {
            Reply updateReply = tweetDb.get();
            updateReply.setId(reply.getId());
            updateReply.setText(reply.getText());
            updateReply.setReplyId(reply.getReplyId());
            updateReply.setUserId(reply.getUserId());
            updateReply.setTweetId(reply.getTweetId());
            updateReply.setCreatedDate(reply.getCreatedDate());
            updateReply.setEditedDate(reply.getEditedDate());
            replyRepository.save(updateReply);
            return updateReply;
        }
        else {
            throw new ResourceNotFoundException("Reply not found :"+reply.getId());
        }
    }
}
