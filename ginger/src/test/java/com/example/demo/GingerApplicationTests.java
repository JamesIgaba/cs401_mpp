package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.UserPost;
import com.example.demo.repository.UserPostRepository;
import com.example.demo.service.UserPostService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GingerApplicationTests {

	@Autowired
	private UserPostService service;
	
	@MockBean
	private UserPostRepository repository;
	
//	@Test
//	public void createPostTest() {
//		UserPost post = new UserPost("jigaba@ginger.com", "I probably should have done this earlier.");
//		when(repository.save(post)).thenReturn(post);
//		assertEquals(post, service.create(post));
//	}
//	
//	@Test
//	public void getAllPostsTest() {
//		when(repository.findAll()).thenReturn(Stream
//				.of(new UserPost("jigaba@ginger.com","mpp is gonna be great!"), 
//						new UserPost("jkatunguka@ginger.com","All will be well as long as you put in the work.!"))
//				.collect(Collectors.toList()));
//		assertEquals(2,service.getAllPosts().size());
//	}
}
