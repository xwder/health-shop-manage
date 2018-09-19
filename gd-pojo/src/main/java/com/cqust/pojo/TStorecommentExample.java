package com.cqust.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TStorecommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TStorecommentExample() {
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

        public Criteria andCommenttextIsNull() {
            addCriterion("commentText is null");
            return (Criteria) this;
        }

        public Criteria andCommenttextIsNotNull() {
            addCriterion("commentText is not null");
            return (Criteria) this;
        }

        public Criteria andCommenttextEqualTo(String value) {
            addCriterion("commentText =", value, "commenttext");
            return (Criteria) this;
        }

        public Criteria andCommenttextNotEqualTo(String value) {
            addCriterion("commentText <>", value, "commenttext");
            return (Criteria) this;
        }

        public Criteria andCommenttextGreaterThan(String value) {
            addCriterion("commentText >", value, "commenttext");
            return (Criteria) this;
        }

        public Criteria andCommenttextGreaterThanOrEqualTo(String value) {
            addCriterion("commentText >=", value, "commenttext");
            return (Criteria) this;
        }

        public Criteria andCommenttextLessThan(String value) {
            addCriterion("commentText <", value, "commenttext");
            return (Criteria) this;
        }

        public Criteria andCommenttextLessThanOrEqualTo(String value) {
            addCriterion("commentText <=", value, "commenttext");
            return (Criteria) this;
        }

        public Criteria andCommenttextLike(String value) {
            addCriterion("commentText like", value, "commenttext");
            return (Criteria) this;
        }

        public Criteria andCommenttextNotLike(String value) {
            addCriterion("commentText not like", value, "commenttext");
            return (Criteria) this;
        }

        public Criteria andCommenttextIn(List<String> values) {
            addCriterion("commentText in", values, "commenttext");
            return (Criteria) this;
        }

        public Criteria andCommenttextNotIn(List<String> values) {
            addCriterion("commentText not in", values, "commenttext");
            return (Criteria) this;
        }

        public Criteria andCommenttextBetween(String value1, String value2) {
            addCriterion("commentText between", value1, value2, "commenttext");
            return (Criteria) this;
        }

        public Criteria andCommenttextNotBetween(String value1, String value2) {
            addCriterion("commentText not between", value1, value2, "commenttext");
            return (Criteria) this;
        }

        public Criteria andCommentlevelIsNull() {
            addCriterion("commentLevel is null");
            return (Criteria) this;
        }

        public Criteria andCommentlevelIsNotNull() {
            addCriterion("commentLevel is not null");
            return (Criteria) this;
        }

        public Criteria andCommentlevelEqualTo(Integer value) {
            addCriterion("commentLevel =", value, "commentlevel");
            return (Criteria) this;
        }

        public Criteria andCommentlevelNotEqualTo(Integer value) {
            addCriterion("commentLevel <>", value, "commentlevel");
            return (Criteria) this;
        }

        public Criteria andCommentlevelGreaterThan(Integer value) {
            addCriterion("commentLevel >", value, "commentlevel");
            return (Criteria) this;
        }

        public Criteria andCommentlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentLevel >=", value, "commentlevel");
            return (Criteria) this;
        }

        public Criteria andCommentlevelLessThan(Integer value) {
            addCriterion("commentLevel <", value, "commentlevel");
            return (Criteria) this;
        }

        public Criteria andCommentlevelLessThanOrEqualTo(Integer value) {
            addCriterion("commentLevel <=", value, "commentlevel");
            return (Criteria) this;
        }

        public Criteria andCommentlevelIn(List<Integer> values) {
            addCriterion("commentLevel in", values, "commentlevel");
            return (Criteria) this;
        }

        public Criteria andCommentlevelNotIn(List<Integer> values) {
            addCriterion("commentLevel not in", values, "commentlevel");
            return (Criteria) this;
        }

        public Criteria andCommentlevelBetween(Integer value1, Integer value2) {
            addCriterion("commentLevel between", value1, value2, "commentlevel");
            return (Criteria) this;
        }

        public Criteria andCommentlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("commentLevel not between", value1, value2, "commentlevel");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIsNull() {
            addCriterion("commentTime is null");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIsNotNull() {
            addCriterion("commentTime is not null");
            return (Criteria) this;
        }

        public Criteria andCommenttimeEqualTo(Date value) {
            addCriterion("commentTime =", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotEqualTo(Date value) {
            addCriterion("commentTime <>", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeGreaterThan(Date value) {
            addCriterion("commentTime >", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("commentTime >=", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeLessThan(Date value) {
            addCriterion("commentTime <", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeLessThanOrEqualTo(Date value) {
            addCriterion("commentTime <=", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIn(List<Date> values) {
            addCriterion("commentTime in", values, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotIn(List<Date> values) {
            addCriterion("commentTime not in", values, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeBetween(Date value1, Date value2) {
            addCriterion("commentTime between", value1, value2, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotBetween(Date value1, Date value2) {
            addCriterion("commentTime not between", value1, value2, "commenttime");
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