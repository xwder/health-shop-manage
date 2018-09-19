package com.cqust.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TStoreapplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TStoreapplicationExample() {
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
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andOwnnameIsNull() {
            addCriterion("ownname is null");
            return (Criteria) this;
        }

        public Criteria andOwnnameIsNotNull() {
            addCriterion("ownname is not null");
            return (Criteria) this;
        }

        public Criteria andOwnnameEqualTo(String value) {
            addCriterion("ownname =", value, "ownname");
            return (Criteria) this;
        }

        public Criteria andOwnnameNotEqualTo(String value) {
            addCriterion("ownname <>", value, "ownname");
            return (Criteria) this;
        }

        public Criteria andOwnnameGreaterThan(String value) {
            addCriterion("ownname >", value, "ownname");
            return (Criteria) this;
        }

        public Criteria andOwnnameGreaterThanOrEqualTo(String value) {
            addCriterion("ownname >=", value, "ownname");
            return (Criteria) this;
        }

        public Criteria andOwnnameLessThan(String value) {
            addCriterion("ownname <", value, "ownname");
            return (Criteria) this;
        }

        public Criteria andOwnnameLessThanOrEqualTo(String value) {
            addCriterion("ownname <=", value, "ownname");
            return (Criteria) this;
        }

        public Criteria andOwnnameLike(String value) {
            addCriterion("ownname like", value, "ownname");
            return (Criteria) this;
        }

        public Criteria andOwnnameNotLike(String value) {
            addCriterion("ownname not like", value, "ownname");
            return (Criteria) this;
        }

        public Criteria andOwnnameIn(List<String> values) {
            addCriterion("ownname in", values, "ownname");
            return (Criteria) this;
        }

        public Criteria andOwnnameNotIn(List<String> values) {
            addCriterion("ownname not in", values, "ownname");
            return (Criteria) this;
        }

        public Criteria andOwnnameBetween(String value1, String value2) {
            addCriterion("ownname between", value1, value2, "ownname");
            return (Criteria) this;
        }

        public Criteria andOwnnameNotBetween(String value1, String value2) {
            addCriterion("ownname not between", value1, value2, "ownname");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uId is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uId is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uId =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uId <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uId >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uId >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uId <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uId <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uId like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uId not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uId in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uId not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uId between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uId not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidimageurlIsNull() {
            addCriterion("uidimageurl is null");
            return (Criteria) this;
        }

        public Criteria andUidimageurlIsNotNull() {
            addCriterion("uidimageurl is not null");
            return (Criteria) this;
        }

        public Criteria andUidimageurlEqualTo(String value) {
            addCriterion("uidimageurl =", value, "uidimageurl");
            return (Criteria) this;
        }

        public Criteria andUidimageurlNotEqualTo(String value) {
            addCriterion("uidimageurl <>", value, "uidimageurl");
            return (Criteria) this;
        }

        public Criteria andUidimageurlGreaterThan(String value) {
            addCriterion("uidimageurl >", value, "uidimageurl");
            return (Criteria) this;
        }

        public Criteria andUidimageurlGreaterThanOrEqualTo(String value) {
            addCriterion("uidimageurl >=", value, "uidimageurl");
            return (Criteria) this;
        }

        public Criteria andUidimageurlLessThan(String value) {
            addCriterion("uidimageurl <", value, "uidimageurl");
            return (Criteria) this;
        }

        public Criteria andUidimageurlLessThanOrEqualTo(String value) {
            addCriterion("uidimageurl <=", value, "uidimageurl");
            return (Criteria) this;
        }

        public Criteria andUidimageurlLike(String value) {
            addCriterion("uidimageurl like", value, "uidimageurl");
            return (Criteria) this;
        }

        public Criteria andUidimageurlNotLike(String value) {
            addCriterion("uidimageurl not like", value, "uidimageurl");
            return (Criteria) this;
        }

        public Criteria andUidimageurlIn(List<String> values) {
            addCriterion("uidimageurl in", values, "uidimageurl");
            return (Criteria) this;
        }

        public Criteria andUidimageurlNotIn(List<String> values) {
            addCriterion("uidimageurl not in", values, "uidimageurl");
            return (Criteria) this;
        }

        public Criteria andUidimageurlBetween(String value1, String value2) {
            addCriterion("uidimageurl between", value1, value2, "uidimageurl");
            return (Criteria) this;
        }

        public Criteria andUidimageurlNotBetween(String value1, String value2) {
            addCriterion("uidimageurl not between", value1, value2, "uidimageurl");
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

        public Criteria andStoreaddrIsNull() {
            addCriterion("storeAddr is null");
            return (Criteria) this;
        }

        public Criteria andStoreaddrIsNotNull() {
            addCriterion("storeAddr is not null");
            return (Criteria) this;
        }

        public Criteria andStoreaddrEqualTo(String value) {
            addCriterion("storeAddr =", value, "storeaddr");
            return (Criteria) this;
        }

        public Criteria andStoreaddrNotEqualTo(String value) {
            addCriterion("storeAddr <>", value, "storeaddr");
            return (Criteria) this;
        }

        public Criteria andStoreaddrGreaterThan(String value) {
            addCriterion("storeAddr >", value, "storeaddr");
            return (Criteria) this;
        }

        public Criteria andStoreaddrGreaterThanOrEqualTo(String value) {
            addCriterion("storeAddr >=", value, "storeaddr");
            return (Criteria) this;
        }

        public Criteria andStoreaddrLessThan(String value) {
            addCriterion("storeAddr <", value, "storeaddr");
            return (Criteria) this;
        }

        public Criteria andStoreaddrLessThanOrEqualTo(String value) {
            addCriterion("storeAddr <=", value, "storeaddr");
            return (Criteria) this;
        }

        public Criteria andStoreaddrLike(String value) {
            addCriterion("storeAddr like", value, "storeaddr");
            return (Criteria) this;
        }

        public Criteria andStoreaddrNotLike(String value) {
            addCriterion("storeAddr not like", value, "storeaddr");
            return (Criteria) this;
        }

        public Criteria andStoreaddrIn(List<String> values) {
            addCriterion("storeAddr in", values, "storeaddr");
            return (Criteria) this;
        }

        public Criteria andStoreaddrNotIn(List<String> values) {
            addCriterion("storeAddr not in", values, "storeaddr");
            return (Criteria) this;
        }

        public Criteria andStoreaddrBetween(String value1, String value2) {
            addCriterion("storeAddr between", value1, value2, "storeaddr");
            return (Criteria) this;
        }

        public Criteria andStoreaddrNotBetween(String value1, String value2) {
            addCriterion("storeAddr not between", value1, value2, "storeaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrIsNull() {
            addCriterion("detailaddr is null");
            return (Criteria) this;
        }

        public Criteria andDetailaddrIsNotNull() {
            addCriterion("detailaddr is not null");
            return (Criteria) this;
        }

        public Criteria andDetailaddrEqualTo(String value) {
            addCriterion("detailaddr =", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrNotEqualTo(String value) {
            addCriterion("detailaddr <>", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrGreaterThan(String value) {
            addCriterion("detailaddr >", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrGreaterThanOrEqualTo(String value) {
            addCriterion("detailaddr >=", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrLessThan(String value) {
            addCriterion("detailaddr <", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrLessThanOrEqualTo(String value) {
            addCriterion("detailaddr <=", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrLike(String value) {
            addCriterion("detailaddr like", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrNotLike(String value) {
            addCriterion("detailaddr not like", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrIn(List<String> values) {
            addCriterion("detailaddr in", values, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrNotIn(List<String> values) {
            addCriterion("detailaddr not in", values, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrBetween(String value1, String value2) {
            addCriterion("detailaddr between", value1, value2, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrNotBetween(String value1, String value2) {
            addCriterion("detailaddr not between", value1, value2, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andStorelicenseidIsNull() {
            addCriterion("storeLicenseid is null");
            return (Criteria) this;
        }

        public Criteria andStorelicenseidIsNotNull() {
            addCriterion("storeLicenseid is not null");
            return (Criteria) this;
        }

        public Criteria andStorelicenseidEqualTo(String value) {
            addCriterion("storeLicenseid =", value, "storelicenseid");
            return (Criteria) this;
        }

        public Criteria andStorelicenseidNotEqualTo(String value) {
            addCriterion("storeLicenseid <>", value, "storelicenseid");
            return (Criteria) this;
        }

        public Criteria andStorelicenseidGreaterThan(String value) {
            addCriterion("storeLicenseid >", value, "storelicenseid");
            return (Criteria) this;
        }

        public Criteria andStorelicenseidGreaterThanOrEqualTo(String value) {
            addCriterion("storeLicenseid >=", value, "storelicenseid");
            return (Criteria) this;
        }

        public Criteria andStorelicenseidLessThan(String value) {
            addCriterion("storeLicenseid <", value, "storelicenseid");
            return (Criteria) this;
        }

        public Criteria andStorelicenseidLessThanOrEqualTo(String value) {
            addCriterion("storeLicenseid <=", value, "storelicenseid");
            return (Criteria) this;
        }

        public Criteria andStorelicenseidLike(String value) {
            addCriterion("storeLicenseid like", value, "storelicenseid");
            return (Criteria) this;
        }

        public Criteria andStorelicenseidNotLike(String value) {
            addCriterion("storeLicenseid not like", value, "storelicenseid");
            return (Criteria) this;
        }

        public Criteria andStorelicenseidIn(List<String> values) {
            addCriterion("storeLicenseid in", values, "storelicenseid");
            return (Criteria) this;
        }

        public Criteria andStorelicenseidNotIn(List<String> values) {
            addCriterion("storeLicenseid not in", values, "storelicenseid");
            return (Criteria) this;
        }

        public Criteria andStorelicenseidBetween(String value1, String value2) {
            addCriterion("storeLicenseid between", value1, value2, "storelicenseid");
            return (Criteria) this;
        }

        public Criteria andStorelicenseidNotBetween(String value1, String value2) {
            addCriterion("storeLicenseid not between", value1, value2, "storelicenseid");
            return (Criteria) this;
        }

        public Criteria andLicenseimageurlIsNull() {
            addCriterion("licenseimageurl is null");
            return (Criteria) this;
        }

        public Criteria andLicenseimageurlIsNotNull() {
            addCriterion("licenseimageurl is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseimageurlEqualTo(String value) {
            addCriterion("licenseimageurl =", value, "licenseimageurl");
            return (Criteria) this;
        }

        public Criteria andLicenseimageurlNotEqualTo(String value) {
            addCriterion("licenseimageurl <>", value, "licenseimageurl");
            return (Criteria) this;
        }

        public Criteria andLicenseimageurlGreaterThan(String value) {
            addCriterion("licenseimageurl >", value, "licenseimageurl");
            return (Criteria) this;
        }

        public Criteria andLicenseimageurlGreaterThanOrEqualTo(String value) {
            addCriterion("licenseimageurl >=", value, "licenseimageurl");
            return (Criteria) this;
        }

        public Criteria andLicenseimageurlLessThan(String value) {
            addCriterion("licenseimageurl <", value, "licenseimageurl");
            return (Criteria) this;
        }

        public Criteria andLicenseimageurlLessThanOrEqualTo(String value) {
            addCriterion("licenseimageurl <=", value, "licenseimageurl");
            return (Criteria) this;
        }

        public Criteria andLicenseimageurlLike(String value) {
            addCriterion("licenseimageurl like", value, "licenseimageurl");
            return (Criteria) this;
        }

        public Criteria andLicenseimageurlNotLike(String value) {
            addCriterion("licenseimageurl not like", value, "licenseimageurl");
            return (Criteria) this;
        }

        public Criteria andLicenseimageurlIn(List<String> values) {
            addCriterion("licenseimageurl in", values, "licenseimageurl");
            return (Criteria) this;
        }

        public Criteria andLicenseimageurlNotIn(List<String> values) {
            addCriterion("licenseimageurl not in", values, "licenseimageurl");
            return (Criteria) this;
        }

        public Criteria andLicenseimageurlBetween(String value1, String value2) {
            addCriterion("licenseimageurl between", value1, value2, "licenseimageurl");
            return (Criteria) this;
        }

        public Criteria andLicenseimageurlNotBetween(String value1, String value2) {
            addCriterion("licenseimageurl not between", value1, value2, "licenseimageurl");
            return (Criteria) this;
        }

        public Criteria andStoretypeIsNull() {
            addCriterion("storeType is null");
            return (Criteria) this;
        }

        public Criteria andStoretypeIsNotNull() {
            addCriterion("storeType is not null");
            return (Criteria) this;
        }

        public Criteria andStoretypeEqualTo(Integer value) {
            addCriterion("storeType =", value, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeNotEqualTo(Integer value) {
            addCriterion("storeType <>", value, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeGreaterThan(Integer value) {
            addCriterion("storeType >", value, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("storeType >=", value, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeLessThan(Integer value) {
            addCriterion("storeType <", value, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeLessThanOrEqualTo(Integer value) {
            addCriterion("storeType <=", value, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeIn(List<Integer> values) {
            addCriterion("storeType in", values, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeNotIn(List<Integer> values) {
            addCriterion("storeType not in", values, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeBetween(Integer value1, Integer value2) {
            addCriterion("storeType between", value1, value2, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeNotBetween(Integer value1, Integer value2) {
            addCriterion("storeType not between", value1, value2, "storetype");
            return (Criteria) this;
        }

        public Criteria andSqdateIsNull() {
            addCriterion("sqDate is null");
            return (Criteria) this;
        }

        public Criteria andSqdateIsNotNull() {
            addCriterion("sqDate is not null");
            return (Criteria) this;
        }

        public Criteria andSqdateEqualTo(Date value) {
            addCriterion("sqDate =", value, "sqdate");
            return (Criteria) this;
        }

        public Criteria andSqdateNotEqualTo(Date value) {
            addCriterion("sqDate <>", value, "sqdate");
            return (Criteria) this;
        }

        public Criteria andSqdateGreaterThan(Date value) {
            addCriterion("sqDate >", value, "sqdate");
            return (Criteria) this;
        }

        public Criteria andSqdateGreaterThanOrEqualTo(Date value) {
            addCriterion("sqDate >=", value, "sqdate");
            return (Criteria) this;
        }

        public Criteria andSqdateLessThan(Date value) {
            addCriterion("sqDate <", value, "sqdate");
            return (Criteria) this;
        }

        public Criteria andSqdateLessThanOrEqualTo(Date value) {
            addCriterion("sqDate <=", value, "sqdate");
            return (Criteria) this;
        }

        public Criteria andSqdateIn(List<Date> values) {
            addCriterion("sqDate in", values, "sqdate");
            return (Criteria) this;
        }

        public Criteria andSqdateNotIn(List<Date> values) {
            addCriterion("sqDate not in", values, "sqdate");
            return (Criteria) this;
        }

        public Criteria andSqdateBetween(Date value1, Date value2) {
            addCriterion("sqDate between", value1, value2, "sqdate");
            return (Criteria) this;
        }

        public Criteria andSqdateNotBetween(Date value1, Date value2) {
            addCriterion("sqDate not between", value1, value2, "sqdate");
            return (Criteria) this;
        }

        public Criteria andSqstatusIsNull() {
            addCriterion("sqStatus is null");
            return (Criteria) this;
        }

        public Criteria andSqstatusIsNotNull() {
            addCriterion("sqStatus is not null");
            return (Criteria) this;
        }

        public Criteria andSqstatusEqualTo(Integer value) {
            addCriterion("sqStatus =", value, "sqstatus");
            return (Criteria) this;
        }

        public Criteria andSqstatusNotEqualTo(Integer value) {
            addCriterion("sqStatus <>", value, "sqstatus");
            return (Criteria) this;
        }

        public Criteria andSqstatusGreaterThan(Integer value) {
            addCriterion("sqStatus >", value, "sqstatus");
            return (Criteria) this;
        }

        public Criteria andSqstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sqStatus >=", value, "sqstatus");
            return (Criteria) this;
        }

        public Criteria andSqstatusLessThan(Integer value) {
            addCriterion("sqStatus <", value, "sqstatus");
            return (Criteria) this;
        }

        public Criteria andSqstatusLessThanOrEqualTo(Integer value) {
            addCriterion("sqStatus <=", value, "sqstatus");
            return (Criteria) this;
        }

        public Criteria andSqstatusIn(List<Integer> values) {
            addCriterion("sqStatus in", values, "sqstatus");
            return (Criteria) this;
        }

        public Criteria andSqstatusNotIn(List<Integer> values) {
            addCriterion("sqStatus not in", values, "sqstatus");
            return (Criteria) this;
        }

        public Criteria andSqstatusBetween(Integer value1, Integer value2) {
            addCriterion("sqStatus between", value1, value2, "sqstatus");
            return (Criteria) this;
        }

        public Criteria andSqstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sqStatus not between", value1, value2, "sqstatus");
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