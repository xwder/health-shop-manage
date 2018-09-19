package com.cqust.portal.service;

import java.util.List;

import com.cqust.pojo.TStoreinfo;

public interface StoreService {
	List<TStoreinfo> storeinfosByStype(String stype);
}
