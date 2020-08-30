package com.jiaming.star.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaming.entity.Star;
import com.jiaming.mapper.StarMapper;
import com.jiaming.povos.StarFruitPovo;

@Service
public class StarService {

	@Autowired
	private StarMapper starMapper;
	
	public void addStar(Star star) {
		
		starMapper.insert(star);
	}
	

	public List<StarFruitPovo> getStarsByUid(String uid) {
		// TODO Auto-generated method stub
		
		return starMapper.selectStarFruitPovosByUid(uid);
	}

	public void removeStarBySid(String sid) {
		// TODO Auto-generated method stub

		starMapper.deleteByPrimaryKey(sid);
	}

	public Star selectStarByUidAndFid(String uid, String fid) {
		// TODO Auto-generated method stub
		return starMapper.selectStarByUidAndFid(uid,fid);
	}


	public boolean changeStarBySidForScount(String sid,int value) {
		// TODO Auto-generated method stub
		return starMapper.updateStarBySidForScount(sid,value);
	}

	
}
