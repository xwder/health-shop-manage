package com.cqust.pojo;

import java.util.ArrayList;
import java.util.List;

public class TSportsoptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSportsoptionExample() {
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

        public Criteria andSportnameIsNull() {
            addCriterion("sportname is null");
            return (Criteria) this;
        }

        public Criteria andSportnameIsNotNull() {
            addCriterion("sportname is not null");
            return (Criteria) this;
        }

        public Criteria andSportnameEqualTo(String value) {
            addCriterion("sportname =", value, "sportname");
            return (Criteria) this;
        }

        public Criteria andSportnameNotEqualTo(String value) {
            addCriterion("sportname <>", value, "sportname");
            return (Criteria) this;
        }

        public Criteria andSportnameGreaterThan(String value) {
            addCriterion("sportname >", value, "sportname");
            return (Criteria) this;
        }

        public Criteria andSportnameGreaterThanOrEqualTo(String value) {
            addCriterion("sportname >=", value, "sportname");
            return (Criteria) this;
        }

        public Criteria andSportnameLessThan(String value) {
            addCriterion("sportname <", value, "sportname");
            return (Criteria) this;
        }

        public Criteria andSportnameLessThanOrEqualTo(String value) {
            addCriterion("sportname <=", value, "sportname");
            return (Criteria) this;
        }

        public Criteria andSportnameLike(String value) {
            addCriterion("sportname like", value, "sportname");
            return (Criteria) this;
        }

        public Criteria andSportnameNotLike(String value) {
            addCriterion("sportname not like", value, "sportname");
            return (Criteria) this;
        }

        public Criteria andSportnameIn(List<String> values) {
            addCriterion("sportname in", values, "sportname");
            return (Criteria) this;
        }

        public Criteria andSportnameNotIn(List<String> values) {
            addCriterion("sportname not in", values, "sportname");
            return (Criteria) this;
        }

        public Criteria andSportnameBetween(String value1, String value2) {
            addCriterion("sportname between", value1, value2, "sportname");
            return (Criteria) this;
        }

        public Criteria andSportnameNotBetween(String value1, String value2) {
            addCriterion("sportname not between", value1, value2, "sportname");
            return (Criteria) this;
        }

        public Criteria andEnergyIsNull() {
            addCriterion("energy is null");
            return (Criteria) this;
        }

        public Criteria andEnergyIsNotNull() {
            addCriterion("energy is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyEqualTo(Double value) {
            addCriterion("energy =", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotEqualTo(Double value) {
            addCriterion("energy <>", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyGreaterThan(Double value) {
            addCriterion("energy >", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyGreaterThanOrEqualTo(Double value) {
            addCriterion("energy >=", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLessThan(Double value) {
            addCriterion("energy <", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLessThanOrEqualTo(Double value) {
            addCriterion("energy <=", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyIn(List<Double> values) {
            addCriterion("energy in", values, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotIn(List<Double> values) {
            addCriterion("energy not in", values, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyBetween(Double value1, Double value2) {
            addCriterion("energy between", value1, value2, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotBetween(Double value1, Double value2) {
            addCriterion("energy not between", value1, value2, "energy");
            return (Criteria) this;
        }

        public Criteria andSportdescribeIsNull() {
            addCriterion("sportdescribe is null");
            return (Criteria) this;
        }

        public Criteria andSportdescribeIsNotNull() {
            addCriterion("sportdescribe is not null");
            return (Criteria) this;
        }

        public Criteria andSportdescribeEqualTo(String value) {
            addCriterion("sportdescribe =", value, "sportdescribe");
            return (Criteria) this;
        }

        public Criteria andSportdescribeNotEqualTo(String value) {
            addCriterion("sportdescribe <>", value, "sportdescribe");
            return (Criteria) this;
        }

        public Criteria andSportdescribeGreaterThan(String value) {
            addCriterion("sportdescribe >", value, "sportdescribe");
            return (Criteria) this;
        }

        public Criteria andSportdescribeGreaterThanOrEqualTo(String value) {
            addCriterion("sportdescribe >=", value, "sportdescribe");
            return (Criteria) this;
        }

        public Criteria andSportdescribeLessThan(String value) {
            addCriterion("sportdescribe <", value, "sportdescribe");
            return (Criteria) this;
        }

        public Criteria andSportdescribeLessThanOrEqualTo(String value) {
            addCriterion("sportdescribe <=", value, "sportdescribe");
            return (Criteria) this;
        }

        public Criteria andSportdescribeLike(String value) {
            addCriterion("sportdescribe like", value, "sportdescribe");
            return (Criteria) this;
        }

        public Criteria andSportdescribeNotLike(String value) {
            addCriterion("sportdescribe not like", value, "sportdescribe");
            return (Criteria) this;
        }

        public Criteria andSportdescribeIn(List<String> values) {
            addCriterion("sportdescribe in", values, "sportdescribe");
            return (Criteria) this;
        }

        public Criteria andSportdescribeNotIn(List<String> values) {
            addCriterion("sportdescribe not in", values, "sportdescribe");
            return (Criteria) this;
        }

        public Criteria andSportdescribeBetween(String value1, String value2) {
            addCriterion("sportdescribe between", value1, value2, "sportdescribe");
            return (Criteria) this;
        }

        public Criteria andSportdescribeNotBetween(String value1, String value2) {
            addCriterion("sportdescribe not between", value1, value2, "sportdescribe");
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