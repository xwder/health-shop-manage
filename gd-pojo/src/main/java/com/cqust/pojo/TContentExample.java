package com.cqust.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TContentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TContentExample() {
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

        public Criteria andDietitianidIsNull() {
            addCriterion("dietitianId is null");
            return (Criteria) this;
        }

        public Criteria andDietitianidIsNotNull() {
            addCriterion("dietitianId is not null");
            return (Criteria) this;
        }

        public Criteria andDietitianidEqualTo(Integer value) {
            addCriterion("dietitianId =", value, "dietitianid");
            return (Criteria) this;
        }

        public Criteria andDietitianidNotEqualTo(Integer value) {
            addCriterion("dietitianId <>", value, "dietitianid");
            return (Criteria) this;
        }

        public Criteria andDietitianidGreaterThan(Integer value) {
            addCriterion("dietitianId >", value, "dietitianid");
            return (Criteria) this;
        }

        public Criteria andDietitianidGreaterThanOrEqualTo(Integer value) {
            addCriterion("dietitianId >=", value, "dietitianid");
            return (Criteria) this;
        }

        public Criteria andDietitianidLessThan(Integer value) {
            addCriterion("dietitianId <", value, "dietitianid");
            return (Criteria) this;
        }

        public Criteria andDietitianidLessThanOrEqualTo(Integer value) {
            addCriterion("dietitianId <=", value, "dietitianid");
            return (Criteria) this;
        }

        public Criteria andDietitianidIn(List<Integer> values) {
            addCriterion("dietitianId in", values, "dietitianid");
            return (Criteria) this;
        }

        public Criteria andDietitianidNotIn(List<Integer> values) {
            addCriterion("dietitianId not in", values, "dietitianid");
            return (Criteria) this;
        }

        public Criteria andDietitianidBetween(Integer value1, Integer value2) {
            addCriterion("dietitianId between", value1, value2, "dietitianid");
            return (Criteria) this;
        }

        public Criteria andDietitianidNotBetween(Integer value1, Integer value2) {
            addCriterion("dietitianId not between", value1, value2, "dietitianid");
            return (Criteria) this;
        }

        public Criteria andZxtimeIsNull() {
            addCriterion("zxTime is null");
            return (Criteria) this;
        }

        public Criteria andZxtimeIsNotNull() {
            addCriterion("zxTime is not null");
            return (Criteria) this;
        }

        public Criteria andZxtimeEqualTo(Date value) {
            addCriterion("zxTime =", value, "zxtime");
            return (Criteria) this;
        }

        public Criteria andZxtimeNotEqualTo(Date value) {
            addCriterion("zxTime <>", value, "zxtime");
            return (Criteria) this;
        }

        public Criteria andZxtimeGreaterThan(Date value) {
            addCriterion("zxTime >", value, "zxtime");
            return (Criteria) this;
        }

        public Criteria andZxtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("zxTime >=", value, "zxtime");
            return (Criteria) this;
        }

        public Criteria andZxtimeLessThan(Date value) {
            addCriterion("zxTime <", value, "zxtime");
            return (Criteria) this;
        }

        public Criteria andZxtimeLessThanOrEqualTo(Date value) {
            addCriterion("zxTime <=", value, "zxtime");
            return (Criteria) this;
        }

        public Criteria andZxtimeIn(List<Date> values) {
            addCriterion("zxTime in", values, "zxtime");
            return (Criteria) this;
        }

        public Criteria andZxtimeNotIn(List<Date> values) {
            addCriterion("zxTime not in", values, "zxtime");
            return (Criteria) this;
        }

        public Criteria andZxtimeBetween(Date value1, Date value2) {
            addCriterion("zxTime between", value1, value2, "zxtime");
            return (Criteria) this;
        }

        public Criteria andZxtimeNotBetween(Date value1, Date value2) {
            addCriterion("zxTime not between", value1, value2, "zxtime");
            return (Criteria) this;
        }

        public Criteria andZxtextIsNull() {
            addCriterion("zxText is null");
            return (Criteria) this;
        }

        public Criteria andZxtextIsNotNull() {
            addCriterion("zxText is not null");
            return (Criteria) this;
        }

        public Criteria andZxtextEqualTo(String value) {
            addCriterion("zxText =", value, "zxtext");
            return (Criteria) this;
        }

        public Criteria andZxtextNotEqualTo(String value) {
            addCriterion("zxText <>", value, "zxtext");
            return (Criteria) this;
        }

        public Criteria andZxtextGreaterThan(String value) {
            addCriterion("zxText >", value, "zxtext");
            return (Criteria) this;
        }

        public Criteria andZxtextGreaterThanOrEqualTo(String value) {
            addCriterion("zxText >=", value, "zxtext");
            return (Criteria) this;
        }

        public Criteria andZxtextLessThan(String value) {
            addCriterion("zxText <", value, "zxtext");
            return (Criteria) this;
        }

        public Criteria andZxtextLessThanOrEqualTo(String value) {
            addCriterion("zxText <=", value, "zxtext");
            return (Criteria) this;
        }

        public Criteria andZxtextLike(String value) {
            addCriterion("zxText like", value, "zxtext");
            return (Criteria) this;
        }

        public Criteria andZxtextNotLike(String value) {
            addCriterion("zxText not like", value, "zxtext");
            return (Criteria) this;
        }

        public Criteria andZxtextIn(List<String> values) {
            addCriterion("zxText in", values, "zxtext");
            return (Criteria) this;
        }

        public Criteria andZxtextNotIn(List<String> values) {
            addCriterion("zxText not in", values, "zxtext");
            return (Criteria) this;
        }

        public Criteria andZxtextBetween(String value1, String value2) {
            addCriterion("zxText between", value1, value2, "zxtext");
            return (Criteria) this;
        }

        public Criteria andZxtextNotBetween(String value1, String value2) {
            addCriterion("zxText not between", value1, value2, "zxtext");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNull() {
            addCriterion("is_read is null");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNotNull() {
            addCriterion("is_read is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadEqualTo(Integer value) {
            addCriterion("is_read =", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotEqualTo(Integer value) {
            addCriterion("is_read <>", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThan(Integer value) {
            addCriterion("is_read >", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_read >=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThan(Integer value) {
            addCriterion("is_read <", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThanOrEqualTo(Integer value) {
            addCriterion("is_read <=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadIn(List<Integer> values) {
            addCriterion("is_read in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotIn(List<Integer> values) {
            addCriterion("is_read not in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadBetween(Integer value1, Integer value2) {
            addCriterion("is_read between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotBetween(Integer value1, Integer value2) {
            addCriterion("is_read not between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andZxidentityIsNull() {
            addCriterion("zxIdentity is null");
            return (Criteria) this;
        }

        public Criteria andZxidentityIsNotNull() {
            addCriterion("zxIdentity is not null");
            return (Criteria) this;
        }

        public Criteria andZxidentityEqualTo(Integer value) {
            addCriterion("zxIdentity =", value, "zxidentity");
            return (Criteria) this;
        }

        public Criteria andZxidentityNotEqualTo(Integer value) {
            addCriterion("zxIdentity <>", value, "zxidentity");
            return (Criteria) this;
        }

        public Criteria andZxidentityGreaterThan(Integer value) {
            addCriterion("zxIdentity >", value, "zxidentity");
            return (Criteria) this;
        }

        public Criteria andZxidentityGreaterThanOrEqualTo(Integer value) {
            addCriterion("zxIdentity >=", value, "zxidentity");
            return (Criteria) this;
        }

        public Criteria andZxidentityLessThan(Integer value) {
            addCriterion("zxIdentity <", value, "zxidentity");
            return (Criteria) this;
        }

        public Criteria andZxidentityLessThanOrEqualTo(Integer value) {
            addCriterion("zxIdentity <=", value, "zxidentity");
            return (Criteria) this;
        }

        public Criteria andZxidentityIn(List<Integer> values) {
            addCriterion("zxIdentity in", values, "zxidentity");
            return (Criteria) this;
        }

        public Criteria andZxidentityNotIn(List<Integer> values) {
            addCriterion("zxIdentity not in", values, "zxidentity");
            return (Criteria) this;
        }

        public Criteria andZxidentityBetween(Integer value1, Integer value2) {
            addCriterion("zxIdentity between", value1, value2, "zxidentity");
            return (Criteria) this;
        }

        public Criteria andZxidentityNotBetween(Integer value1, Integer value2) {
            addCriterion("zxIdentity not between", value1, value2, "zxidentity");
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