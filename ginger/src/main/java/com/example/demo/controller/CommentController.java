package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;

@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/create")
	public Comment create(@RequestParam String commentUserId, @RequestParam String comment) {
		Comment com = commentService.create(commentUserId, comment);
		return com;
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
	public String update(@RequestParam String commentId) {
		Comment com = commentService.update(commentId);
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
