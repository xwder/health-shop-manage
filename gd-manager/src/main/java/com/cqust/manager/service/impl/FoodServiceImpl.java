package com.cqust.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.manager.mapper.FoodMapper;
import com.cqust.manager.service.FoodService;
import com.cqust.mapper.TFoodMapper;
import com.cqust.mapper.TFoodnutritionMapper;
import com.cqust.mapper.TMaterialMapper;
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
	@Autowired
	FoodMapper foodMapper;
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
	 * 根据食材类别获取某一类食物
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
	 * 根据食物id获取某一种食物
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
	/**
	 * 根据id删除某一种食物
	 */
	@Override
	public GdResult delFood(Integer id) {		
		try{
			TFoodnutritionExample example = new TFoodnutritionExample();
			com.cqust.pojo.TFoodnutritionExample.Criteria criteria = example.createCriteria();
			criteria.andFoodidEqualTo(id);
			if(tFoodMapper.deleteByPrimaryKey(id)==1&&tFoodnutritionMapper.deleteByExample(example)==1)
				return GdResult.build(200, "删除成功!",null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return GdResult.build(400, "删除失败!",null);
	}
	/**
	 * 根据id修改某一种食物
	 */
	@Override
	public GdResult modifyFood(TFood food) {		
		try{
			if(tFoodMapper.updateByPrimaryKeySelective(food)==1)
				return GdResult.build(200, "修改成功!",null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return GdResult.build(400, "修改失败!",null);		
	}
	/**
	 * 根据id修改某一种食物的营养成分
	 */
	@Override
	public GdResult modifyFoodnutrition(TFoodnutrition foodnutrition) {
		try{
			if(tFoodnutritionMapper.updateByPrimaryKeySelective(foodnutrition)==1)
				return GdResult.build(200, "修改成功!",null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return GdResult.build(400, "修改失败!",null);	
	}	
	@Override
	public GdResult addFood(TFood food) {
		try{
			if(tFoodMapper.insertSelective(food)==1)
				return GdResult.build(200, "添加成功!",null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return GdResult.build(400, "添加失败!",null);	
	}
	@Override
	public GdResult addFoodnutrition(TFoodnutrition foodnutrition) {
		try{
			if(tFoodnutritionMapper.insertSelective(foodnutrition)==1)
				return GdResult.build(200, "添加成功!",null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return GdResult.build(400, "添加失败!",null);	
	}
	@Override
	public TFood geTFood() {
		return foodMapper.geTFood();
	}		
}
