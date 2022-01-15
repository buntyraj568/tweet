package com.example.tweetProject.tweetProjectController;

import com.example.tweetProject.tweetProjectModel.Reply;
import com.example.tweetProject.tweetProjectModel.Tweet;
import com.example.tweetProject.tweetProjectService.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reply")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @PostMapping("/postReply")
    public ResponseEntity <Reply> postReply( @RequestBody Reply reply) {
        return ResponseEntity.ok().body(this.replyService.postReply(reply));
    }

    @GetMapping("/reply/list")
    public ResponseEntity<List<Reply>> getAllReply() {
        return ResponseEntity.ok().body(replyService.getAllReply());
    }

    @GetMapping("/reply/{replyId}")
    public  ResponseEntity<Reply> getReplyById(@PathVariable long replyId){
        return ResponseEntity.ok().body(this.replyService.getReplyById(replyId));
    }

    @PutMapping("/reply/{replyId}")
    public ResponseEntity<Reply> editReply(@PathVariable long  replyId,
                                           @RequestBody Reply reply) {
        reply.setId(replyId);
        return ResponseEntity.ok().body(this.replyService.editReply(reply));
    }

    @DeleteMapping("/reply/{replyId}")
    public HttpStatus deleteReplyById(@PathVariable long replyId, Reply reply) {
        this.replyService.deleteReplyById(replyId);
        return HttpStatus.OK;
    }
}
