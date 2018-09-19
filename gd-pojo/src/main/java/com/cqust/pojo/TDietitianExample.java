package com.cqust.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDietitianExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDietitianExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uID is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uID is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uID =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uID <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uID >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uID >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uID <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uID <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uID like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uID not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uID in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uID not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uID between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uID not between", value1, value2, "uid");
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

        public Criteria andDietlicenseIsNull() {
            addCriterion("dietLicense is null");
            return (Criteria) this;
        }

        public Criteria andDietlicenseIsNotNull() {
            addCriterion("dietLicense is not null");
            return (Criteria) this;
        }

        public Criteria andDietlicenseEqualTo(String value) {
            addCriterion("dietLicense =", value, "dietlicense");
            return (Criteria) this;
        }

        public Criteria andDietlicenseNotEqualTo(String value) {
            addCriterion("dietLicense <>", value, "dietlicense");
            return (Criteria) this;
        }

        public Criteria andDietlicenseGreaterThan(String value) {
            addCriterion("dietLicense >", value, "dietlicense");
            return (Criteria) this;
        }

        public Criteria andDietlicenseGreaterThanOrEqualTo(String value) {
            addCriterion("dietLicense >=", value, "dietlicense");
            return (Criteria) this;
        }

        public Criteria andDietlicenseLessThan(String value) {
            addCriterion("dietLicense <", value, "dietlicense");
            return (Criteria) this;
        }

        public Criteria andDietlicenseLessThanOrEqualTo(String value) {
            addCriterion("dietLicense <=", value, "dietlicense");
            return (Criteria) this;
        }

        public Criteria andDietlicenseLike(String value) {
            addCriterion("dietLicense like", value, "dietlicense");
            return (Criteria) this;
        }

        public Criteria andDietlicenseNotLike(String value) {
            addCriterion("dietLicense not like", value, "dietlicense");
            return (Criteria) this;
        }

        public Criteria andDietlicenseIn(List<String> values) {
            addCriterion("dietLicense in", values, "dietlicense");
            return (Criteria) this;
        }

        public Criteria andDietlicenseNotIn(List<String> values) {
            addCriterion("dietLicense not in", values, "dietlicense");
            return (Criteria) this;
        }

        public Criteria andDietlicenseBetween(String value1, String value2) {
            addCriterion("dietLicense between", value1, value2, "dietlicense");
            return (Criteria) this;
        }

        public Criteria andDietlicenseNotBetween(String value1, String value2) {
            addCriterion("dietLicense not between", value1, value2, "dietlicense");
            return (Criteria) this;
        }

        public Criteria andDietimageurlIsNull() {
            addCriterion("dietImageUrl is null");
            return (Criteria) this;
        }

        public Criteria andDietimageurlIsNotNull() {
            addCriterion("dietImageUrl is not null");
            return (Criteria) this;
        }

        public Criteria andDietimageurlEqualTo(String value) {
            addCriterion("dietImageUrl =", value, "dietimageurl");
            return (Criteria) this;
        }

        public Criteria andDietimageurlNotEqualTo(String value) {
            addCriterion("dietImageUrl <>", value, "dietimageurl");
            return (Criteria) this;
        }

        public Criteria andDietimageurlGreaterThan(String value) {
            addCriterion("dietImageUrl >", value, "dietimageurl");
            return (Criteria) this;
        }

        public Criteria andDietimageurlGreaterThanOrEqualTo(String value) {
            addCriterion("dietImageUrl >=", value, "dietimageurl");
            return (Criteria) this;
        }

        public Criteria andDietimageurlLessThan(String value) {
            addCriterion("dietImageUrl <", value, "dietimageurl");
            return (Criteria) this;
        }

        public Criteria andDietimageurlLessThanOrEqualTo(String value) {
            addCriterion("dietImageUrl <=", value, "dietimageurl");
            return (Criteria) this;
        }

        public Criteria andDietimageurlLike(String value) {
            addCriterion("dietImageUrl like", value, "dietimageurl");
            return (Criteria) this;
        }

        public Criteria andDietimageurlNotLike(String value) {
            addCriterion("dietImageUrl not like", value, "dietimageurl");
            return (Criteria) this;
        }

        public Criteria andDietimageurlIn(List<String> values) {
            addCriterion("dietImageUrl in", values, "dietimageurl");
            return (Criteria) this;
        }

        public Criteria andDietimageurlNotIn(List<String> values) {
            addCriterion("dietImageUrl not in", values, "dietimageurl");
            return (Criteria) this;
        }

        public Criteria andDietimageurlBetween(String value1, String value2) {
            addCriterion("dietImageUrl between", value1, value2, "dietimageurl");
            return (Criteria) this;
        }

        public Criteria andDietimageurlNotBetween(String value1, String value2) {
            addCriterion("dietImageUrl not between", value1, value2, "dietimageurl");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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