package com.cqust.pojo;

import java.util.ArrayList;
import java.util.List;

public class TAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAddressExample() {
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

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
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

        public Criteria andZipcodeIsNull() {
            addCriterion("zipcode is null");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNotNull() {
            addCriterion("zipcode is not null");
            return (Criteria) this;
        }

        public Criteria andZipcodeEqualTo(String value) {
            addCriterion("zipcode =", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotEqualTo(String value) {
            addCriterion("zipcode <>", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThan(String value) {
            addCriterion("zipcode >", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThanOrEqualTo(String value) {
            addCriterion("zipcode >=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThan(String value) {
            addCriterion("zipcode <", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThanOrEqualTo(String value) {
            addCriterion("zipcode <=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLike(String value) {
            addCriterion("zipcode like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotLike(String value) {
            addCriterion("zipcode not like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeIn(List<String> values) {
            addCriterion("zipcode in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotIn(List<String> values) {
            addCriterion("zipcode not in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeBetween(String value1, String value2) {
            addCriterion("zipcode between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotBetween(String value1, String value2) {
            addCriterion("zipcode not between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andReceiptnameIsNull() {
            addCriterion("receiptname is null");
            return (Criteria) this;
        }

        public Criteria andReceiptnameIsNotNull() {
            addCriterion("receiptname is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptnameEqualTo(String value) {
            addCriterion("receiptname =", value, "receiptname");
            return (Criteria) this;
        }

        public Criteria andReceiptnameNotEqualTo(String value) {
            addCriterion("receiptname <>", value, "receiptname");
            return (Criteria) this;
        }

        public Criteria andReceiptnameGreaterThan(String value) {
            addCriterion("receiptname >", value, "receiptname");
            return (Criteria) this;
        }

        public Criteria andReceiptnameGreaterThanOrEqualTo(String value) {
            addCriterion("receiptname >=", value, "receiptname");
            return (Criteria) this;
        }

        public Criteria andReceiptnameLessThan(String value) {
            addCriterion("receiptname <", value, "receiptname");
            return (Criteria) this;
        }

        public Criteria andReceiptnameLessThanOrEqualTo(String value) {
            addCriterion("receiptname <=", value, "receiptname");
            return (Criteria) this;
        }

        public Criteria andReceiptnameLike(String value) {
            addCriterion("receiptname like", value, "receiptname");
            return (Criteria) this;
        }

        public Criteria andReceiptnameNotLike(String value) {
            addCriterion("receiptname not like", value, "receiptname");
            return (Criteria) this;
        }

        public Criteria andReceiptnameIn(List<String> values) {
            addCriterion("receiptname in", values, "receiptname");
            return (Criteria) this;
        }

        public Criteria andReceiptnameNotIn(List<String> values) {
            addCriterion("receiptname not in", values, "receiptname");
            return (Criteria) this;
        }

        public Criteria andReceiptnameBetween(String value1, String value2) {
            addCriterion("receiptname between", value1, value2, "receiptname");
            return (Criteria) this;
        }

        public Criteria andReceiptnameNotBetween(String value1, String value2) {
            addCriterion("receiptname not between", value1, value2, "receiptname");
            return (Criteria) this;
        }

        public Criteria andReceipphoneIsNull() {
            addCriterion("receipphone is null");
            return (Criteria) this;
        }

        public Criteria andReceipphoneIsNotNull() {
            addCriterion("receipphone is not null");
            return (Criteria) this;
        }

        public Criteria andReceipphoneEqualTo(String value) {
            addCriterion("receipphone =", value, "receipphone");
            return (Criteria) this;
        }

        public Criteria andReceipphoneNotEqualTo(String value) {
            addCriterion("receipphone <>", value, "receipphone");
            return (Criteria) this;
        }

        public Criteria andReceipphoneGreaterThan(String value) {
            addCriterion("receipphone >", value, "receipphone");
            return (Criteria) this;
        }

        public Criteria andReceipphoneGreaterThanOrEqualTo(String value) {
            addCriterion("receipphone >=", value, "receipphone");
            return (Criteria) this;
        }

        public Criteria andReceipphoneLessThan(String value) {
            addCriterion("receipphone <", value, "receipphone");
            return (Criteria) this;
        }

        public Criteria andReceipphoneLessThanOrEqualTo(String value) {
            addCriterion("receipphone <=", value, "receipphone");
            return (Criteria) this;
        }

        public Criteria andReceipphoneLike(String value) {
            addCriterion("receipphone like", value, "receipphone");
            return (Criteria) this;
        }

        public Criteria andReceipphoneNotLike(String value) {
            addCriterion("receipphone not like", value, "receipphone");
            return (Criteria) this;
        }

        public Criteria andReceipphoneIn(List<String> values) {
            addCriterion("receipphone in", values, "receipphone");
            return (Criteria) this;
        }

        public Criteria andReceipphoneNotIn(List<String> values) {
            addCriterion("receipphone not in", values, "receipphone");
            return (Criteria) this;
        }

        public Criteria andReceipphoneBetween(String value1, String value2) {
            addCriterion("receipphone between", value1, value2, "receipphone");
            return (Criteria) this;
        }

        public Criteria andReceipphoneNotBetween(String value1, String value2) {
            addCriterion("receipphone not between", value1, value2, "receipphone");
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

        public Criteria andDefauladdressIsNull() {
            addCriterion("defauladdress is null");
            return (Criteria) this;
        }

        public Criteria andDefauladdressIsNotNull() {
            addCriterion("defauladdress is not null");
            return (Criteria) this;
        }

        public Criteria andDefauladdressEqualTo(Integer value) {
            addCriterion("defauladdress =", value, "defauladdress");
            return (Criteria) this;
        }

        public Criteria andDefauladdressNotEqualTo(Integer value) {
            addCriterion("defauladdress <>", value, "defauladdress");
            return (Criteria) this;
        }

        public Criteria andDefauladdressGreaterThan(Integer value) {
            addCriterion("defauladdress >", value, "defauladdress");
            return (Criteria) this;
        }

        public Criteria andDefauladdressGreaterThanOrEqualTo(Integer value) {
            addCriterion("defauladdress >=", value, "defauladdress");
            return (Criteria) this;
        }

        public Criteria andDefauladdressLessThan(Integer value) {
            addCriterion("defauladdress <", value, "defauladdress");
            return (Criteria) this;
        }

        public Criteria andDefauladdressLessThanOrEqualTo(Integer value) {
            addCriterion("defauladdress <=", value, "defauladdress");
            return (Criteria) this;
        }

        public Criteria andDefauladdressIn(List<Integer> values) {
            addCriterion("defauladdress in", values, "defauladdress");
            return (Criteria) this;
        }

        public Criteria andDefauladdressNotIn(List<Integer> values) {
            addCriterion("defauladdress not in", values, "defauladdress");
            return (Criteria) this;
        }

        public Criteria andDefauladdressBetween(Integer value1, Integer value2) {
            addCriterion("defauladdress between", value1, value2, "defauladdress");
            return (Criteria) this;
        }

        public Criteria andDefauladdressNotBetween(Integer value1, Integer value2) {
            addCriterion("defauladdress not between", value1, value2, "defauladdress");
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