package com.cqust.mshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.pojo.ItemCollocationUtil;
import com.cqust.commom.pojo.ItemType;
import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.mapper.TCategoryMapper;
import com.cqust.mapper.TItemcollocationMapper;
import com.cqust.mapper.TProductMapper;
import com.cqust.mshop.dao.JedisClient;
import com.cqust.mshop.mapper.CustomPbrowseRecordMapper;
import com.cqust.mshop.mapper.CustomProductMapper;
import com.cqust.mshop.pojo.CustomPbrowseRecord;
import com.cqust.mshop.service.ItemService;
import com.cqust.pojo.TCategory;
import com.cqust.pojo.TCategoryExample;
import com.cqust.pojo.TItemcollocation;
import com.cqust.pojo.TItemcollocationExample;
import com.cqust.pojo.TProduct;
import com.cqust.pojo.TProductExample;
import com.cqust.pojo.TProductExample.Criteria;
import com.cqust.pojo.TStoreinfo;
import com.cqust.pojo.TUserinfo;

@Service
public class ItemServiceImpl implements ItemService {

	@Value("${REDIS_ITEM_KEY}")
	private String REDIS_ITEM_KEY;
	@Value("${REDIS_ITEM_EXPIRE}")
	private Integer REDIS_ITEM_EXPIRE;
	@Value("${REDIS_ITEMCOLLOCATION_KEY}")
	private String REDIS_ITEMCOLLOCATION_KEY;
	@Value("${REDIS_ITEMCOLLOCATION_EXPIRE}")
	private Integer REDIS_ITEMCOLLOCATION_EXPIRE;

	@Autowired
	private JedisClient jedisClient;

	@Autowired
	private TProductMapper productMapper;

	@Autowired
	private TCategoryMapper categoryMapper;

	@Autowired
	private TItemcollocationMapper itemcollocationMapper;

	@Autowired
	private CustomProductMapper customProductMapper;

	@Autowired
	private CustomPbrowseRecordMapper customPbrowseRecordMapper;

	@Override
	public List<TProduct> getAllItem(Integer sid) {
		TProductExample example = new TProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andStoreidEqualTo(sid);
		List<TProduct> list = productMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<TProduct> getItemByItemType(Integer itemType, Integer sid, HttpServletRequest request) {

		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("user");
		TStoreinfo storeinfo = (TStoreinfo) request.getSession().getAttribute("storeinfo");
		if (userinfo == null)
			return null;
		TProductExample example = new TProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andStoreidEqualTo(storeinfo.getId());
		if (itemType == 1) {
			criteria.andPtypeEqualTo(ItemType.VEGETABLES);
		}
		if (itemType == 2) {
			criteria.andPtypeEqualTo(ItemType.FRUITS);
		}
		if (itemType == 3) {
			criteria.andPtypeEqualTo(ItemType.MEAT);
		}
		if (itemType == 4) {
			criteria.andPtypeEqualTo(ItemType.COOKERFOOD);
		}
		if (itemType == 5) {
			criteria.andPtypeEqualTo(ItemType.GRAIN);
		}

		List<TProduct> list = productMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list;
		}

		return null;
	}

	@Override
	public Integer productSell(Integer productid, Integer type) {

		TProduct product = new TProduct();
		product.setId(productid);
		product.setIsSell(type);
		int r = productMapper.updateByPrimaryKeySelective(product);
		return r;
	}

	@Override
	public Integer addProduct(TProduct product) {
		Integer result = customProductMapper.addProduct(product);
		return result;
	}

	@Override
	public List<TCategory> productCategoryList() {
		TCategoryExample example = new TCategoryExample();
		List<TCategory> list = categoryMapper.selectByExample(example);
		return list;
	}

	@Override
	public Integer addProductCollocation(TItemcollocation itemcollocation) {
		return itemcollocationMapper.insert(itemcollocation);
	}

	@Override
	public Integer updateProductCollocation(TItemcollocation itemcollocation) {
		return itemcollocationMapper.updateByPrimaryKeySelective(itemcollocation);
	}

	@Override
	public Integer deleteProductCollolcationByPid(Integer pid) {
		TItemcollocationExample example = new TItemcollocationExample();
		com.cqust.pojo.TItemcollocationExample.Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		return itemcollocationMapper.deleteByExample(example);
	}

