package com.cqust.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TZxbrowserecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TZxbrowserecordExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNull() {
            addCriterion("usertype is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("usertype is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(Integer value) {
            addCriterion("usertype =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(Integer value) {
            addCriterion("usertype <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(Integer value) {
            addCriterion("usertype >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("usertype >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(Integer value) {
            addCriterion("usertype <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(Integer value) {
            addCriterion("usertype <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<Integer> values) {
            addCriterion("usertype in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<Integer> values) {
            addCriterion("usertype not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(Integer value1, Integer value2) {
            addCriterion("usertype between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("usertype not between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andZxidIsNull() {
            addCriterion("zxid is null");
            return (Criteria) this;
        }

        public Criteria andZxidIsNotNull() {
            addCriterion("zxid is not null");
            return (Criteria) this;
        }

        public Criteria andZxidEqualTo(Integer value) {
            addCriterion("zxid =", value, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidNotEqualTo(Integer value) {
            addCriterion("zxid <>", value, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidGreaterThan(Integer value) {
            addCriterion("zxid >", value, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zxid >=", value, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidLessThan(Integer value) {
            addCriterion("zxid <", value, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidLessThanOrEqualTo(Integer value) {
            addCriterion("zxid <=", value, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidIn(List<Integer> values) {
            addCriterion("zxid in", values, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidNotIn(List<Integer> values) {
            addCriterion("zxid not in", values, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidBetween(Integer value1, Integer value2) {
            addCriterion("zxid between", value1, value2, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidNotBetween(Integer value1, Integer value2) {
            addCriterion("zxid not between", value1, value2, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxtitleIsNull() {
            addCriterion("zxtitle is null");
            return (Criteria) this;
        }

        public Criteria andZxtitleIsNotNull() {
            addCriterion("zxtitle is not null");
            return (Criteria) this;
        }

        public Criteria andZxtitleEqualTo(String value) {
            addCriterion("zxtitle =", value, "zxtitle");
            return (Criteria) this;
        }

        public Criteria andZxtitleNotEqualTo(String value) {
            addCriterion("zxtitle <>", value, "zxtitle");
            return (Criteria) this;
        }

        public Criteria andZxtitleGreaterThan(String value) {
            addCriterion("zxtitle >", value, "zxtitle");
            return (Criteria) this;
        }

        public Criteria andZxtitleGreaterThanOrEqualTo(String value) {
            addCriterion("zxtitle >=", value, "zxtitle");
            return (Criteria) this;
        }

        public Criteria andZxtitleLessThan(String value) {
            addCriterion("zxtitle <", value, "zxtitle");
            return (Criteria) this;
        }

        public Criteria andZxtitleLessThanOrEqualTo(String value) {
            addCriterion("zxtitle <=", value, "zxtitle");
            return (Criteria) this;
        }

        public Criteria andZxtitleLike(String value) {
            addCriterion("zxtitle like", value, "zxtitle");
            return (Criteria) this;
        }

        public Criteria andZxtitleNotLike(String value) {
            addCriterion("zxtitle not like", value, "zxtitle");
            return (Criteria) this;
        }

        public Criteria andZxtitleIn(List<String> values) {
            addCriterion("zxtitle in", values, "zxtitle");
            return (Criteria) this;
        }

        public Criteria andZxtitleNotIn(List<String> values) {
            addCriterion("zxtitle not in", values, "zxtitle");
            return (Criteria) this;
        }

        public Criteria andZxtitleBetween(String value1, String value2) {
            addCriterion("zxtitle between", value1, value2, "zxtitle");
            return (Criteria) this;
        }

        public Criteria andZxtitleNotBetween(String value1, String value2) {
            addCriterion("zxtitle not between", value1, value2, "zxtitle");
            return (Criteria) this;
        }

        public Criteria andBrowsetimeIsNull() {
            addCriterion("browsetime is null");
            return (Criteria) this;
        }

        public Criteria andBrowsetimeIsNotNull() {
            addCriterion("browsetime is not null");
            return (Criteria) this;
        }

        public Criteria andBrowsetimeEqualTo(Date value) {
            addCriterion("browsetime =", value, "browsetime");
            return (Criteria) this;
        }

        public Criteria andBrowsetimeNotEqualTo(Date value) {
            addCriterion("browsetime <>", value, "browsetime");
            return (Criteria) this;
        }

        public Criteria andBrowsetimeGreaterThan(Date value) {
            addCriterion("browsetime >", value, "browsetime");
            return (Criteria) this;
        }

        public Criteria andBrowsetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("browsetime >=", value, "browsetime");
            return (Criteria) this;
        }

        public Criteria andBrowsetimeLessThan(Date value) {
            addCriterion("browsetime <", value, "browsetime");
            return (Criteria) this;
        }

        public Criteria andBrowsetimeLessThanOrEqualTo(Date value) {
            addCriterion("browsetime <=", value, "browsetime");
            return (Criteria) this;
        }

        public Criteria andBrowsetimeIn(List<Date> values) {
            addCriterion("browsetime in", values, "browsetime");
            return (Criteria) this;
        }

        public Criteria andBrowsetimeNotIn(List<Date> values) {
            addCriterion("browsetime not in", values, "browsetime");
            return (Criteria) this;
        }

        public Criteria andBrowsetimeBetween(Date value1, Date value2) {
            addCriterion("browsetime between", value1, value2, "browsetime");
            return (Criteria) this;
        }

        public Criteria andBrowsetimeNotBetween(Date value1, Date value2) {
            addCriterion("browsetime not between", value1, value2, "browsetime");
            return (Criteria) this;
        }

        public Criteria andUseripIsNull() {
            addCriterion("userip is null");
            return (Criteria) this;
        }

        public Criteria andUseripIsNotNull() {
            addCriterion("userip is not null");
            return (Criteria) this;
        }

        public Criteria andUseripEqualTo(String value) {
            addCriterion("userip =", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotEqualTo(String value) {
            addCriterion("userip <>", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripGreaterThan(String value) {
            addCriterion("userip >", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripGreaterThanOrEqualTo(String value) {
            addCriterion("userip >=", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripLessThan(String value) {
            addCriterion("userip <", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripLessThanOrEqualTo(String value) {
            addCriterion("userip <=", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripLike(String value) {
            addCriterion("userip like", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotLike(String value) {
            addCriterion("userip not like", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripIn(List<String> values) {
            addCriterion("userip in", values, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotIn(List<String> values) {
            addCriterion("userip not in", values, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripBetween(String value1, String value2) {
            addCriterion("userip between", value1, value2, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotBetween(String value1, String value2) {
            addCriterion("userip not between", value1, value2, "userip");
            return (Criteria) this;
        }

        public Criteria andZxtypeIsNull() {
            addCriterion("zxtype is null");
            return (Criteria) this;
        }

        public Criteria andZxtypeIsNotNull() {
            addCriterion("zxtype is not null");
            return (Criteria) this;
        }

        public Criteria andZxtypeEqualTo(Integer value) {
            addCriterion("zxtype =", value, "zxtype");
            return (Criteria) this;
        }

        public Criteria andZxtypeNotEqualTo(Integer value) {
            addCriterion("zxtype <>", value, "zxtype");
            return (Criteria) this;
        }

        public Criteria andZxtypeGreaterThan(Integer value) {
            addCriterion("zxtype >", value, "zxtype");
            return (Criteria) this;
        }

        public Criteria andZxtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("zxtype >=", value, "zxtype");
            return (Criteria) this;
        }

        public Criteria andZxtypeLessThan(Integer value) {
            addCriterion("zxtype <", value, "zxtype");
            return (Criteria) this;
        }

        public Criteria andZxtypeLessThanOrEqualTo(Integer value) {
            addCriterion("zxtype <=", value, "zxtype");
            return (Criteria) this;
        }

        public Criteria andZxtypeIn(List<Integer> values) {
            addCriterion("zxtype in", values, "zxtype");
            return (Criteria) this;
        }

        public Criteria andZxtypeNotIn(List<Integer> values) {
            addCriterion("zxtype not in", values, "zxtype");
            return (Criteria) this;
        }

        public Criteria andZxtypeBetween(Integer value1, Integer value2) {
            addCriterion("zxtype between", value1, value2, "zxtype");
            return (Criteria) this;
        }

        public Criteria andZxtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("zxtype not between", value1, value2, "zxtype");
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