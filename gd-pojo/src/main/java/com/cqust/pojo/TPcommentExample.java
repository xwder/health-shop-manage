package com.cqust.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPcommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPcommentExample() {
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

        public Criteria andComtextIsNull() {
            addCriterion("comText is null");
            return (Criteria) this;
        }

        public Criteria andComtextIsNotNull() {
            addCriterion("comText is not null");
            return (Criteria) this;
        }

        public Criteria andComtextEqualTo(String value) {
            addCriterion("comText =", value, "comtext");
            return (Criteria) this;
        }

        public Criteria andComtextNotEqualTo(String value) {
            addCriterion("comText <>", value, "comtext");
            return (Criteria) this;
        }

        public Criteria andComtextGreaterThan(String value) {
            addCriterion("comText >", value, "comtext");
            return (Criteria) this;
        }

        public Criteria andComtextGreaterThanOrEqualTo(String value) {
            addCriterion("comText >=", value, "comtext");
            return (Criteria) this;
        }

        public Criteria andComtextLessThan(String value) {
            addCriterion("comText <", value, "comtext");
            return (Criteria) this;
        }

        public Criteria andComtextLessThanOrEqualTo(String value) {
            addCriterion("comText <=", value, "comtext");
            return (Criteria) this;
        }

        public Criteria andComtextLike(String value) {
            addCriterion("comText like", value, "comtext");
            return (Criteria) this;
        }

        public Criteria andComtextNotLike(String value) {
            addCriterion("comText not like", value, "comtext");
            return (Criteria) this;
        }

        public Criteria andComtextIn(List<String> values) {
            addCriterion("comText in", values, "comtext");
            return (Criteria) this;
        }

        public Criteria andComtextNotIn(List<String> values) {
            addCriterion("comText not in", values, "comtext");
            return (Criteria) this;
        }

        public Criteria andComtextBetween(String value1, String value2) {
            addCriterion("comText between", value1, value2, "comtext");
            return (Criteria) this;
        }

        public Criteria andComtextNotBetween(String value1, String value2) {
            addCriterion("comText not between", value1, value2, "comtext");
            return (Criteria) this;
        }

        public Criteria andComtypeIsNull() {
            addCriterion("comType is null");
            return (Criteria) this;
        }

        public Criteria andComtypeIsNotNull() {
            addCriterion("comType is not null");
            return (Criteria) this;
        }

        public Criteria andComtypeEqualTo(Integer value) {
            addCriterion("comType =", value, "comtype");
            return (Criteria) this;
        }

        public Criteria andComtypeNotEqualTo(Integer value) {
            addCriterion("comType <>", value, "comtype");
            return (Criteria) this;
        }

        public Criteria andComtypeGreaterThan(Integer value) {
            addCriterion("comType >", value, "comtype");
            return (Criteria) this;
        }

        public Criteria andComtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("comType >=", value, "comtype");
            return (Criteria) this;
        }

        public Criteria andComtypeLessThan(Integer value) {
            addCriterion("comType <", value, "comtype");
            return (Criteria) this;
        }

        public Criteria andComtypeLessThanOrEqualTo(Integer value) {
            addCriterion("comType <=", value, "comtype");
            return (Criteria) this;
        }

        public Criteria andComtypeIn(List<Integer> values) {
            addCriterion("comType in", values, "comtype");
            return (Criteria) this;
        }

        public Criteria andComtypeNotIn(List<Integer> values) {
            addCriterion("comType not in", values, "comtype");
            return (Criteria) this;
        }

        public Criteria andComtypeBetween(Integer value1, Integer value2) {
            addCriterion("comType between", value1, value2, "comtype");
            return (Criteria) this;
        }

        public Criteria andComtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("comType not between", value1, value2, "comtype");
            return (Criteria) this;
        }

        public Criteria andComlevelIsNull() {
            addCriterion("comLevel is null");
            return (Criteria) this;
        }

        public Criteria andComlevelIsNotNull() {
            addCriterion("comLevel is not null");
            return (Criteria) this;
        }

        public Criteria andComlevelEqualTo(Integer value) {
            addCriterion("comLevel =", value, "comlevel");
            return (Criteria) this;
        }

        public Criteria andComlevelNotEqualTo(Integer value) {
            addCriterion("comLevel <>", value, "comlevel");
            return (Criteria) this;
        }

        public Criteria andComlevelGreaterThan(Integer value) {
            addCriterion("comLevel >", value, "comlevel");
            return (Criteria) this;
        }

        public Criteria andComlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("comLevel >=", value, "comlevel");
            return (Criteria) this;
        }

        public Criteria andComlevelLessThan(Integer value) {
            addCriterion("comLevel <", value, "comlevel");
            return (Criteria) this;
        }

        public Criteria andComlevelLessThanOrEqualTo(Integer value) {
            addCriterion("comLevel <=", value, "comlevel");
            return (Criteria) this;
        }

        public Criteria andComlevelIn(List<Integer> values) {
            addCriterion("comLevel in", values, "comlevel");
            return (Criteria) this;
        }

        public Criteria andComlevelNotIn(List<Integer> values) {
            addCriterion("comLevel not in", values, "comlevel");
            return (Criteria) this;
        }

        public Criteria andComlevelBetween(Integer value1, Integer value2) {
            addCriterion("comLevel between", value1, value2, "comlevel");
            return (Criteria) this;
        }

        public Criteria andComlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("comLevel not between", value1, value2, "comlevel");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pId is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pId is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pId =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pId <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pId >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pId >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pId <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pId <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pId in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pId not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pId between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pId not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
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

        public Criteria andOrderitemidIsNull() {
            addCriterion("orderitemid is null");
            return (Criteria) this;
        }

        public Criteria andOrderitemidIsNotNull() {
            addCriterion("orderitemid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderitemidEqualTo(Integer value) {
            addCriterion("orderitemid =", value, "orderitemid");
            return (Criteria) this;
        }

        public Criteria andOrderitemidNotEqualTo(Integer value) {
            addCriterion("orderitemid <>", value, "orderitemid");
            return (Criteria) this;
        }

        public Criteria andOrderitemidGreaterThan(Integer value) {
            addCriterion("orderitemid >", value, "orderitemid");
            return (Criteria) this;
        }

        public Criteria andOrderitemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderitemid >=", value, "orderitemid");
            return (Criteria) this;
        }

        public Criteria andOrderitemidLessThan(Integer value) {
            addCriterion("orderitemid <", value, "orderitemid");
            return (Criteria) this;
        }

        public Criteria andOrderitemidLessThanOrEqualTo(Integer value) {
            addCriterion("orderitemid <=", value, "orderitemid");
            return (Criteria) this;
        }

        public Criteria andOrderitemidIn(List<Integer> values) {
            addCriterion("orderitemid in", values, "orderitemid");
            return (Criteria) this;
        }

        public Criteria andOrderitemidNotIn(List<Integer> values) {
            addCriterion("orderitemid not in", values, "orderitemid");
            return (Criteria) this;
        }

        public Criteria andOrderitemidBetween(Integer value1, Integer value2) {
            addCriterion("orderitemid between", value1, value2, "orderitemid");
            return (Criteria) this;
        }

        public Criteria andOrderitemidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderitemid not between", value1, value2, "orderitemid");
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