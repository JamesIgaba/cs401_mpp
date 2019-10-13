package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Like;
import com.example.demo.repository.LikeRepository;

public class LikeService {
	@Autowired
	private LikeRepository likeRepository;
	private Like likeobj;
	
			//create like
			public Like create(String likeUserId, boolean like) {
				return likeRepository.save(new Like(likeUserId, like));
			}

			//Retrieve operation
			public Like getPost(String likeId) {
				return likeRepository.findByLikeId(likeId);
			}
			
			public List<Like> getAll(){ //should return list of users
				return likeRepository.findAll();
			}
			
			//Unlike
			public void delete(String likeId) {
				likeobj = likeRepository.findByLikeId(likeId);
				likeRepository.delete(likeobj);
			}
			
			public void deleteAll() {
				likeRepository.deleteAll();
			}

			//Update operation 
			public Like update(boolean like) { 
				if(likeobj.isLike()==like) {
					likeobj.setLike(like);
				}
				return likeRepository.save(likeobj); 
			}
}
