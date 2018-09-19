package com.cqust.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.mapper.TPictureMapper;
import com.cqust.pojo.TPicture;
import com.cqust.pojo.TPictureExample;
import com.cqust.pojo.TPictureExample.Criteria;
import com.cqust.rest.dao.JedisClient;
import com.cqust.rest.service.CarouselService;
import com.cqust.rest.utils.Carouse;

@Service
public class CarouseServiceImpl implements CarouselService {

	@Autowired
	private TPictureMapper tPictureMapper;

	
	/** 
	* @Fields INDEX_ZIXUNCAROUSE_REDIS_KEY : 资讯轮播的地址
	*/ 
	@Value("${INDEX_ZIXUNCAROUSE_REDIS_KEY}")
	private String INDEX_ZIXUNCAROUSE_REDIS_KEY;

	/** 
	* @Fields INDEX_SPCAROUSE_REDIS_KEY :商品轮播的地址
	*/ 
	@Value("${INDEX_SPCAROUSE_REDIS_KEY}")
	private String INDEX_SPCAROUSE_REDIS_KEY;

	/** 
	* @Fields REDIS_CAROUSE_EXPIRE : 轮播的存储时间
	*/ 
	@Value("${REDIS_CAROUSE_EXPIRE}")
	private Integer REDIS_CAROUSE_EXPIRE;

	@Autowired
	private JedisClient jedisClient;

	/**  
	* <p>Title: getCarouseList</p> 
	* <p>Description: 获取轮播列表</p> 
	* @param carouseType	轮播图类型
	* @return 轮播图列表
	* @see com.cqust.rest.service.CarouselService#getCarouseList(java.lang.String) 
	*/
	@Override
	public List<TPicture> getCarouseList(String carouseType) {

		String url = "";
		if (carouseType.equals(Carouse.ZIXUN)) {
			url = INDEX_ZIXUNCAROUSE_REDIS_KEY;
		}
		if (carouseType.equals(Carouse.SHANGPING)) {
			url = INDEX_SPCAROUSE_REDIS_KEY;
		}

		// 添加缓存逻辑
		try {
			// 从缓存中取轮播图信息 
			String json = jedisClient.get(url);
			// 判断是否有值
			if (!StringUtils.isBlank(json)) {
				// 把json转换成java对象
				GdResult gdResult = GdResult.formatToList(json, TPicture.class);
				if (gdResult.getStatus() == 200) {
					@SuppressWarnings("unchecked")
					List<TPicture> tPictureList = (List<TPicture>) gdResult.getData();
					return tPictureList;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 缓存数据库没有则查询数据库
		TPictureExample example = new TPictureExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(carouseType);

		// 执行查询
		List<TPicture> list = tPictureMapper.selectByExample(example);

		try {
			// 把轮播信息写入缓存
			jedisClient.set(url, JsonUtils.objectToJson(GdResult.ok(list)));
			// 设置key的有效期
			jedisClient.expire(url, REDIS_CAROUSE_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
