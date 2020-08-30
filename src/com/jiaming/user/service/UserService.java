package com.jiaming.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaming.entity.User;
import com.jiaming.mapper.UserMapper;
import com.jiaming.povos.RegistMsgPovo;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	

	public  RegistMsgPovo  regist(User user){
		
		List<User>  list= 
				userMapper.selectUserByEmailOrTel(user);
		// 3�� ���      
		
		// Email �ظ��ˣ�  tel û�ظ�
		// Tel �ظ���    Emailû�ظ��� 
		RegistMsgPovo  povo  = new RegistMsgPovo();
		if(list.size()!=0) {
			povo.setRes(false);
			for (User u : list) {
				String  email =  u.getEmail();
				String  tel =  u.getTel(); 
				// Email  ��   tel  ���ظ��ˡ�
				if(email!=null) {
					//��� ������ĵ�����¼��Email  ��  ���ϵ�   Email ��ͬ
					if(email.equals(user.getEmail())) {
						povo.setEmail_status(false);
					}
				}
				if(tel!=null) {
					if(tel.equals(user.getTel())) {
						povo.setTel_status(false);
					}
				}
			}
			return  povo ; 	
		}
		
		String  username =  user.getEmail().substring(0, user.getEmail().indexOf("@"));
		user.setUsername(username);
		
		boolean insert_res = userMapper.insert(user);
		if(!insert_res) {
			povo.setInsert_status(false);
			povo.setRes(false);
			return  povo ; 
		}
		//suc  
		povo.setRes(true);
		return  povo ; 
	}
	
	public User login(User user) {
		return   userMapper.selectUserBySwitch(user);
	}
	
	
	
}
