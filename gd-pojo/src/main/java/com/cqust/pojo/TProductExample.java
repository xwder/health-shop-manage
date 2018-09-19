package com.cqust.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TProductExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStoreidIsNull() {
            addCriterion("storeid is null");
            return (Criteria) this;
        }

        public Criteria andStoreidIsNotNull() {
            addCriterion("storeid is not null");
            return (Criteria) this;
        }

        public Criteria andStoreidEqualTo(Integer value) {
            addCriterion("storeid =", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotEqualTo(Integer value) {
            addCriterion("storeid <>", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThan(Integer value) {
            addCriterion("storeid >", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThanOrEqualTo(Integer value) {
            addCriterion("storeid >=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThan(Integer value) {
            addCriterion("storeid <", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThanOrEqualTo(Integer value) {
            addCriterion("storeid <=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidIn(List<Integer> values) {
            addCriterion("storeid in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotIn(List<Integer> values) {
            addCriterion("storeid not in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidBetween(Integer value1, Integer value2) {
            addCriterion("storeid between", value1, value2, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotBetween(Integer value1, Integer value2) {
            addCriterion("storeid not between", value1, value2, "storeid");
            return (Criteria) this;
        }

        public Criteria andPnameIsNull() {
            addCriterion("pName is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pName is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pName =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pName <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pName >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pName >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pName <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pName <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pName like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pName not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pName in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pName not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pName between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pName not between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPmsIsNull() {
            addCriterion("pms is null");
            return (Criteria) this;
        }

        public Criteria andPmsIsNotNull() {
            addCriterion("pms is not null");
            return (Criteria) this;
        }

        public Criteria andPmsEqualTo(String value) {
            addCriterion("pms =", value, "pms");
            return (Criteria) this;
        }

        public Criteria andPmsNotEqualTo(String value) {
            addCriterion("pms <>", value, "pms");
            return (Criteria) this;
        }

        public Criteria andPmsGreaterThan(String value) {
            addCriterion("pms >", value, "pms");
            return (Criteria) this;
        }

        public Criteria andPmsGreaterThanOrEqualTo(String value) {
            addCriterion("pms >=", value, "pms");
            return (Criteria) this;
        }

        public Criteria andPmsLessThan(String value) {
            addCriterion("pms <", value, "pms");
            return (Criteria) this;
        }

        public Criteria andPmsLessThanOrEqualTo(String value) {
            addCriterion("pms <=", value, "pms");
            return (Criteria) this;
        }

        public Criteria andPmsLike(String value) {
            addCriterion("pms like", value, "pms");
            return (Criteria) this;
        }

        public Criteria andPmsNotLike(String value) {
            addCriterion("pms not like", value, "pms");
            return (Criteria) this;
        }

        public Criteria andPmsIn(List<String> values) {
            addCriterion("pms in", values, "pms");
            return (Criteria) this;
        }

        public Criteria andPmsNotIn(List<String> values) {
            addCriterion("pms not in", values, "pms");
            return (Criteria) this;
        }

        public Criteria andPmsBetween(String value1, String value2) {
            addCriterion("pms between", value1, value2, "pms");
            return (Criteria) this;
        }

        public Criteria andPmsNotBetween(String value1, String value2) {
            addCriterion("pms not between", value1, value2, "pms");
            return (Criteria) this;
        }

        public Criteria andPpriceIsNull() {
            addCriterion("pPrice is null");
            return (Criteria) this;
        }

        public Criteria andPpriceIsNotNull() {
            addCriterion("pPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPpriceEqualTo(Double value) {
            addCriterion("pPrice =", value, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceNotEqualTo(Double value) {
            addCriterion("pPrice <>", value, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceGreaterThan(Double value) {
            addCriterion("pPrice >", value, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("pPrice >=", value, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceLessThan(Double value) {
            addCriterion("pPrice <", value, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceLessThanOrEqualTo(Double value) {
            addCriterion("pPrice <=", value, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceIn(List<Double> values) {
            addCriterion("pPrice in", values, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceNotIn(List<Double> values) {
            addCriterion("pPrice not in", values, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceBetween(Double value1, Double value2) {
            addCriterion("pPrice between", value1, value2, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceNotBetween(Double value1, Double value2) {
            addCriterion("pPrice not between", value1, value2, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpicIsNull() {
            addCriterion("pPic is null");
            return (Criteria) this;
        }

        public Criteria andPpicIsNotNull() {
            addCriterion("pPic is not null");
            return (Criteria) this;
        }

        public Criteria andPpicEqualTo(String value) {
            addCriterion("pPic =", value, "ppic");
            return (Criteria) this;
        }

        public Criteria andPpicNotEqualTo(String value) {
            addCriterion("pPic <>", value, "ppic");
            return (Criteria) this;
        }

        public Criteria andPpicGreaterThan(String value) {
            addCriterion("pPic >", value, "ppic");
            return (Criteria) this;
        }

        public Criteria andPpicGreaterThanOrEqualTo(String value) {
            addCriterion("pPic >=", value, "ppic");
            return (Criteria) this;
        }

        public Criteria andPpicLessThan(String value) {
            addCriterion("pPic <", value, "ppic");
            return (Criteria) this;
        }

        public Criteria andPpicLessThanOrEqualTo(String value) {
            addCriterion("pPic <=", value, "ppic");
            return (Criteria) this;
        }

        public Criteria andPpicLike(String value) {
            addCriterion("pPic like", value, "ppic");
            return (Criteria) this;
        }

        public Criteria andPpicNotLike(String value) {
            addCriterion("pPic not like", value, "ppic");
            return (Criteria) this;
        }

        public Criteria andPpicIn(List<String> values) {
            addCriterion("pPic in", values, "ppic");
            return (Criteria) this;
        }

        public Criteria andPpicNotIn(List<String> values) {
            addCriterion("pPic not in", values, "ppic");
            return (Criteria) this;
        }

        public Criteria andPpicBetween(String value1, String value2) {
            addCriterion("pPic between", value1, value2, "ppic");
            return (Criteria) this;
        }

        public Criteria andPpicNotBetween(String value1, String value2) {
            addCriterion("pPic not between", value1, value2, "ppic");
            return (Criteria) this;
        }

        public Criteria andPcreattimeIsNull() {
            addCriterion("pCreatTime is null");
            return (Criteria) this;
        }

        public Criteria andPcreattimeIsNotNull() {
            addCriterion("pCreatTime is not null");
            return (Criteria) this;
        }

        public Criteria andPcreattimeEqualTo(Date value) {
            addCriterion("pCreatTime =", value, "pcreattime");
            return (Criteria) this;
        }

        public Criteria andPcreattimeNotEqualTo(Date value) {
            addCriterion("pCreatTime <>", value, "pcreattime");
            return (Criteria) this;
        }

        public Criteria andPcreattimeGreaterThan(Date value) {
            addCriterion("pCreatTime >", value, "pcreattime");
            return (Criteria) this;
        }

        public Criteria andPcreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pCreatTime >=", value, "pcreattime");
            return (Criteria) this;
        }

        public Criteria andPcreattimeLessThan(Date value) {
            addCriterion("pCreatTime <", value, "pcreattime");
            return (Criteria) this;
        }

        public Criteria andPcreattimeLessThanOrEqualTo(Date value) {
            addCriterion("pCreatTime <=", value, "pcreattime");
            return (Criteria) this;
        }

        public Criteria andPcreattimeIn(List<Date> values) {
            addCriterion("pCreatTime in", values, "pcreattime");
            return (Criteria) this;
        }

        public Criteria andPcreattimeNotIn(List<Date> values) {
            addCriterion("pCreatTime not in", values, "pcreattime");
            return (Criteria) this;
        }

        public Criteria andPcreattimeBetween(Date value1, Date value2) {
            addCriterion("pCreatTime between", value1, value2, "pcreattime");
            return (Criteria) this;
        }

        public Criteria andPcreattimeNotBetween(Date value1, Date value2) {
            addCriterion("pCreatTime not between", value1, value2, "pcreattime");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNull() {
            addCriterion("is_hot is null");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNotNull() {
            addCriterion("is_hot is not null");
            return (Criteria) this;
        }

        public Criteria andIsHotEqualTo(Integer value) {
            addCriterion("is_hot =", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotEqualTo(Integer value) {
            addCriterion("is_hot <>", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThan(Integer value) {
            addCriterion("is_hot >", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_hot >=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThan(Integer value) {
            addCriterion("is_hot <", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThanOrEqualTo(Integer value) {
            addCriterion("is_hot <=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotIn(List<Integer> values) {
            addCriterion("is_hot in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotIn(List<Integer> values) {
            addCriterion("is_hot not in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotBetween(Integer value1, Integer value2) {
            addCriterion("is_hot between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotBetween(Integer value1, Integer value2) {
            addCriterion("is_hot not between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andPstockIsNull() {
            addCriterion("pStock is null");
            return (Criteria) this;
        }

        public Criteria andPstockIsNotNull() {
            addCriterion("pStock is not null");
            return (Criteria) this;
        }

        public Criteria andPstockEqualTo(Integer value) {
            addCriterion("pStock =", value, "pstock");
            return (Criteria) this;
        }

        public Criteria andPstockNotEqualTo(Integer value) {
            addCriterion("pStock <>", value, "pstock");
            return (Criteria) this;
        }

        public Criteria andPstockGreaterThan(Integer value) {
            addCriterion("pStock >", value, "pstock");
            return (Criteria) this;
        }

        public Criteria andPstockGreaterThanOrEqualTo(Integer value) {
            addCriterion("pStock >=", value, "pstock");
            return (Criteria) this;
        }

        public Criteria andPstockLessThan(Integer value) {
            addCriterion("pStock <", value, "pstock");
            return (Criteria) this;
        }

        public Criteria andPstockLessThanOrEqualTo(Integer value) {
            addCriterion("pStock <=", value, "pstock");
            return (Criteria) this;
        }

        public Criteria andPstockIn(List<Integer> values) {
            addCriterion("pStock in", values, "pstock");
            return (Criteria) this;
        }

        public Criteria andPstockNotIn(List<Integer> values) {
            addCriterion("pStock not in", values, "pstock");
            return (Criteria) this;
        }

        public Criteria andPstockBetween(Integer value1, Integer value2) {
            addCriterion("pStock between", value1, value2, "pstock");
            return (Criteria) this;
        }

        public Criteria andPstockNotBetween(Integer value1, Integer value2) {
            addCriterion("pStock not between", value1, value2, "pstock");
            return (Criteria) this;
        }

        public Criteria andPsellnumIsNull() {
            addCriterion("pSellNum is null");
            return (Criteria) this;
        }

        public Criteria andPsellnumIsNotNull() {
            addCriterion("pSellNum is not null");
            return (Criteria) this;
        }

        public Criteria andPsellnumEqualTo(Integer value) {
            addCriterion("pSellNum =", value, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumNotEqualTo(Integer value) {
            addCriterion("pSellNum <>", value, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumGreaterThan(Integer value) {
            addCriterion("pSellNum >", value, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pSellNum >=", value, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumLessThan(Integer value) {
            addCriterion("pSellNum <", value, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumLessThanOrEqualTo(Integer value) {
            addCriterion("pSellNum <=", value, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumIn(List<Integer> values) {
            addCriterion("pSellNum in", values, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumNotIn(List<Integer> values) {
            addCriterion("pSellNum not in", values, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumBetween(Integer value1, Integer value2) {
            addCriterion("pSellNum between", value1, value2, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumNotBetween(Integer value1, Integer value2) {
            addCriterion("pSellNum not between", value1, value2, "psellnum");
            return (Criteria) this;
        }

        public Criteria andIsSellIsNull() {
            addCriterion("is_sell is null");
            return (Criteria) this;
        }

        public Criteria andIsSellIsNotNull() {
            addCriterion("is_sell is not null");
            return (Criteria) this;
        }

        public Criteria andIsSellEqualTo(Integer value) {
            addCriterion("is_sell =", value, "isSell");
            return (Criteria) this;
        }

        public Criteria andIsSellNotEqualTo(Integer value) {
            addCriterion("is_sell <>", value, "isSell");
            return (Criteria) this;
        }

        public Criteria andIsSellGreaterThan(Integer value) {
            addCriterion("is_sell >", value, "isSell");
            return (Criteria) this;
        }

        public Criteria andIsSellGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_sell >=", value, "isSell");
            return (Criteria) this;
        }

        public Criteria andIsSellLessThan(Integer value) {
            addCriterion("is_sell <", value, "isSell");
            return (Criteria) this;
        }

        public Criteria andIsSellLessThanOrEqualTo(Integer value) {
            addCriterion("is_sell <=", value, "isSell");
            return (Criteria) this;
        }

        public Criteria andIsSellIn(List<Integer> values) {
            addCriterion("is_sell in", values, "isSell");
            return (Criteria) this;
        }

        public Criteria andIsSellNotIn(List<Integer> values) {
            addCriterion("is_sell not in", values, "isSell");
            return (Criteria) this;
        }

        public Criteria andIsSellBetween(Integer value1, Integer value2) {
            addCriterion("is_sell between", value1, value2, "isSell");
            return (Criteria) this;
        }

        public Criteria andIsSellNotBetween(Integer value1, Integer value2) {
            addCriterion("is_sell not between", value1, value2, "isSell");
            return (Criteria) this;
        }

        public Criteria andPtypeIsNull() {
            addCriterion("pType is null");
            return (Criteria) this;
        }

        public Criteria andPtypeIsNotNull() {
            addCriterion("pType is not null");
            return (Criteria) this;
        }

        public Criteria andPtypeEqualTo(String value) {
            addCriterion("pType =", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeNotEqualTo(String value) {
            addCriterion("pType <>", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeGreaterThan(String value) {
            addCriterion("pType >", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeGreaterThanOrEqualTo(String value) {
            addCriterion("pType >=", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeLessThan(String value) {
            addCriterion("pType <", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeLessThanOrEqualTo(String value) {
            addCriterion("pType <=", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeLike(String value) {
            addCriterion("pType like", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeNotLike(String value) {
            addCriterion("pType not like", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeIn(List<String> values) {
            addCriterion("pType in", values, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeNotIn(List<String> values) {
            addCriterion("pType not in", values, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeBetween(String value1, String value2) {
            addCriterion("pType between", value1, value2, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeNotBetween(String value1, String value2) {
            addCriterion("pType not between", value1, value2, "ptype");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}