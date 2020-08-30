package com.jiaming.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaming.entity.Category;
import com.jiaming.mapper.CategoryMapper;

@Service
public class CategoryService {

	@Autowired
	public CategoryMapper categoryMapper;
	
	public List<Category> showAllCategorys(){
		return categoryMapper.selectAll();
	}
}
