package cn.et.food.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.food.dao.MyfoodMapper;
import cn.et.food.entity.Myfood;
import cn.et.food.entity.MyfoodExample;
import cn.et.food.service.MyFoodService;
import cn.et.food.util.PageTool;

@Service
public class MyFoodServiceImpl implements MyFoodService {
	@Autowired
	MyfoodMapper mm;

	public PageTool queryFood(String foodName, Integer page, Integer rows) {
		if (foodName == null) {
			foodName = "";
		}
		
		MyfoodExample me = new MyfoodExample();
		me.createCriteria().andFoodnameLike("%" + foodName + "%");
		int total = queryMyfoodCount(me);
		PageTool pt = new PageTool(page, total, rows);
		RowBounds rb = new RowBounds(pt.getStartIndex() - 1, rows);
		List<Myfood> myFoodList = mm.selectByExampleWithRowbounds(me, rb);
		pt.setRows(myFoodList);
		return pt;
	}

	public int queryMyfoodCount(MyfoodExample me) {
		int total = (int) mm.countByExample(me);
		return total;
	}

	public void deleteFood(Integer foodId) {
		mm.deleteByPrimaryKey(foodId);
	}

	public void updateFood(Myfood mf) {
		mm.updateByPrimaryKey(mf);

	}

	public void saveFood(Myfood mf) {
		mm.insertSelective(mf);

	}

}
