package com.cqust.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TUserstatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserstatisticsExample() {
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

        public Criteria andDatesIsNull() {
            addCriterion("dates is null");
            return (Criteria) this;
        }

        public Criteria andDatesIsNotNull() {
            addCriterion("dates is not null");
            return (Criteria) this;
        }

        public Criteria andDatesEqualTo(Date value) {
            addCriterion("dates =", value, "dates");
            return (Criteria) this;
        }

        public Criteria andDatesNotEqualTo(Date value) {
            addCriterion("dates <>", value, "dates");
            return (Criteria) this;
        }

        public Criteria andDatesGreaterThan(Date value) {
            addCriterion("dates >", value, "dates");
            return (Criteria) this;
        }

        public Criteria andDatesGreaterThanOrEqualTo(Date value) {
            addCriterion("dates >=", value, "dates");
            return (Criteria) this;
        }

        public Criteria andDatesLessThan(Date value) {
            addCriterion("dates <", value, "dates");
            return (Criteria) this;
        }

        public Criteria andDatesLessThanOrEqualTo(Date value) {
            addCriterion("dates <=", value, "dates");
            return (Criteria) this;
        }

        public Criteria andDatesIn(List<Date> values) {
            addCriterion("dates in", values, "dates");
            return (Criteria) this;
        }

        public Criteria andDatesNotIn(List<Date> values) {
            addCriterion("dates not in", values, "dates");
            return (Criteria) this;
        }

        public Criteria andDatesBetween(Date value1, Date value2) {
            addCriterion("dates between", value1, value2, "dates");
            return (Criteria) this;
        }

        public Criteria andDatesNotBetween(Date value1, Date value2) {
            addCriterion("dates not between", value1, value2, "dates");
            return (Criteria) this;
        }

        public Criteria andAccesscountIsNull() {
            addCriterion("accessCount is null");
            return (Criteria) this;
        }

        public Criteria andAccesscountIsNotNull() {
            addCriterion("accessCount is not null");
            return (Criteria) this;
        }

        public Criteria andAccesscountEqualTo(Integer value) {
            addCriterion("accessCount =", value, "accesscount");
            return (Criteria) this;
        }

        public Criteria andAccesscountNotEqualTo(Integer value) {
            addCriterion("accessCount <>", value, "accesscount");
            return (Criteria) this;
        }

        public Criteria andAccesscountGreaterThan(Integer value) {
            addCriterion("accessCount >", value, "accesscount");
            return (Criteria) this;
        }

        public Criteria andAccesscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("accessCount >=", value, "accesscount");
            return (Criteria) this;
        }

        public Criteria andAccesscountLessThan(Integer value) {
            addCriterion("accessCount <", value, "accesscount");
            return (Criteria) this;
        }

        public Criteria andAccesscountLessThanOrEqualTo(Integer value) {
            addCriterion("accessCount <=", value, "accesscount");
            return (Criteria) this;
        }

        public Criteria andAccesscountIn(List<Integer> values) {
            addCriterion("accessCount in", values, "accesscount");
            return (Criteria) this;
        }

        public Criteria andAccesscountNotIn(List<Integer> values) {
            addCriterion("accessCount not in", values, "accesscount");
            return (Criteria) this;
        }

        public Criteria andAccesscountBetween(Integer value1, Integer value2) {
            addCriterion("accessCount between", value1, value2, "accesscount");
            return (Criteria) this;
        }

        public Criteria andAccesscountNotBetween(Integer value1, Integer value2) {
            addCriterion("accessCount not between", value1, value2, "accesscount");
            return (Criteria) this;
        }

        public Criteria andRegistercountIsNull() {
            addCriterion("registerCount is null");
            return (Criteria) this;
        }

        public Criteria andRegistercountIsNotNull() {
            addCriterion("registerCount is not null");
            return (Criteria) this;
        }

        public Criteria andRegistercountEqualTo(Integer value) {
            addCriterion("registerCount =", value, "registercount");
            return (Criteria) this;
        }

        public Criteria andRegistercountNotEqualTo(Integer value) {
            addCriterion("registerCount <>", value, "registercount");
            return (Criteria) this;
        }

        public Criteria andRegistercountGreaterThan(Integer value) {
            addCriterion("registerCount >", value, "registercount");
            return (Criteria) this;
        }

        public Criteria andRegistercountGreaterThanOrEqualTo(Integer value) {
            addCriterion("registerCount >=", value, "registercount");
            return (Criteria) this;
        }

        public Criteria andRegistercountLessThan(Integer value) {
            addCriterion("registerCount <", value, "registercount");
            return (Criteria) this;
        }

        public Criteria andRegistercountLessThanOrEqualTo(Integer value) {
            addCriterion("registerCount <=", value, "registercount");
            return (Criteria) this;
        }

        public Criteria andRegistercountIn(List<Integer> values) {
            addCriterion("registerCount in", values, "registercount");
            return (Criteria) this;
        }

        public Criteria andRegistercountNotIn(List<Integer> values) {
            addCriterion("registerCount not in", values, "registercount");
            return (Criteria) this;
        }

        public Criteria andRegistercountBetween(Integer value1, Integer value2) {
            addCriterion("registerCount between", value1, value2, "registercount");
            return (Criteria) this;
        }

        public Criteria andRegistercountNotBetween(Integer value1, Integer value2) {
            addCriterion("registerCount not between", value1, value2, "registercount");
            return (Criteria) this;
        }

        public Criteria andLogincountIsNull() {
            addCriterion("loginCount is null");
            return (Criteria) this;
        }

        public Criteria andLogincountIsNotNull() {
            addCriterion("loginCount is not null");
            return (Criteria) this;
        }

        public Criteria andLogincountEqualTo(Integer value) {
            addCriterion("loginCount =", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountNotEqualTo(Integer value) {
            addCriterion("loginCount <>", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountGreaterThan(Integer value) {
            addCriterion("loginCount >", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountGreaterThanOrEqualTo(Integer value) {
            addCriterion("loginCount >=", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountLessThan(Integer value) {
            addCriterion("loginCount <", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountLessThanOrEqualTo(Integer value) {
            addCriterion("loginCount <=", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountIn(List<Integer> values) {
            addCriterion("loginCount in", values, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountNotIn(List<Integer> values) {
            addCriterion("loginCount not in", values, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountBetween(Integer value1, Integer value2) {
            addCriterion("loginCount between", value1, value2, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountNotBetween(Integer value1, Integer value2) {
            addCriterion("loginCount not between", value1, value2, "logincount");
            return (Criteria) this;
        }

        public Criteria andAddvipusercountIsNull() {
            addCriterion("addVipUserCount is null");
            return (Criteria) this;
        }

        public Criteria andAddvipusercountIsNotNull() {
            addCriterion("addVipUserCount is not null");
            return (Criteria) this;
        }

        public Criteria andAddvipusercountEqualTo(Integer value) {
            addCriterion("addVipUserCount =", value, "addvipusercount");
            return (Criteria) this;
        }

        public Criteria andAddvipusercountNotEqualTo(Integer value) {
            addCriterion("addVipUserCount <>", value, "addvipusercount");
            return (Criteria) this;
        }

        public Criteria andAddvipusercountGreaterThan(Integer value) {
            addCriterion("addVipUserCount >", value, "addvipusercount");
            return (Criteria) this;
        }

        public Criteria andAddvipusercountGreaterThanOrEqualTo(Integer value) {
            addCriterion("addVipUserCount >=", value, "addvipusercount");
            return (Criteria) this;
        }

        public Criteria andAddvipusercountLessThan(Integer value) {
            addCriterion("addVipUserCount <", value, "addvipusercount");
            return (Criteria) this;
        }

        public Criteria andAddvipusercountLessThanOrEqualTo(Integer value) {
            addCriterion("addVipUserCount <=", value, "addvipusercount");
            return (Criteria) this;
        }

        public Criteria andAddvipusercountIn(List<Integer> values) {
            addCriterion("addVipUserCount in", values, "addvipusercount");
            return (Criteria) this;
        }

        public Criteria andAddvipusercountNotIn(List<Integer> values) {
            addCriterion("addVipUserCount not in", values, "addvipusercount");
            return (Criteria) this;
        }

        public Criteria andAddvipusercountBetween(Integer value1, Integer value2) {
            addCriterion("addVipUserCount between", value1, value2, "addvipusercount");
            return (Criteria) this;
        }

        public Criteria andAddvipusercountNotBetween(Integer value1, Integer value2) {
            addCriterion("addVipUserCount not between", value1, value2, "addvipusercount");
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