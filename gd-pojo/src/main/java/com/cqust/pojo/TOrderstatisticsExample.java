package com.cqust.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOrderstatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrderstatisticsExample() {
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

        public Criteria andStoresqcountIsNull() {
            addCriterion("storeSqCount is null");
            return (Criteria) this;
        }

        public Criteria andStoresqcountIsNotNull() {
            addCriterion("storeSqCount is not null");
            return (Criteria) this;
        }

        public Criteria andStoresqcountEqualTo(Integer value) {
            addCriterion("storeSqCount =", value, "storesqcount");
            return (Criteria) this;
        }

        public Criteria andStoresqcountNotEqualTo(Integer value) {
            addCriterion("storeSqCount <>", value, "storesqcount");
            return (Criteria) this;
        }

        public Criteria andStoresqcountGreaterThan(Integer value) {
            addCriterion("storeSqCount >", value, "storesqcount");
            return (Criteria) this;
        }

        public Criteria andStoresqcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("storeSqCount >=", value, "storesqcount");
            return (Criteria) this;
        }

        public Criteria andStoresqcountLessThan(Integer value) {
            addCriterion("storeSqCount <", value, "storesqcount");
            return (Criteria) this;
        }

        public Criteria andStoresqcountLessThanOrEqualTo(Integer value) {
            addCriterion("storeSqCount <=", value, "storesqcount");
            return (Criteria) this;
        }

        public Criteria andStoresqcountIn(List<Integer> values) {
            addCriterion("storeSqCount in", values, "storesqcount");
            return (Criteria) this;
        }

        public Criteria andStoresqcountNotIn(List<Integer> values) {
            addCriterion("storeSqCount not in", values, "storesqcount");
            return (Criteria) this;
        }

        public Criteria andStoresqcountBetween(Integer value1, Integer value2) {
            addCriterion("storeSqCount between", value1, value2, "storesqcount");
            return (Criteria) this;
        }

        public Criteria andStoresqcountNotBetween(Integer value1, Integer value2) {
            addCriterion("storeSqCount not between", value1, value2, "storesqcount");
            return (Criteria) this;
        }

        public Criteria andTotalordercountIsNull() {
            addCriterion("totalOrderCount is null");
            return (Criteria) this;
        }

        public Criteria andTotalordercountIsNotNull() {
            addCriterion("totalOrderCount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalordercountEqualTo(Integer value) {
            addCriterion("totalOrderCount =", value, "totalordercount");
            return (Criteria) this;
        }

        public Criteria andTotalordercountNotEqualTo(Integer value) {
            addCriterion("totalOrderCount <>", value, "totalordercount");
            return (Criteria) this;
        }

        public Criteria andTotalordercountGreaterThan(Integer value) {
            addCriterion("totalOrderCount >", value, "totalordercount");
            return (Criteria) this;
        }

        public Criteria andTotalordercountGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalOrderCount >=", value, "totalordercount");
            return (Criteria) this;
        }

        public Criteria andTotalordercountLessThan(Integer value) {
            addCriterion("totalOrderCount <", value, "totalordercount");
            return (Criteria) this;
        }

        public Criteria andTotalordercountLessThanOrEqualTo(Integer value) {
            addCriterion("totalOrderCount <=", value, "totalordercount");
            return (Criteria) this;
        }

        public Criteria andTotalordercountIn(List<Integer> values) {
            addCriterion("totalOrderCount in", values, "totalordercount");
            return (Criteria) this;
        }

        public Criteria andTotalordercountNotIn(List<Integer> values) {
            addCriterion("totalOrderCount not in", values, "totalordercount");
            return (Criteria) this;
        }

        public Criteria andTotalordercountBetween(Integer value1, Integer value2) {
            addCriterion("totalOrderCount between", value1, value2, "totalordercount");
            return (Criteria) this;
        }

        public Criteria andTotalordercountNotBetween(Integer value1, Integer value2) {
            addCriterion("totalOrderCount not between", value1, value2, "totalordercount");
            return (Criteria) this;
        }

        public Criteria andCancelordercountIsNull() {
            addCriterion("cancelOrderCount is null");
            return (Criteria) this;
        }

        public Criteria andCancelordercountIsNotNull() {
            addCriterion("cancelOrderCount is not null");
            return (Criteria) this;
        }

        public Criteria andCancelordercountEqualTo(Integer value) {
            addCriterion("cancelOrderCount =", value, "cancelordercount");
            return (Criteria) this;
        }

        public Criteria andCancelordercountNotEqualTo(Integer value) {
            addCriterion("cancelOrderCount <>", value, "cancelordercount");
            return (Criteria) this;
        }

        public Criteria andCancelordercountGreaterThan(Integer value) {
            addCriterion("cancelOrderCount >", value, "cancelordercount");
            return (Criteria) this;
        }

        public Criteria andCancelordercountGreaterThanOrEqualTo(Integer value) {
            addCriterion("cancelOrderCount >=", value, "cancelordercount");
            return (Criteria) this;
        }

        public Criteria andCancelordercountLessThan(Integer value) {
            addCriterion("cancelOrderCount <", value, "cancelordercount");
            return (Criteria) this;
        }

        public Criteria andCancelordercountLessThanOrEqualTo(Integer value) {
            addCriterion("cancelOrderCount <=", value, "cancelordercount");
            return (Criteria) this;
        }

        public Criteria andCancelordercountIn(List<Integer> values) {
            addCriterion("cancelOrderCount in", values, "cancelordercount");
            return (Criteria) this;
        }

        public Criteria andCancelordercountNotIn(List<Integer> values) {
            addCriterion("cancelOrderCount not in", values, "cancelordercount");
            return (Criteria) this;
        }

        public Criteria andCancelordercountBetween(Integer value1, Integer value2) {
            addCriterion("cancelOrderCount between", value1, value2, "cancelordercount");
            return (Criteria) this;
        }

        public Criteria andCancelordercountNotBetween(Integer value1, Integer value2) {
            addCriterion("cancelOrderCount not between", value1, value2, "cancelordercount");
            return (Criteria) this;
        }

        public Criteria andComplordercountIsNull() {
            addCriterion("complOrderCount is null");
            return (Criteria) this;
        }

        public Criteria andComplordercountIsNotNull() {
            addCriterion("complOrderCount is not null");
            return (Criteria) this;
        }

        public Criteria andComplordercountEqualTo(Integer value) {
            addCriterion("complOrderCount =", value, "complordercount");
            return (Criteria) this;
        }

        public Criteria andComplordercountNotEqualTo(Integer value) {
            addCriterion("complOrderCount <>", value, "complordercount");
            return (Criteria) this;
        }

        public Criteria andComplordercountGreaterThan(Integer value) {
            addCriterion("complOrderCount >", value, "complordercount");
            return (Criteria) this;
        }

        public Criteria andComplordercountGreaterThanOrEqualTo(Integer value) {
            addCriterion("complOrderCount >=", value, "complordercount");
            return (Criteria) this;
        }

        public Criteria andComplordercountLessThan(Integer value) {
            addCriterion("complOrderCount <", value, "complordercount");
            return (Criteria) this;
        }

        public Criteria andComplordercountLessThanOrEqualTo(Integer value) {
            addCriterion("complOrderCount <=", value, "complordercount");
            return (Criteria) this;
        }

        public Criteria andComplordercountIn(List<Integer> values) {
            addCriterion("complOrderCount in", values, "complordercount");
            return (Criteria) this;
        }

        public Criteria andComplordercountNotIn(List<Integer> values) {
            addCriterion("complOrderCount not in", values, "complordercount");
            return (Criteria) this;
        }

        public Criteria andComplordercountBetween(Integer value1, Integer value2) {
            addCriterion("complOrderCount between", value1, value2, "complordercount");
            return (Criteria) this;
        }

        public Criteria andComplordercountNotBetween(Integer value1, Integer value2) {
            addCriterion("complOrderCount not between", value1, value2, "complordercount");
            return (Criteria) this;
        }

        public Criteria andTotalamountIsNull() {
            addCriterion("totalAmount is null");
            return (Criteria) this;
        }

        public Criteria andTotalamountIsNotNull() {
            addCriterion("totalAmount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalamountEqualTo(Double value) {
            addCriterion("totalAmount =", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountNotEqualTo(Double value) {
            addCriterion("totalAmount <>", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountGreaterThan(Double value) {
            addCriterion("totalAmount >", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountGreaterThanOrEqualTo(Double value) {
            addCriterion("totalAmount >=", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountLessThan(Double value) {
            addCriterion("totalAmount <", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountLessThanOrEqualTo(Double value) {
            addCriterion("totalAmount <=", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountIn(List<Double> values) {
            addCriterion("totalAmount in", values, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountNotIn(List<Double> values) {
            addCriterion("totalAmount not in", values, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountBetween(Double value1, Double value2) {
            addCriterion("totalAmount between", value1, value2, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountNotBetween(Double value1, Double value2) {
            addCriterion("totalAmount not between", value1, value2, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
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