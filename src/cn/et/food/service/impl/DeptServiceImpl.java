package cn.et.food.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.food.dao.DeptMapper;
import cn.et.food.entity.Dept;
import cn.et.food.entity.DeptExample;
import cn.et.food.entity.TreeNode;
import cn.et.food.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptMapper dm;

	public List<TreeNode> queryTreeNode(Integer pid) {
		if(pid==null){
			pid=0;
		}
		DeptExample de = new DeptExample();
		de.createCriteria().andPidEqualTo(pid);
		List<Dept> dept = dm.selectByExample(de);
		List<TreeNode> deptList = new ArrayList<TreeNode>();
		for (Dept d : dept) {
			TreeNode tn = new TreeNode();
			tn.setId(d.getDid());
			tn.setText(d.getDname());
			//判断当前节点下是否存在字节点
			if(queryTreeNode(d.getDid()).size()==0){
				tn.setState("open");
			}
			deptList.add(tn);
		}
		return deptList;

	}
}
