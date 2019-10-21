package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/create")
	public Comment create(@RequestBody Comment comment) {
		Comment com = commentService.create(comment.getCommentId(), comment.getComment(), comment.getPostId());
		return com;
	}
	@RequestMapping("/getByPostId")
	public List<Comment> getCommentByPostId(@RequestParam String postId){
		return commentService.getCommentByPostId(postId);
	}
	
	@RequestMapping("/counCommentsByPostId")
	public int countCommentByPostId(@RequestParam String postId){
		return commentService.countCommentByPostId(postId);
	}
	
	@RequestMapping("/get")
	public Comment getCommentById(@RequestParam String commentId){
		return commentService.getComment(commentId);
	}
	
	@RequestMapping("/getAll")
	public List<Comment> getAll(){
		return commentService.getAll();
	}
	
	@RequestMapping("/update")
	public String update(@RequestBody Comment comment) {
		Comment com = commentService.update(comment.getComment());
		return com.toString();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String commentId) {
		commentService.delete(commentId);
		return "Deleted ";
	}
	
	
	@RequestMapping("/deleteAll") 
	public String deleteAll() {
	  commentService.deleteAll(); 
	  return "Deleted all records!";
	  }
}
