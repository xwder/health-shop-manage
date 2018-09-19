package com.cqust.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.mapper.TFoodMapper;
import com.cqust.mapper.TFoodnutritionMapper;
import com.cqust.mapper.TMaterialMapper;
import com.cqust.user.service.FoodService;
import com.cqust.pojo.TFood;
import com.cqust.pojo.TFoodExample;
import com.cqust.pojo.TFoodnutrition;
import com.cqust.pojo.TFoodnutritionExample;
import com.cqust.pojo.TMaterial;
import com.cqust.pojo.TMaterialExample;
import com.cqust.pojo.TMaterialExample.Criteria;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	TMaterialMapper tMaterialMapper;
	@Autowired
	TFoodMapper tFoodMapper;
	@Autowired
	TFoodnutritionMapper tFoodnutritionMapper;
	/**
	 * 获取食材分类
	 */
	@Override
	public GdResult getMaterial() {
		// TODO Auto-generated method stub
		TMaterialExample example = new TMaterialExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		try {
			List<TMaterial> tMaterials = tMaterialMapper.selectByExample(example);
			if (tMaterials != null) {
                return GdResult.build(200, "获取数据成功!",tMaterials);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return GdResult.build(400,"无法获取数据!");
	}
	/**
	 * 根据食材类别获取每一类食物
	 */
	@Override
	public GdResult getFoods(Integer id) {
		// TODO Auto-generated method stub
		TFoodExample example = new TFoodExample();
		com.cqust.pojo.TFoodExample.Criteria criteria = example.createCriteria();
		criteria.andMaterialidEqualTo(id);				
		try{
			List<TFood> tFoods = tFoodMapper.selectByExample(example);
			if(tFoods!=null)
				return GdResult.build(200, "获取数据成功!",tFoods);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return GdResult.build(400, "无法获取数据!");
	}
	/**
	 * 根据食物id获取每一种食物
	 */
	@Override
	public GdResult getFood(Integer id) {
		// TODO Auto-generated method stub
		try{
		TFood tFood = tFoodMapper.selectByPrimaryKey(id);
		if(tFood!=null)
			return GdResult.build(200, "获取数据成功!",tFood);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return GdResult.build(400, "无法获取数据!");
	}
	/**
	 * 根据id获取某一种食物的营养成分
	 */
	@Override
	public GdResult getFoodnutrition(Integer id) {
		try {
			TFoodnutritionExample example = new TFoodnutritionExample();
			com.cqust.pojo.TFoodnutritionExample.Criteria criteria = example.createCriteria();
			criteria.andFoodidEqualTo(id);
			List<TFoodnutrition> tFoodnutritions = tFoodnutritionMapper.selectByExample(example);
			return GdResult.build(200,"",tFoodnutritions);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return GdResult.build(400, "",null);
	}
	/**
	 * 获取全部食物
	 */
	@Override
	public GdResult getAllFood() {
		// TODO Auto-generated method stub
		try{
			TFoodExample example = new TFoodExample();
			List<TFood> tFoods = tFoodMapper.selectByExample(example);
			if(tFoods!=null)
				return GdResult.build(200, "获取数据成功!",tFoods);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return GdResult.build(400, "无法获取数据!");
	}
		
}
