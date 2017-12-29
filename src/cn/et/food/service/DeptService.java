package cn.et.food.service;

import java.util.List;

import cn.et.food.entity.TreeNode;

public interface DeptService {
	public List<TreeNode> queryTreeNode(Integer pid);
}
