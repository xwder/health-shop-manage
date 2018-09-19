package com.cqust.rest.service;

import java.util.List;

import com.cqust.pojo.TStoreinfo;

public interface StoreinfoService {

	List<TStoreinfo> storeinfosByStype(String stype);
}
