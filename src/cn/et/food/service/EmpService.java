package cn.et.food.service;

import java.util.List;

import cn.et.food.entity.Emp;
import cn.et.food.util.PageTool;

public interface EmpService {
	public List<Emp> queryEmp(Integer eid);
	
	public PageTool queryEmpName(Integer eid,String ename,Integer page,Integer rows);
	
	public void saveEmp(Emp emp);
	
	public void deleteEmp(Integer eid);

	public void updateEmp(Emp emp);
}
