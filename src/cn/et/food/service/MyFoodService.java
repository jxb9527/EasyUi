package cn.et.food.service;

import cn.et.food.entity.Myfood;
import cn.et.food.util.PageTool;

public interface MyFoodService {
	public PageTool queryFood(String foodName,Integer page,Integer rows);
	
	public void deleteFood(Integer foodid);
	
	public void updateFood(Myfood mf);
	
	public void saveFood(Myfood mf);
		
}
