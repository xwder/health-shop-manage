package com.cqust.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.pojo.PageBean;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.mapper.TZxinfoMapper;
import com.cqust.mapper.TZxtypeMapper;
import com.cqust.pojo.TZxinfo;
import com.cqust.pojo.TZxtype;
import com.cqust.rest.dao.JedisClient;
import com.cqust.rest.mapper.CustomZiXunMapper;
import com.cqust.rest.pojo.ZiXunInfo;
import com.cqust.rest.service.ZiXunService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ZiXunServiceImpl implements ZiXunService {

	@Autowired
	private JedisClient jedisClient;

	@Value("${ZIXUN_TYPE_LIST_KEY}")
	private String ZIXUN_TYPE_LIST_KEY;

	@Value("${REDIS_ZIXUNTYPE_EXPIRE}")
	private int REDIS_ZIXUNTYPE_EXPIRE;

	@Value("${ZIXUN_INFO_KEY}")
	private String ZIXUN_INFO_KEY;

	@Value("${REDIS_ZIXUN_EXPIRE}")
	private int REDIS_ZIXUN_EXPIRE;

	@Autowired
	public TZxtypeMapper zxTypeMapper;

	@Autowired
	public CustomZiXunMapper customZiXunMapper;

	@Autowired
	public TZxinfoMapper zxInfoMapper;

	@Override
	public List<TZxtype> zxTypeList() {
		try {
			// 添加缓存逻辑
			// 从缓存中信息
			String json = jedisClient.get(ZIXUN_TYPE_LIST_KEY);
			// 判断是否有值
			if (!StringUtils.isBlank(json)) {
				// 把json转换成java对象
				List<TZxtype> zxtypeList = JsonUtils.jsonToList(json, TZxtype.class);
				return zxtypeList;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		List<TZxtype> list = customZiXunMapper.zxtypeList();
		if (list != null & list.size() > 0) {
			try {
				// 把商品信息写入缓存
				jedisClient.set(ZIXUN_TYPE_LIST_KEY, JsonUtils.objectToJson(list));
				// 设置key的有效期
				jedisClient.expire(ZIXUN_TYPE_LIST_KEY, REDIS_ZIXUNTYPE_EXPIRE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		return list;
	}
	@Override
	public PageBean<ZiXunInfo> zxinfoListByType(Integer page, Integer pagesize,Integer zxtype) {
		List<ZiXunInfo> list = null;
		if (page == null)
			page = 1;
		if (pagesize == null)
			pagesize = 10;		
		PageHelper.startPage(page, pagesize);
		if(zxtype == null)
			list = customZiXunMapper.getzixuninfo();
		else
			list = customZiXunMapper.getzixuninfobytype(zxtype);		
		PageBean<ZiXunInfo> pageBean = new PageBean<>();
		pageBean.setPageNum(page);
		pageBean.setList(list);
		PageInfo<ZiXunInfo> pageInfo = new PageInfo<>(list);
		pageBean.setTotal(pageInfo.getTotal());
		pageBean.setPageSize(pagesize);
		Integer t = (int) pageInfo.getTotal();
		if (t % (Integer) pagesize == 0) {
			pageBean.setPages(t / pagesize);
		} else {
			pageBean.setPages(t / pagesize + 1);
		}
		pageBean.setSize(0);
		if (list != null & list.size() > 0) {
			pageBean.setSize(list.size());
		}
		return pageBean;
	}

	@Override
	public PageBean<ZiXunInfo> zxinfosByType(Integer page, Integer pagesize,Integer zxtype) {
		if (page == null)
			page = 1;
		if (pagesize == null)
			pagesize = 10;		
		PageHelper.startPage(page, pagesize);
		List<ZiXunInfo> list = customZiXunMapper.getzixuninfos(zxtype);
		PageBean<ZiXunInfo> pageBean = new PageBean<>();
		pageBean.setPageNum(page);
		pageBean.setList(list);
		PageInfo<ZiXunInfo> pageInfo = new PageInfo<>(list);
		pageBean.setTotal(pageInfo.getTotal());
		pageBean.setPageSize(pagesize);
		Integer t = (int) pageInfo.getTotal();
		if (t % (Integer) pagesize == 0) {
			pageBean.setPages(t / pagesize);
		} else {
			pageBean.setPages(t / pagesize + 1);
		}
		pageBean.setSize(0);
		if (list != null & list.size() > 0) {
			pageBean.setSize(list.size());
		}
		return pageBean;
	}

	@Override
	public ZiXunInfo getZxinfoById(Integer zxid) {
		try {
			// 添加缓存逻辑
			String json = jedisClient.get(ZIXUN_INFO_KEY + ":" + zxid);
			// 判断是否有值
			if (!StringUtils.isBlank(json)) {
				// 把json转换成java对象
				ZiXunInfo tZxinfo = JsonUtils.jsonToPojo(json, ZiXunInfo.class);
				return tZxinfo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ZiXunInfo zxinfo = customZiXunMapper.getzixuninfobyid(zxid);
		if (zxinfo != null) {
			try {
				// 把信息写入缓存
				jedisClient.set(ZIXUN_INFO_KEY + ":" + zxid, JsonUtils.objectToJson(zxinfo));
				// 设置key的有效期
				jedisClient.expire(ZIXUN_INFO_KEY + ":" + zxid, REDIS_ZIXUN_EXPIRE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return zxinfo;
	}

	@Override
	public Integer addZxinfo(TZxinfo zxinfo) {

		try {
			return zxInfoMapper.insert(zxinfo);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer updateZiInfoById(TZxinfo zxinfo) {
		try {
			// 设置key的有效期
			jedisClient.expire(ZIXUN_INFO_KEY + ":" + zxinfo.getId(), 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			return zxInfoMapper.updateByPrimaryKeySelective(zxinfo);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer delZiInfoById(Integer zxid) {
		try {
			// 设置key的有效期
			jedisClient.expire(ZIXUN_INFO_KEY + ":" + zxid, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			return zxInfoMapper.deleteByPrimaryKey(zxid);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
