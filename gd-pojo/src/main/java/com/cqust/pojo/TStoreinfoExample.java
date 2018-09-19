package com.cqust.pojo;

import java.util.ArrayList;
import java.util.List;

public class TStoreinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TStoreinfoExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andStorelogoimgIsNull() {
            addCriterion("storelogoimg is null");
            return (Criteria) this;
        }

        public Criteria andStorelogoimgIsNotNull() {
            addCriterion("storelogoimg is not null");
            return (Criteria) this;
        }

        public Criteria andStorelogoimgEqualTo(String value) {
            addCriterion("storelogoimg =", value, "storelogoimg");
            return (Criteria) this;
        }

        public Criteria andStorelogoimgNotEqualTo(String value) {
            addCriterion("storelogoimg <>", value, "storelogoimg");
            return (Criteria) this;
        }

        public Criteria andStorelogoimgGreaterThan(String value) {
            addCriterion("storelogoimg >", value, "storelogoimg");
            return (Criteria) this;
        }

        public Criteria andStorelogoimgGreaterThanOrEqualTo(String value) {
            addCriterion("storelogoimg >=", value, "storelogoimg");
            return (Criteria) this;
        }

        public Criteria andStorelogoimgLessThan(String value) {
            addCriterion("storelogoimg <", value, "storelogoimg");
            return (Criteria) this;
        }

        public Criteria andStorelogoimgLessThanOrEqualTo(String value) {
            addCriterion("storelogoimg <=", value, "storelogoimg");
            return (Criteria) this;
        }

        public Criteria andStorelogoimgLike(String value) {
            addCriterion("storelogoimg like", value, "storelogoimg");
            return (Criteria) this;
        }

        public Criteria andStorelogoimgNotLike(String value) {
            addCriterion("storelogoimg not like", value, "storelogoimg");
            return (Criteria) this;
        }

        public Criteria andStorelogoimgIn(List<String> values) {
            addCriterion("storelogoimg in", values, "storelogoimg");
            return (Criteria) this;
        }

        public Criteria andStorelogoimgNotIn(List<String> values) {
            addCriterion("storelogoimg not in", values, "storelogoimg");
            return (Criteria) this;
        }

        public Criteria andStorelogoimgBetween(String value1, String value2) {
            addCriterion("storelogoimg between", value1, value2, "storelogoimg");
            return (Criteria) this;
        }

        public Criteria andStorelogoimgNotBetween(String value1, String value2) {
            addCriterion("storelogoimg not between", value1, value2, "storelogoimg");
            return (Criteria) this;
        }

        public Criteria andStorenameIsNull() {
            addCriterion("storeName is null");
            return (Criteria) this;
        }

        public Criteria andStorenameIsNotNull() {
            addCriterion("storeName is not null");
            return (Criteria) this;
        }

        public Criteria andStorenameEqualTo(String value) {
            addCriterion("storeName =", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotEqualTo(String value) {
            addCriterion("storeName <>", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameGreaterThan(String value) {
            addCriterion("storeName >", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameGreaterThanOrEqualTo(String value) {
            addCriterion("storeName >=", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLessThan(String value) {
            addCriterion("storeName <", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLessThanOrEqualTo(String value) {
            addCriterion("storeName <=", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLike(String value) {
            addCriterion("storeName like", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotLike(String value) {
            addCriterion("storeName not like", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameIn(List<String> values) {
            addCriterion("storeName in", values, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotIn(List<String> values) {
            addCriterion("storeName not in", values, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameBetween(String value1, String value2) {
            addCriterion("storeName between", value1, value2, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotBetween(String value1, String value2) {
            addCriterion("storeName not between", value1, value2, "storename");
            return (Criteria) this;
        }

        public Criteria andSnameIsNull() {
            addCriterion("sName is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("sName is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("sName =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("sName <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("sName >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("sName >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("sName <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("sName <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("sName like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("sName not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(List<String> values) {
            addCriterion("sName in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(List<String> values) {
            addCriterion("sName not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("sName between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("sName not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSphoneIsNull() {
            addCriterion("sPhone is null");
            return (Criteria) this;
        }

        public Criteria andSphoneIsNotNull() {
            addCriterion("sPhone is not null");
            return (Criteria) this;
        }

        public Criteria andSphoneEqualTo(String value) {
            addCriterion("sPhone =", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneNotEqualTo(String value) {
            addCriterion("sPhone <>", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneGreaterThan(String value) {
            addCriterion("sPhone >", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneGreaterThanOrEqualTo(String value) {
            addCriterion("sPhone >=", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneLessThan(String value) {
            addCriterion("sPhone <", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneLessThanOrEqualTo(String value) {
            addCriterion("sPhone <=", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneLike(String value) {
            addCriterion("sPhone like", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneNotLike(String value) {
            addCriterion("sPhone not like", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneIn(List<String> values) {
            addCriterion("sPhone in", values, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneNotIn(List<String> values) {
            addCriterion("sPhone not in", values, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneBetween(String value1, String value2) {
            addCriterion("sPhone between", value1, value2, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneNotBetween(String value1, String value2) {
            addCriterion("sPhone not between", value1, value2, "sphone");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sID is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sID is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(String value) {
            addCriterion("sID =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(String value) {
            addCriterion("sID <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(String value) {
            addCriterion("sID >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(String value) {
            addCriterion("sID >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(String value) {
            addCriterion("sID <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(String value) {
            addCriterion("sID <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLike(String value) {
            addCriterion("sID like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotLike(String value) {
            addCriterion("sID not like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<String> values) {
            addCriterion("sID in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<String> values) {
            addCriterion("sID not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(String value1, String value2) {
            addCriterion("sID between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(String value1, String value2) {
            addCriterion("sID not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSlicenseIsNull() {
            addCriterion("sLicense is null");
            return (Criteria) this;
        }

        public Criteria andSlicenseIsNotNull() {
            addCriterion("sLicense is not null");
            return (Criteria) this;
        }

        public Criteria andSlicenseEqualTo(String value) {
            addCriterion("sLicense =", value, "slicense");
            return (Criteria) this;
        }

        public Criteria andSlicenseNotEqualTo(String value) {
            addCriterion("sLicense <>", value, "slicense");
            return (Criteria) this;
        }

        public Criteria andSlicenseGreaterThan(String value) {
            addCriterion("sLicense >", value, "slicense");
            return (Criteria) this;
        }

        public Criteria andSlicenseGreaterThanOrEqualTo(String value) {
            addCriterion("sLicense >=", value, "slicense");
            return (Criteria) this;
        }

        public Criteria andSlicenseLessThan(String value) {
            addCriterion("sLicense <", value, "slicense");
            return (Criteria) this;
        }

        public Criteria andSlicenseLessThanOrEqualTo(String value) {
            addCriterion("sLicense <=", value, "slicense");
            return (Criteria) this;
        }

        public Criteria andSlicenseLike(String value) {
            addCriterion("sLicense like", value, "slicense");
            return (Criteria) this;
        }

        public Criteria andSlicenseNotLike(String value) {
            addCriterion("sLicense not like", value, "slicense");
            return (Criteria) this;
        }

        public Criteria andSlicenseIn(List<String> values) {
            addCriterion("sLicense in", values, "slicense");
            return (Criteria) this;
        }

        public Criteria andSlicenseNotIn(List<String> values) {
            addCriterion("sLicense not in", values, "slicense");
            return (Criteria) this;
        }

        public Criteria andSlicenseBetween(String value1, String value2) {
            addCriterion("sLicense between", value1, value2, "slicense");
            return (Criteria) this;
        }

        public Criteria andSlicenseNotBetween(String value1, String value2) {
            addCriterion("sLicense not between", value1, value2, "slicense");
            return (Criteria) this;
        }

        public Criteria andSdzIsNull() {
            addCriterion("sdz is null");
            return (Criteria) this;
        }

        public Criteria andSdzIsNotNull() {
            addCriterion("sdz is not null");
            return (Criteria) this;
        }

        public Criteria andSdzEqualTo(String value) {
            addCriterion("sdz =", value, "sdz");
            return (Criteria) this;
        }

        public Criteria andSdzNotEqualTo(String value) {
            addCriterion("sdz <>", value, "sdz");
            return (Criteria) this;
        }

        public Criteria andSdzGreaterThan(String value) {
            addCriterion("sdz >", value, "sdz");
            return (Criteria) this;
        }

        public Criteria andSdzGreaterThanOrEqualTo(String value) {
            addCriterion("sdz >=", value, "sdz");
            return (Criteria) this;
        }

        public Criteria andSdzLessThan(String value) {
            addCriterion("sdz <", value, "sdz");
            return (Criteria) this;
        }

        public Criteria andSdzLessThanOrEqualTo(String value) {
            addCriterion("sdz <=", value, "sdz");
            return (Criteria) this;
        }

        public Criteria andSdzLike(String value) {
            addCriterion("sdz like", value, "sdz");
            return (Criteria) this;
        }

        public Criteria andSdzNotLike(String value) {
            addCriterion("sdz not like", value, "sdz");
            return (Criteria) this;
        }

        public Criteria andSdzIn(List<String> values) {
            addCriterion("sdz in", values, "sdz");
            return (Criteria) this;
        }

        public Criteria andSdzNotIn(List<String> values) {
            addCriterion("sdz not in", values, "sdz");
            return (Criteria) this;
        }

        public Criteria andSdzBetween(String value1, String value2) {
            addCriterion("sdz between", value1, value2, "sdz");
            return (Criteria) this;
        }

        public Criteria andSdzNotBetween(String value1, String value2) {
            addCriterion("sdz not between", value1, value2, "sdz");
            return (Criteria) this;
        }

        public Criteria andSaddrIsNull() {
            addCriterion("sAddr is null");
            return (Criteria) this;
        }

        public Criteria andSaddrIsNotNull() {
            addCriterion("sAddr is not null");
            return (Criteria) this;
        }

        public Criteria andSaddrEqualTo(String value) {
            addCriterion("sAddr =", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrNotEqualTo(String value) {
            addCriterion("sAddr <>", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrGreaterThan(String value) {
            addCriterion("sAddr >", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrGreaterThanOrEqualTo(String value) {
            addCriterion("sAddr >=", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrLessThan(String value) {
            addCriterion("sAddr <", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrLessThanOrEqualTo(String value) {
            addCriterion("sAddr <=", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrLike(String value) {
            addCriterion("sAddr like", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrNotLike(String value) {
            addCriterion("sAddr not like", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrIn(List<String> values) {
            addCriterion("sAddr in", values, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrNotIn(List<String> values) {
            addCriterion("sAddr not in", values, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrBetween(String value1, String value2) {
            addCriterion("sAddr between", value1, value2, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrNotBetween(String value1, String value2) {
            addCriterion("sAddr not between", value1, value2, "saddr");
            return (Criteria) this;
        }

        public Criteria andIsCheckIsNull() {
            addCriterion("is_check is null");
            return (Criteria) this;
        }

        public Criteria andIsCheckIsNotNull() {
            addCriterion("is_check is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheckEqualTo(Integer value) {
            addCriterion("is_check =", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotEqualTo(Integer value) {
            addCriterion("is_check <>", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckGreaterThan(Integer value) {
            addCriterion("is_check >", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_check >=", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLessThan(Integer value) {
            addCriterion("is_check <", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLessThanOrEqualTo(Integer value) {
            addCriterion("is_check <=", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckIn(List<Integer> values) {
            addCriterion("is_check in", values, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotIn(List<Integer> values) {
            addCriterion("is_check not in", values, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckBetween(Integer value1, Integer value2) {
            addCriterion("is_check between", value1, value2, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("is_check not between", value1, value2, "isCheck");
            return (Criteria) this;
        }

        public Criteria andStypeIsNull() {
            addCriterion("sType is null");
            return (Criteria) this;
        }

        public Criteria andStypeIsNotNull() {
            addCriterion("sType is not null");
            return (Criteria) this;
        }

        public Criteria andStypeEqualTo(String value) {
            addCriterion("sType =", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeNotEqualTo(String value) {
            addCriterion("sType <>", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeGreaterThan(String value) {
            addCriterion("sType >", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeGreaterThanOrEqualTo(String value) {
            addCriterion("sType >=", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeLessThan(String value) {
            addCriterion("sType <", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeLessThanOrEqualTo(String value) {
            addCriterion("sType <=", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeLike(String value) {
            addCriterion("sType like", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeNotLike(String value) {
            addCriterion("sType not like", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeIn(List<String> values) {
            addCriterion("sType in", values, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeNotIn(List<String> values) {
            addCriterion("sType not in", values, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeBetween(String value1, String value2) {
            addCriterion("sType between", value1, value2, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeNotBetween(String value1, String value2) {
            addCriterion("sType not between", value1, value2, "stype");
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