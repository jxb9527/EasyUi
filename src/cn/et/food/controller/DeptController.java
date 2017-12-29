package cn.et.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.food.entity.TreeNode;
import cn.et.food.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	DeptService ds;
	
	@ResponseBody
	@RequestMapping(value="/queryDept",method={RequestMethod.GET})
	public List<TreeNode> queryDept(Integer id){
		List<TreeNode> queryTreeNode = ds.queryTreeNode(id);
		return queryTreeNode;
	}
}
