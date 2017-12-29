package cn.et.food.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.food.dao.EmpMapper;
import cn.et.food.entity.Emp;
import cn.et.food.entity.EmpExample;
import cn.et.food.service.EmpService;
import cn.et.food.util.PageTool;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpMapper em;

	public List<Emp> queryEmp(Integer eid) {
		EmpExample ee=new EmpExample();
		if(eid!=null){
			ee.createCriteria().andDidNotEqualTo(eid);
		}
		List<Emp> empList = em.selectByExample(ee);
		return empList;
	}

	public PageTool queryEmpName(Integer eid, String ename, Integer page, Integer rows) {
		EmpExample ee=new EmpExample();
		if(eid!=null){
			ee.createCriteria().andDidNotEqualTo(eid);
		}
		if(ename==null){
			ename="";
		}
		ee.createCriteria().andEnameLike("%" + ename + "%");
		int total = (int)em.countByExample(ee);
		PageTool pt = new PageTool(page, total, rows);
		RowBounds rb = new RowBounds(pt.getStartIndex() - 1, rows);
		List<Emp> empList = em.selectByExampleWithRowbounds(ee, rb);
		pt.setRows(empList);
		return pt;
	}

	public void saveEmp(Emp emp) {
		em.insert(emp);
	}

	public void deleteEmp(Integer eid) {
		em.deleteByPrimaryKey(eid);
		
	}

	public void updateEmp(Emp emp) {
		em.updateByPrimaryKey(emp);
		
	}

}