	@Override
	public TItemcollocation itemcollocationByPid(Integer pid) {
		TItemcollocationExample example = new TItemcollocationExample();
		com.cqust.pojo.TItemcollocationExample.Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		List<TItemcollocation> list = itemcollocationMapper.selectByExample(example);
		if (list != null & list.size() > 0)
			return list.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TProduct> getItemCollocations(Integer itemId) {

		try {
			// 添加缓存逻辑
			// 从缓存中取商品推荐信息，商品id对应的信息
			String json = jedisClient.get(REDIS_ITEMCOLLOCATION_KEY + ":" + itemId + ":base");
			// 判断是否有值
			if (!StringUtils.isBlank(json)) {
				// 把json转换成java对象
				GdResult gdResult = JsonUtils.jsonToPojo(json, GdResult.class);
				return (List<TProduct>) gdResult.getData();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 根据商品id查询商品推荐信息
		TItemcollocationExample example = new TItemcollocationExample();
		com.cqust.pojo.TItemcollocationExample.Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(itemId);
		List<TItemcollocation> list = itemcollocationMapper.selectByExample(example);
		if (list.size() > 0 & list != null) {
			TItemcollocation itemcollocation = list.get(0);
			ItemCollocationUtil itemCollocationUtil = JsonUtils.jsonToPojo(itemcollocation.getCollocation(),
					ItemCollocationUtil.class);
			List<TProduct> itemList = new ArrayList<>();
			if (itemCollocationUtil != null && itemCollocationUtil.getList().size() > 0) {
				for (int i = 0; i < itemCollocationUtil.getList().size(); i++) {
					TProduct product = new TProduct();
					product = productMapper.selectByPrimaryKey(itemCollocationUtil.getList().get(i));
					itemList.add(product);
				}
			}
			try {
				// 把商品信息写入缓存
				jedisClient.set(REDIS_ITEMCOLLOCATION_KEY + ":" + itemId + ":base",
						JsonUtils.objectToJson(GdResult.ok(itemList)));
				// 设置key的有效期
				jedisClient.expire(REDIS_ITEMCOLLOCATION_EXPIRE + ":" + itemId + ":base", REDIS_ITEMCOLLOCATION_EXPIRE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return itemList;
		}
		return null;
	}

	@Override
	public TProduct getProductByPid(Integer pid) {
		try {
			// 添加缓存逻辑
			// 从缓存中取商品信息，商品id对应的信息
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" + pid + ":base");
			// 判断是否有值
			if (!StringUtils.isBlank(json)) {
				// 把json转换成java对象
				TProduct item = JsonUtils.jsonToPojo(json, TProduct.class);
				return item;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 根据商品id查询商品信息
		TProduct item = productMapper.selectByPrimaryKey(pid);
		try {
			// 把商品信息写入缓存
			jedisClient.set(REDIS_ITEM_KEY + ":" + pid + ":base", JsonUtils.objectToJson(item));
			// 设置key的有效期
			jedisClient.expire(REDIS_ITEM_KEY + ":" + pid + ":base", REDIS_ITEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return item;
	}

	@Override
	public Integer updateProduct(TProduct product) {
		Integer r = productMapper.updateByPrimaryKeySelective(product);
		try {
			// 设置key的有效期 立即过期
			jedisClient.expire(REDIS_ITEM_KEY + ":" + product.getId() + ":base", 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public TItemcollocation getItemcollocationByPid(Integer pid) {

		// 根据商品id查询商品推荐信息
		TItemcollocationExample example = new TItemcollocationExample();
		com.cqust.pojo.TItemcollocationExample.Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		List<TItemcollocation> list = itemcollocationMapper.selectByExample(example);
		if (list != null & list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Integer updateItemCollocationByPid(TItemcollocation itemcollocation) {
		TItemcollocationExample example = new TItemcollocationExample();
		com.cqust.pojo.TItemcollocationExample.Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(itemcollocation.getPid());
		Integer r = itemcollocationMapper.updateByExampleSelective(itemcollocation, example);
		try {
			// 设置key的有效期
			jedisClient.expire(REDIS_ITEMCOLLOCATION_EXPIRE + ":" + itemcollocation.getId() + ":base", 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<TProduct> getItemListByStatus(Integer status,Integer sid) {
		TProductExample example = new TProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsSellEqualTo(status);
		criteria.andStoreidEqualTo(sid);
		return productMapper.selectByExample(example);
	}

	@Override
	public List<CustomPbrowseRecord> geTPbrowserecords(Integer sid) {

		List<CustomPbrowseRecord> list = customPbrowseRecordMapper.getPbrowseRecordList(sid);
		return list;
	}

}
