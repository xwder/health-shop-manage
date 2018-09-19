package com.cqust.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TUserhealthinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserhealthinfoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Double value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Double value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Double value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Double value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Double value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Double value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Double> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Double> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Double value1, Double value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Double value1, Double value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Double value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Double value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Double value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Double value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Double value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Double> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Double> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Double value1, Double value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Double value1, Double value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andDietprefeIsNull() {
            addCriterion("dietPrefe is null");
            return (Criteria) this;
        }

        public Criteria andDietprefeIsNotNull() {
            addCriterion("dietPrefe is not null");
            return (Criteria) this;
        }

        public Criteria andDietprefeEqualTo(String value) {
            addCriterion("dietPrefe =", value, "dietprefe");
            return (Criteria) this;
        }

        public Criteria andDietprefeNotEqualTo(String value) {
            addCriterion("dietPrefe <>", value, "dietprefe");
            return (Criteria) this;
        }

        public Criteria andDietprefeGreaterThan(String value) {
            addCriterion("dietPrefe >", value, "dietprefe");
            return (Criteria) this;
        }

        public Criteria andDietprefeGreaterThanOrEqualTo(String value) {
            addCriterion("dietPrefe >=", value, "dietprefe");
            return (Criteria) this;
        }

        public Criteria andDietprefeLessThan(String value) {
            addCriterion("dietPrefe <", value, "dietprefe");
            return (Criteria) this;
        }

        public Criteria andDietprefeLessThanOrEqualTo(String value) {
            addCriterion("dietPrefe <=", value, "dietprefe");
            return (Criteria) this;
        }

        public Criteria andDietprefeLike(String value) {
            addCriterion("dietPrefe like", value, "dietprefe");
            return (Criteria) this;
        }

        public Criteria andDietprefeNotLike(String value) {
            addCriterion("dietPrefe not like", value, "dietprefe");
            return (Criteria) this;
        }

        public Criteria andDietprefeIn(List<String> values) {
            addCriterion("dietPrefe in", values, "dietprefe");
            return (Criteria) this;
        }

        public Criteria andDietprefeNotIn(List<String> values) {
            addCriterion("dietPrefe not in", values, "dietprefe");
            return (Criteria) this;
        }

        public Criteria andDietprefeBetween(String value1, String value2) {
            addCriterion("dietPrefe between", value1, value2, "dietprefe");
            return (Criteria) this;
        }

        public Criteria andDietprefeNotBetween(String value1, String value2) {
            addCriterion("dietPrefe not between", value1, value2, "dietprefe");
            return (Criteria) this;
        }

        public Criteria andNotlikefoodsIsNull() {
            addCriterion("notLikeFoods is null");
            return (Criteria) this;
        }

        public Criteria andNotlikefoodsIsNotNull() {
            addCriterion("notLikeFoods is not null");
            return (Criteria) this;
        }

        public Criteria andNotlikefoodsEqualTo(String value) {
            addCriterion("notLikeFoods =", value, "notlikefoods");
            return (Criteria) this;
        }

        public Criteria andNotlikefoodsNotEqualTo(String value) {
            addCriterion("notLikeFoods <>", value, "notlikefoods");
            return (Criteria) this;
        }

        public Criteria andNotlikefoodsGreaterThan(String value) {
            addCriterion("notLikeFoods >", value, "notlikefoods");
            return (Criteria) this;
        }

        public Criteria andNotlikefoodsGreaterThanOrEqualTo(String value) {
            addCriterion("notLikeFoods >=", value, "notlikefoods");
            return (Criteria) this;
        }

        public Criteria andNotlikefoodsLessThan(String value) {
            addCriterion("notLikeFoods <", value, "notlikefoods");
            return (Criteria) this;
        }

        public Criteria andNotlikefoodsLessThanOrEqualTo(String value) {
            addCriterion("notLikeFoods <=", value, "notlikefoods");
            return (Criteria) this;
        }

        public Criteria andNotlikefoodsLike(String value) {
            addCriterion("notLikeFoods like", value, "notlikefoods");
            return (Criteria) this;
        }

        public Criteria andNotlikefoodsNotLike(String value) {
            addCriterion("notLikeFoods not like", value, "notlikefoods");
            return (Criteria) this;
        }

        public Criteria andNotlikefoodsIn(List<String> values) {
            addCriterion("notLikeFoods in", values, "notlikefoods");
            return (Criteria) this;
        }

        public Criteria andNotlikefoodsNotIn(List<String> values) {
            addCriterion("notLikeFoods not in", values, "notlikefoods");
            return (Criteria) this;
        }

        public Criteria andNotlikefoodsBetween(String value1, String value2) {
            addCriterion("notLikeFoods between", value1, value2, "notlikefoods");
            return (Criteria) this;
        }

        public Criteria andNotlikefoodsNotBetween(String value1, String value2) {
            addCriterion("notLikeFoods not between", value1, value2, "notlikefoods");
            return (Criteria) this;
        }

        public Criteria andHealstatusIsNull() {
            addCriterion("healStatus is null");
            return (Criteria) this;
        }

        public Criteria andHealstatusIsNotNull() {
            addCriterion("healStatus is not null");
            return (Criteria) this;
        }

        public Criteria andHealstatusEqualTo(String value) {
            addCriterion("healStatus =", value, "healstatus");
            return (Criteria) this;
        }

        public Criteria andHealstatusNotEqualTo(String value) {
            addCriterion("healStatus <>", value, "healstatus");
            return (Criteria) this;
        }

        public Criteria andHealstatusGreaterThan(String value) {
            addCriterion("healStatus >", value, "healstatus");
            return (Criteria) this;
        }

        public Criteria andHealstatusGreaterThanOrEqualTo(String value) {
            addCriterion("healStatus >=", value, "healstatus");
            return (Criteria) this;
        }

        public Criteria andHealstatusLessThan(String value) {
            addCriterion("healStatus <", value, "healstatus");
            return (Criteria) this;
        }

        public Criteria andHealstatusLessThanOrEqualTo(String value) {
            addCriterion("healStatus <=", value, "healstatus");
            return (Criteria) this;
        }

        public Criteria andHealstatusLike(String value) {
            addCriterion("healStatus like", value, "healstatus");
            return (Criteria) this;
        }

        public Criteria andHealstatusNotLike(String value) {
            addCriterion("healStatus not like", value, "healstatus");
            return (Criteria) this;
        }

        public Criteria andHealstatusIn(List<String> values) {
            addCriterion("healStatus in", values, "healstatus");
            return (Criteria) this;
        }

        public Criteria andHealstatusNotIn(List<String> values) {
            addCriterion("healStatus not in", values, "healstatus");
            return (Criteria) this;
        }

        public Criteria andHealstatusBetween(String value1, String value2) {
            addCriterion("healStatus between", value1, value2, "healstatus");
            return (Criteria) this;
        }

        public Criteria andHealstatusNotBetween(String value1, String value2) {
            addCriterion("healStatus not between", value1, value2, "healstatus");
            return (Criteria) this;
        }

        public Criteria andMedhisIsNull() {
            addCriterion("medHis is null");
            return (Criteria) this;
        }

        public Criteria andMedhisIsNotNull() {
            addCriterion("medHis is not null");
            return (Criteria) this;
        }

        public Criteria andMedhisEqualTo(String value) {
            addCriterion("medHis =", value, "medhis");
            return (Criteria) this;
        }

        public Criteria andMedhisNotEqualTo(String value) {
            addCriterion("medHis <>", value, "medhis");
            return (Criteria) this;
        }

        public Criteria andMedhisGreaterThan(String value) {
            addCriterion("medHis >", value, "medhis");
            return (Criteria) this;
        }

        public Criteria andMedhisGreaterThanOrEqualTo(String value) {
            addCriterion("medHis >=", value, "medhis");
            return (Criteria) this;
        }

        public Criteria andMedhisLessThan(String value) {
            addCriterion("medHis <", value, "medhis");
            return (Criteria) this;
        }

        public Criteria andMedhisLessThanOrEqualTo(String value) {
            addCriterion("medHis <=", value, "medhis");
            return (Criteria) this;
        }

        public Criteria andMedhisLike(String value) {
            addCriterion("medHis like", value, "medhis");
            return (Criteria) this;
        }

        public Criteria andMedhisNotLike(String value) {
            addCriterion("medHis not like", value, "medhis");
            return (Criteria) this;
        }

        public Criteria andMedhisIn(List<String> values) {
            addCriterion("medHis in", values, "medhis");
            return (Criteria) this;
        }

        public Criteria andMedhisNotIn(List<String> values) {
            addCriterion("medHis not in", values, "medhis");
            return (Criteria) this;
        }

        public Criteria andMedhisBetween(String value1, String value2) {
            addCriterion("medHis between", value1, value2, "medhis");
            return (Criteria) this;
        }

        public Criteria andMedhisNotBetween(String value1, String value2) {
            addCriterion("medHis not between", value1, value2, "medhis");
            return (Criteria) this;
        }

        public Criteria andSenfoodsIsNull() {
            addCriterion("SenFoods is null");
            return (Criteria) this;
        }

        public Criteria andSenfoodsIsNotNull() {
            addCriterion("SenFoods is not null");
            return (Criteria) this;
        }

        public Criteria andSenfoodsEqualTo(String value) {
            addCriterion("SenFoods =", value, "senfoods");
            return (Criteria) this;
        }

        public Criteria andSenfoodsNotEqualTo(String value) {
            addCriterion("SenFoods <>", value, "senfoods");
            return (Criteria) this;
        }

        public Criteria andSenfoodsGreaterThan(String value) {
            addCriterion("SenFoods >", value, "senfoods");
            return (Criteria) this;
        }

        public Criteria andSenfoodsGreaterThanOrEqualTo(String value) {
            addCriterion("SenFoods >=", value, "senfoods");
            return (Criteria) this;
        }

        public Criteria andSenfoodsLessThan(String value) {
            addCriterion("SenFoods <", value, "senfoods");
            return (Criteria) this;
        }

        public Criteria andSenfoodsLessThanOrEqualTo(String value) {
            addCriterion("SenFoods <=", value, "senfoods");
            return (Criteria) this;
        }

        public Criteria andSenfoodsLike(String value) {
            addCriterion("SenFoods like", value, "senfoods");
            return (Criteria) this;
        }

        public Criteria andSenfoodsNotLike(String value) {
            addCriterion("SenFoods not like", value, "senfoods");
            return (Criteria) this;
        }

        public Criteria andSenfoodsIn(List<String> values) {
            addCriterion("SenFoods in", values, "senfoods");
            return (Criteria) this;
        }

        public Criteria andSenfoodsNotIn(List<String> values) {
            addCriterion("SenFoods not in", values, "senfoods");
            return (Criteria) this;
        }

        public Criteria andSenfoodsBetween(String value1, String value2) {
            addCriterion("SenFoods between", value1, value2, "senfoods");
            return (Criteria) this;
        }

        public Criteria andSenfoodsNotBetween(String value1, String value2) {
            addCriterion("SenFoods not between", value1, value2, "senfoods");
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