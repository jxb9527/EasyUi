package cn.et.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.food.entity.Emp;
import cn.et.food.entity.Result;
import cn.et.food.service.EmpService;
import cn.et.food.util.PageTool;

@Controller
public class EmpController {
	@Autowired
	EmpService es;
	
	/*@ResponseBody
	@RequestMapping(value="/queryEmp",method={RequestMethod.GET})
	public List<Emp> queryEmp1(Integer id,String ename,Integer page,Integer rows){
		return es.queryEmp(id);
	}*/
	
	
	@ResponseBody
	@RequestMapping(value="/queryEmp",method={RequestMethod.GET})
	public PageTool queryEmp(Integer id,String ename,Integer page,Integer rows){
		PageTool pt = es.queryEmpName(id, ename, page, rows);
		return pt;
	}
	
	@ResponseBody
	@RequestMapping(value="/emp",method={RequestMethod.POST})
	public Result saveEmp(Emp emp){
		Result r=new Result();
		r.setCode(1);
		try {
			es.saveEmp(emp);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
	
	@ResponseBody
	@RequestMapping(value="/emp/{eid}",method={RequestMethod.DELETE})
	public Result deleteFood(@PathVariable Integer eid){
		Result r=new Result();
		r.setCode(1);
		try {
			 es.deleteEmp(eid);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
	
	@ResponseBody
	@RequestMapping(value="/emp/{eid}",method={RequestMethod.PUT})
	public Result udpateFood(@PathVariable Integer eid,Emp emp){
		Result r=new Result();
		emp.setEid(eid);
		r.setCode(1);
		try {
			es.updateEmp(emp);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
}
