package cn.et.food.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.et.food.entity.Myfood;
import cn.et.food.entity.Result;
import cn.et.food.service.MyFoodService;
import cn.et.food.util.PageTool;

@Controller
public class MyFoodController {
	@Autowired
	MyFoodService myfood;
	
	@ResponseBody
	@RequestMapping(value="/queryFood",method={RequestMethod.GET})
	public PageTool queryFoodReturnList(String foodname,Integer page,Integer rows){
		PageTool queryAllFood = myfood.queryFood(foodname, page, rows);
		return queryAllFood;
	}
	
	/**
	 * 删除food
	 * @param foodId 菜品id
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/food/{foodId}",method={RequestMethod.DELETE})
	public Result deleteFood(@PathVariable Integer foodId){
		Result r=new Result();
		r.setCode(1);
		try {
			 myfood.deleteFood(foodId);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
	
	/**
	 * 修改food
	 * @param foodId 菜品id
	 * @param foodName 菜品名
	 * @param price 菜品价格
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/food/{foodId}",method={RequestMethod.PUT})
	public Result udpateFood(@PathVariable Integer foodId,Myfood food){
		Result r=new Result();
		food.setFoodid(foodId);
		r.setCode(1);
		try {
			myfood.updateFood(food);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
	
	/**
	 * 新增菜品
	 * @param foodName 菜品名称
	 * @param price 价格
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/food",method={RequestMethod.POST})
	public Result saveFood(Myfood food,MultipartFile imagepath){
		Result r=new Result();
		r.setCode(1);
		try {
			//获取文件名
			String fileName = imagepath.getOriginalFilename();
			File destFile = new File("D:\\myImage\\"+fileName);
			imagepath.transferTo(destFile);
			myfood.saveFood(food);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
}
