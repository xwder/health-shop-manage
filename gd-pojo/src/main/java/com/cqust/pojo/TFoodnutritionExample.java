package com.cqust.pojo;

import java.util.ArrayList;
import java.util.List;

public class TFoodnutritionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFoodnutritionExample() {
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

        public Criteria andFoodidIsNull() {
            addCriterion("foodid is null");
            return (Criteria) this;
        }

        public Criteria andFoodidIsNotNull() {
            addCriterion("foodid is not null");
            return (Criteria) this;
        }

        public Criteria andFoodidEqualTo(Integer value) {
            addCriterion("foodid =", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidNotEqualTo(Integer value) {
            addCriterion("foodid <>", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidGreaterThan(Integer value) {
            addCriterion("foodid >", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidGreaterThanOrEqualTo(Integer value) {
            addCriterion("foodid >=", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidLessThan(Integer value) {
            addCriterion("foodid <", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidLessThanOrEqualTo(Integer value) {
            addCriterion("foodid <=", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidIn(List<Integer> values) {
            addCriterion("foodid in", values, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidNotIn(List<Integer> values) {
            addCriterion("foodid not in", values, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidBetween(Integer value1, Integer value2) {
            addCriterion("foodid between", value1, value2, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidNotBetween(Integer value1, Integer value2) {
            addCriterion("foodid not between", value1, value2, "foodid");
            return (Criteria) this;
        }

        public Criteria andEatpartIsNull() {
            addCriterion("eatPart is null");
            return (Criteria) this;
        }

        public Criteria andEatpartIsNotNull() {
            addCriterion("eatPart is not null");
            return (Criteria) this;
        }

        public Criteria andEatpartEqualTo(String value) {
            addCriterion("eatPart =", value, "eatpart");
            return (Criteria) this;
        }

        public Criteria andEatpartNotEqualTo(String value) {
            addCriterion("eatPart <>", value, "eatpart");
            return (Criteria) this;
        }

        public Criteria andEatpartGreaterThan(String value) {
            addCriterion("eatPart >", value, "eatpart");
            return (Criteria) this;
        }

        public Criteria andEatpartGreaterThanOrEqualTo(String value) {
            addCriterion("eatPart >=", value, "eatpart");
            return (Criteria) this;
        }

        public Criteria andEatpartLessThan(String value) {
            addCriterion("eatPart <", value, "eatpart");
            return (Criteria) this;
        }

        public Criteria andEatpartLessThanOrEqualTo(String value) {
            addCriterion("eatPart <=", value, "eatpart");
            return (Criteria) this;
        }

        public Criteria andEatpartLike(String value) {
            addCriterion("eatPart like", value, "eatpart");
            return (Criteria) this;
        }

        public Criteria andEatpartNotLike(String value) {
            addCriterion("eatPart not like", value, "eatpart");
            return (Criteria) this;
        }

        public Criteria andEatpartIn(List<String> values) {
            addCriterion("eatPart in", values, "eatpart");
            return (Criteria) this;
        }

        public Criteria andEatpartNotIn(List<String> values) {
            addCriterion("eatPart not in", values, "eatpart");
            return (Criteria) this;
        }

        public Criteria andEatpartBetween(String value1, String value2) {
            addCriterion("eatPart between", value1, value2, "eatpart");
            return (Criteria) this;
        }

        public Criteria andEatpartNotBetween(String value1, String value2) {
            addCriterion("eatPart not between", value1, value2, "eatpart");
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

        public Criteria andEnergyEqualTo(String value) {
            addCriterion("energy =", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotEqualTo(String value) {
            addCriterion("energy <>", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyGreaterThan(String value) {
            addCriterion("energy >", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyGreaterThanOrEqualTo(String value) {
            addCriterion("energy >=", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLessThan(String value) {
            addCriterion("energy <", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLessThanOrEqualTo(String value) {
            addCriterion("energy <=", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLike(String value) {
            addCriterion("energy like", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotLike(String value) {
            addCriterion("energy not like", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyIn(List<String> values) {
            addCriterion("energy in", values, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotIn(List<String> values) {
            addCriterion("energy not in", values, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyBetween(String value1, String value2) {
            addCriterion("energy between", value1, value2, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotBetween(String value1, String value2) {
            addCriterion("energy not between", value1, value2, "energy");
            return (Criteria) this;
        }

        public Criteria andWatercontentIsNull() {
            addCriterion("waterContent is null");
            return (Criteria) this;
        }

        public Criteria andWatercontentIsNotNull() {
            addCriterion("waterContent is not null");
            return (Criteria) this;
        }

        public Criteria andWatercontentEqualTo(String value) {
            addCriterion("waterContent =", value, "watercontent");
            return (Criteria) this;
        }

        public Criteria andWatercontentNotEqualTo(String value) {
            addCriterion("waterContent <>", value, "watercontent");
            return (Criteria) this;
        }

        public Criteria andWatercontentGreaterThan(String value) {
            addCriterion("waterContent >", value, "watercontent");
            return (Criteria) this;
        }

        public Criteria andWatercontentGreaterThanOrEqualTo(String value) {
            addCriterion("waterContent >=", value, "watercontent");
            return (Criteria) this;
        }

        public Criteria andWatercontentLessThan(String value) {
            addCriterion("waterContent <", value, "watercontent");
            return (Criteria) this;
        }

        public Criteria andWatercontentLessThanOrEqualTo(String value) {
            addCriterion("waterContent <=", value, "watercontent");
            return (Criteria) this;
        }

        public Criteria andWatercontentLike(String value) {
            addCriterion("waterContent like", value, "watercontent");
            return (Criteria) this;
        }

        public Criteria andWatercontentNotLike(String value) {
            addCriterion("waterContent not like", value, "watercontent");
            return (Criteria) this;
        }

        public Criteria andWatercontentIn(List<String> values) {
            addCriterion("waterContent in", values, "watercontent");
            return (Criteria) this;
        }

        public Criteria andWatercontentNotIn(List<String> values) {
            addCriterion("waterContent not in", values, "watercontent");
            return (Criteria) this;
        }

        public Criteria andWatercontentBetween(String value1, String value2) {
            addCriterion("waterContent between", value1, value2, "watercontent");
            return (Criteria) this;
        }

        public Criteria andWatercontentNotBetween(String value1, String value2) {
            addCriterion("waterContent not between", value1, value2, "watercontent");
            return (Criteria) this;
        }

        public Criteria andProteinIsNull() {
            addCriterion("protein is null");
            return (Criteria) this;
        }

        public Criteria andProteinIsNotNull() {
            addCriterion("protein is not null");
            return (Criteria) this;
        }

        public Criteria andProteinEqualTo(String value) {
            addCriterion("protein =", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotEqualTo(String value) {
            addCriterion("protein <>", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinGreaterThan(String value) {
            addCriterion("protein >", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinGreaterThanOrEqualTo(String value) {
            addCriterion("protein >=", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinLessThan(String value) {
            addCriterion("protein <", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinLessThanOrEqualTo(String value) {
            addCriterion("protein <=", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinLike(String value) {
            addCriterion("protein like", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotLike(String value) {
            addCriterion("protein not like", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinIn(List<String> values) {
            addCriterion("protein in", values, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotIn(List<String> values) {
            addCriterion("protein not in", values, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinBetween(String value1, String value2) {
            addCriterion("protein between", value1, value2, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotBetween(String value1, String value2) {
            addCriterion("protein not between", value1, value2, "protein");
            return (Criteria) this;
        }

        public Criteria andFatIsNull() {
            addCriterion("fat is null");
            return (Criteria) this;
        }

        public Criteria andFatIsNotNull() {
            addCriterion("fat is not null");
            return (Criteria) this;
        }

        public Criteria andFatEqualTo(String value) {
            addCriterion("fat =", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotEqualTo(String value) {
            addCriterion("fat <>", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatGreaterThan(String value) {
            addCriterion("fat >", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatGreaterThanOrEqualTo(String value) {
            addCriterion("fat >=", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatLessThan(String value) {
            addCriterion("fat <", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatLessThanOrEqualTo(String value) {
            addCriterion("fat <=", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatLike(String value) {
            addCriterion("fat like", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotLike(String value) {
            addCriterion("fat not like", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatIn(List<String> values) {
            addCriterion("fat in", values, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotIn(List<String> values) {
            addCriterion("fat not in", values, "fat");
            return (Criteria) this;
        }

        public Criteria andFatBetween(String value1, String value2) {
            addCriterion("fat between", value1, value2, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotBetween(String value1, String value2) {
            addCriterion("fat not between", value1, value2, "fat");
            return (Criteria) this;
        }

        public Criteria andDietaryfiberIsNull() {
            addCriterion("dietaryFiber is null");
            return (Criteria) this;
        }

        public Criteria andDietaryfiberIsNotNull() {
            addCriterion("dietaryFiber is not null");
            return (Criteria) this;
        }

        public Criteria andDietaryfiberEqualTo(String value) {
            addCriterion("dietaryFiber =", value, "dietaryfiber");
            return (Criteria) this;
        }

        public Criteria andDietaryfiberNotEqualTo(String value) {
            addCriterion("dietaryFiber <>", value, "dietaryfiber");
            return (Criteria) this;
        }

        public Criteria andDietaryfiberGreaterThan(String value) {
            addCriterion("dietaryFiber >", value, "dietaryfiber");
            return (Criteria) this;
        }

        public Criteria andDietaryfiberGreaterThanOrEqualTo(String value) {
            addCriterion("dietaryFiber >=", value, "dietaryfiber");
            return (Criteria) this;
        }

        public Criteria andDietaryfiberLessThan(String value) {
            addCriterion("dietaryFiber <", value, "dietaryfiber");
            return (Criteria) this;
        }

        public Criteria andDietaryfiberLessThanOrEqualTo(String value) {
            addCriterion("dietaryFiber <=", value, "dietaryfiber");
            return (Criteria) this;
        }

        public Criteria andDietaryfiberLike(String value) {
            addCriterion("dietaryFiber like", value, "dietaryfiber");
            return (Criteria) this;
        }

        public Criteria andDietaryfiberNotLike(String value) {
            addCriterion("dietaryFiber not like", value, "dietaryfiber");
            return (Criteria) this;
        }

        public Criteria andDietaryfiberIn(List<String> values) {
            addCriterion("dietaryFiber in", values, "dietaryfiber");
            return (Criteria) this;
        }

        public Criteria andDietaryfiberNotIn(List<String> values) {
            addCriterion("dietaryFiber not in", values, "dietaryfiber");
            return (Criteria) this;
        }

        public Criteria andDietaryfiberBetween(String value1, String value2) {
            addCriterion("dietaryFiber between", value1, value2, "dietaryfiber");
            return (Criteria) this;
        }

        public Criteria andDietaryfiberNotBetween(String value1, String value2) {
            addCriterion("dietaryFiber not between", value1, value2, "dietaryfiber");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateIsNull() {
            addCriterion("carbohydrate is null");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateIsNotNull() {
            addCriterion("carbohydrate is not null");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateEqualTo(String value) {
            addCriterion("carbohydrate =", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNotEqualTo(String value) {
            addCriterion("carbohydrate <>", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateGreaterThan(String value) {
            addCriterion("carbohydrate >", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateGreaterThanOrEqualTo(String value) {
            addCriterion("carbohydrate >=", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateLessThan(String value) {
            addCriterion("carbohydrate <", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateLessThanOrEqualTo(String value) {
            addCriterion("carbohydrate <=", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateLike(String value) {
            addCriterion("carbohydrate like", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNotLike(String value) {
            addCriterion("carbohydrate not like", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateIn(List<String> values) {
            addCriterion("carbohydrate in", values, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNotIn(List<String> values) {
            addCriterion("carbohydrate not in", values, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateBetween(String value1, String value2) {
            addCriterion("carbohydrate between", value1, value2, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNotBetween(String value1, String value2) {
            addCriterion("carbohydrate not between", value1, value2, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andVitaminsaIsNull() {
            addCriterion("vitaminsA is null");
            return (Criteria) this;
        }

        public Criteria andVitaminsaIsNotNull() {
            addCriterion("vitaminsA is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminsaEqualTo(String value) {
            addCriterion("vitaminsA =", value, "vitaminsa");
            return (Criteria) this;
        }

        public Criteria andVitaminsaNotEqualTo(String value) {
            addCriterion("vitaminsA <>", value, "vitaminsa");
            return (Criteria) this;
        }

        public Criteria andVitaminsaGreaterThan(String value) {
            addCriterion("vitaminsA >", value, "vitaminsa");
            return (Criteria) this;
        }

        public Criteria andVitaminsaGreaterThanOrEqualTo(String value) {
            addCriterion("vitaminsA >=", value, "vitaminsa");
            return (Criteria) this;
        }

        public Criteria andVitaminsaLessThan(String value) {
            addCriterion("vitaminsA <", value, "vitaminsa");
            return (Criteria) this;
        }

        public Criteria andVitaminsaLessThanOrEqualTo(String value) {
            addCriterion("vitaminsA <=", value, "vitaminsa");
            return (Criteria) this;
        }

        public Criteria andVitaminsaLike(String value) {
            addCriterion("vitaminsA like", value, "vitaminsa");
            return (Criteria) this;
        }

        public Criteria andVitaminsaNotLike(String value) {
            addCriterion("vitaminsA not like", value, "vitaminsa");
            return (Criteria) this;
        }

        public Criteria andVitaminsaIn(List<String> values) {
            addCriterion("vitaminsA in", values, "vitaminsa");
            return (Criteria) this;
        }

        public Criteria andVitaminsaNotIn(List<String> values) {
            addCriterion("vitaminsA not in", values, "vitaminsa");
            return (Criteria) this;
        }

        public Criteria andVitaminsaBetween(String value1, String value2) {
            addCriterion("vitaminsA between", value1, value2, "vitaminsa");
            return (Criteria) this;
        }

        public Criteria andVitaminsaNotBetween(String value1, String value2) {
            addCriterion("vitaminsA not between", value1, value2, "vitaminsa");
            return (Criteria) this;
        }

        public Criteria andVitaminsb1IsNull() {
            addCriterion("vitaminsB1 is null");
            return (Criteria) this;
        }

        public Criteria andVitaminsb1IsNotNull() {
            addCriterion("vitaminsB1 is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminsb1EqualTo(String value) {
            addCriterion("vitaminsB1 =", value, "vitaminsb1");
            return (Criteria) this;
        }

        public Criteria andVitaminsb1NotEqualTo(String value) {
            addCriterion("vitaminsB1 <>", value, "vitaminsb1");
            return (Criteria) this;
        }

        public Criteria andVitaminsb1GreaterThan(String value) {
            addCriterion("vitaminsB1 >", value, "vitaminsb1");
            return (Criteria) this;
        }

        public Criteria andVitaminsb1GreaterThanOrEqualTo(String value) {
            addCriterion("vitaminsB1 >=", value, "vitaminsb1");
            return (Criteria) this;
        }

        public Criteria andVitaminsb1LessThan(String value) {
            addCriterion("vitaminsB1 <", value, "vitaminsb1");
            return (Criteria) this;
        }

        public Criteria andVitaminsb1LessThanOrEqualTo(String value) {
            addCriterion("vitaminsB1 <=", value, "vitaminsb1");
            return (Criteria) this;
        }

        public Criteria andVitaminsb1Like(String value) {
            addCriterion("vitaminsB1 like", value, "vitaminsb1");
            return (Criteria) this;
        }

        public Criteria andVitaminsb1NotLike(String value) {
            addCriterion("vitaminsB1 not like", value, "vitaminsb1");
            return (Criteria) this;
        }

        public Criteria andVitaminsb1In(List<String> values) {
            addCriterion("vitaminsB1 in", values, "vitaminsb1");
            return (Criteria) this;
        }

        public Criteria andVitaminsb1NotIn(List<String> values) {
            addCriterion("vitaminsB1 not in", values, "vitaminsb1");
            return (Criteria) this;
        }

        public Criteria andVitaminsb1Between(String value1, String value2) {
            addCriterion("vitaminsB1 between", value1, value2, "vitaminsb1");
            return (Criteria) this;
        }

        public Criteria andVitaminsb1NotBetween(String value1, String value2) {
            addCriterion("vitaminsB1 not between", value1, value2, "vitaminsb1");
            return (Criteria) this;
        }

        public Criteria andVitaminsb2IsNull() {
            addCriterion("vitaminsB2 is null");
            return (Criteria) this;
        }

        public Criteria andVitaminsb2IsNotNull() {
            addCriterion("vitaminsB2 is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminsb2EqualTo(String value) {
            addCriterion("vitaminsB2 =", value, "vitaminsb2");
            return (Criteria) this;
        }

        public Criteria andVitaminsb2NotEqualTo(String value) {
            addCriterion("vitaminsB2 <>", value, "vitaminsb2");
            return (Criteria) this;
        }

        public Criteria andVitaminsb2GreaterThan(String value) {
            addCriterion("vitaminsB2 >", value, "vitaminsb2");
            return (Criteria) this;
        }

        public Criteria andVitaminsb2GreaterThanOrEqualTo(String value) {
            addCriterion("vitaminsB2 >=", value, "vitaminsb2");
            return (Criteria) this;
        }

        public Criteria andVitaminsb2LessThan(String value) {
            addCriterion("vitaminsB2 <", value, "vitaminsb2");
            return (Criteria) this;
        }

        public Criteria andVitaminsb2LessThanOrEqualTo(String value) {
            addCriterion("vitaminsB2 <=", value, "vitaminsb2");
            return (Criteria) this;
        }

        public Criteria andVitaminsb2Like(String value) {
            addCriterion("vitaminsB2 like", value, "vitaminsb2");
            return (Criteria) this;
        }

        public Criteria andVitaminsb2NotLike(String value) {
            addCriterion("vitaminsB2 not like", value, "vitaminsb2");
            return (Criteria) this;
        }

        public Criteria andVitaminsb2In(List<String> values) {
            addCriterion("vitaminsB2 in", values, "vitaminsb2");
            return (Criteria) this;
        }

        public Criteria andVitaminsb2NotIn(List<String> values) {
            addCriterion("vitaminsB2 not in", values, "vitaminsb2");
            return (Criteria) this;
        }

        public Criteria andVitaminsb2Between(String value1, String value2) {
            addCriterion("vitaminsB2 between", value1, value2, "vitaminsb2");
            return (Criteria) this;
        }

        public Criteria andVitaminsb2NotBetween(String value1, String value2) {
            addCriterion("vitaminsB2 not between", value1, value2, "vitaminsb2");
            return (Criteria) this;
        }

        public Criteria andVitaminscIsNull() {
            addCriterion("vitaminsC is null");
            return (Criteria) this;
        }

        public Criteria andVitaminscIsNotNull() {
            addCriterion("vitaminsC is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminscEqualTo(String value) {
            addCriterion("vitaminsC =", value, "vitaminsc");
            return (Criteria) this;
        }

        public Criteria andVitaminscNotEqualTo(String value) {
            addCriterion("vitaminsC <>", value, "vitaminsc");
            return (Criteria) this;
        }

        public Criteria andVitaminscGreaterThan(String value) {
            addCriterion("vitaminsC >", value, "vitaminsc");
            return (Criteria) this;
        }

        public Criteria andVitaminscGreaterThanOrEqualTo(String value) {
            addCriterion("vitaminsC >=", value, "vitaminsc");
            return (Criteria) this;
        }

        public Criteria andVitaminscLessThan(String value) {
            addCriterion("vitaminsC <", value, "vitaminsc");
            return (Criteria) this;
        }

        public Criteria andVitaminscLessThanOrEqualTo(String value) {
            addCriterion("vitaminsC <=", value, "vitaminsc");
            return (Criteria) this;
        }

        public Criteria andVitaminscLike(String value) {
            addCriterion("vitaminsC like", value, "vitaminsc");
            return (Criteria) this;
        }

        public Criteria andVitaminscNotLike(String value) {
            addCriterion("vitaminsC not like", value, "vitaminsc");
            return (Criteria) this;
        }

        public Criteria andVitaminscIn(List<String> values) {
            addCriterion("vitaminsC in", values, "vitaminsc");
            return (Criteria) this;
        }

        public Criteria andVitaminscNotIn(List<String> values) {
            addCriterion("vitaminsC not in", values, "vitaminsc");
            return (Criteria) this;
        }

        public Criteria andVitaminscBetween(String value1, String value2) {
            addCriterion("vitaminsC between", value1, value2, "vitaminsc");
            return (Criteria) this;
        }

        public Criteria andVitaminscNotBetween(String value1, String value2) {
            addCriterion("vitaminsC not between", value1, value2, "vitaminsc");
            return (Criteria) this;
        }

        public Criteria andVitaminseIsNull() {
            addCriterion("vitaminsE is null");
            return (Criteria) this;
        }

        public Criteria andVitaminseIsNotNull() {
            addCriterion("vitaminsE is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminseEqualTo(String value) {
            addCriterion("vitaminsE =", value, "vitaminse");
            return (Criteria) this;
        }

        public Criteria andVitaminseNotEqualTo(String value) {
            addCriterion("vitaminsE <>", value, "vitaminse");
            return (Criteria) this;
        }

        public Criteria andVitaminseGreaterThan(String value) {
            addCriterion("vitaminsE >", value, "vitaminse");
            return (Criteria) this;
        }

        public Criteria andVitaminseGreaterThanOrEqualTo(String value) {
            addCriterion("vitaminsE >=", value, "vitaminse");
            return (Criteria) this;
        }

        public Criteria andVitaminseLessThan(String value) {
            addCriterion("vitaminsE <", value, "vitaminse");
            return (Criteria) this;
        }

        public Criteria andVitaminseLessThanOrEqualTo(String value) {
            addCriterion("vitaminsE <=", value, "vitaminse");
            return (Criteria) this;
        }

        public Criteria andVitaminseLike(String value) {
            addCriterion("vitaminsE like", value, "vitaminse");
            return (Criteria) this;
        }

        public Criteria andVitaminseNotLike(String value) {
            addCriterion("vitaminsE not like", value, "vitaminse");
            return (Criteria) this;
        }

        public Criteria andVitaminseIn(List<String> values) {
            addCriterion("vitaminsE in", values, "vitaminse");
            return (Criteria) this;
        }

        public Criteria andVitaminseNotIn(List<String> values) {
            addCriterion("vitaminsE not in", values, "vitaminse");
            return (Criteria) this;
        }

        public Criteria andVitaminseBetween(String value1, String value2) {
            addCriterion("vitaminsE between", value1, value2, "vitaminse");
            return (Criteria) this;
        }

        public Criteria andVitaminseNotBetween(String value1, String value2) {
            addCriterion("vitaminsE not between", value1, value2, "vitaminse");
            return (Criteria) this;
        }

        public Criteria andNiacinIsNull() {
            addCriterion("niacin is null");
            return (Criteria) this;
        }

        public Criteria andNiacinIsNotNull() {
            addCriterion("niacin is not null");
            return (Criteria) this;
        }

        public Criteria andNiacinEqualTo(String value) {
            addCriterion("niacin =", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinNotEqualTo(String value) {
            addCriterion("niacin <>", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinGreaterThan(String value) {
            addCriterion("niacin >", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinGreaterThanOrEqualTo(String value) {
            addCriterion("niacin >=", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinLessThan(String value) {
            addCriterion("niacin <", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinLessThanOrEqualTo(String value) {
            addCriterion("niacin <=", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinLike(String value) {
            addCriterion("niacin like", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinNotLike(String value) {
            addCriterion("niacin not like", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinIn(List<String> values) {
            addCriterion("niacin in", values, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinNotIn(List<String> values) {
            addCriterion("niacin not in", values, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinBetween(String value1, String value2) {
            addCriterion("niacin between", value1, value2, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinNotBetween(String value1, String value2) {
            addCriterion("niacin not between", value1, value2, "niacin");
            return (Criteria) this;
        }

        public Criteria andNaIsNull() {
            addCriterion("na is null");
            return (Criteria) this;
        }

        public Criteria andNaIsNotNull() {
            addCriterion("na is not null");
            return (Criteria) this;
        }

        public Criteria andNaEqualTo(String value) {
            addCriterion("na =", value, "na");
            return (Criteria) this;
        }

        public Criteria andNaNotEqualTo(String value) {
            addCriterion("na <>", value, "na");
            return (Criteria) this;
        }

        public Criteria andNaGreaterThan(String value) {
            addCriterion("na >", value, "na");
            return (Criteria) this;
        }

        public Criteria andNaGreaterThanOrEqualTo(String value) {
            addCriterion("na >=", value, "na");
            return (Criteria) this;
        }

        public Criteria andNaLessThan(String value) {
            addCriterion("na <", value, "na");
            return (Criteria) this;
        }

        public Criteria andNaLessThanOrEqualTo(String value) {
            addCriterion("na <=", value, "na");
            return (Criteria) this;
        }

        public Criteria andNaLike(String value) {
            addCriterion("na like", value, "na");
            return (Criteria) this;
        }

        public Criteria andNaNotLike(String value) {
            addCriterion("na not like", value, "na");
            return (Criteria) this;
        }

        public Criteria andNaIn(List<String> values) {
            addCriterion("na in", values, "na");
            return (Criteria) this;
        }

        public Criteria andNaNotIn(List<String> values) {
            addCriterion("na not in", values, "na");
            return (Criteria) this;
        }

        public Criteria andNaBetween(String value1, String value2) {
            addCriterion("na between", value1, value2, "na");
            return (Criteria) this;
        }

        public Criteria andNaNotBetween(String value1, String value2) {
            addCriterion("na not between", value1, value2, "na");
            return (Criteria) this;
        }

        public Criteria andCalciumIsNull() {
            addCriterion("calcium is null");
            return (Criteria) this;
        }

        public Criteria andCalciumIsNotNull() {
            addCriterion("calcium is not null");
            return (Criteria) this;
        }

        public Criteria andCalciumEqualTo(String value) {
            addCriterion("calcium =", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumNotEqualTo(String value) {
            addCriterion("calcium <>", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumGreaterThan(String value) {
            addCriterion("calcium >", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumGreaterThanOrEqualTo(String value) {
            addCriterion("calcium >=", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumLessThan(String value) {
            addCriterion("calcium <", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumLessThanOrEqualTo(String value) {
            addCriterion("calcium <=", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumLike(String value) {
            addCriterion("calcium like", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumNotLike(String value) {
            addCriterion("calcium not like", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumIn(List<String> values) {
            addCriterion("calcium in", values, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumNotIn(List<String> values) {
            addCriterion("calcium not in", values, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumBetween(String value1, String value2) {
            addCriterion("calcium between", value1, value2, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumNotBetween(String value1, String value2) {
            addCriterion("calcium not between", value1, value2, "calcium");
            return (Criteria) this;
        }

        public Criteria andIronIsNull() {
            addCriterion("iron is null");
            return (Criteria) this;
        }

        public Criteria andIronIsNotNull() {
            addCriterion("iron is not null");
            return (Criteria) this;
        }

        public Criteria andIronEqualTo(String value) {
            addCriterion("iron =", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronNotEqualTo(String value) {
            addCriterion("iron <>", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronGreaterThan(String value) {
            addCriterion("iron >", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronGreaterThanOrEqualTo(String value) {
            addCriterion("iron >=", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronLessThan(String value) {
            addCriterion("iron <", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronLessThanOrEqualTo(String value) {
            addCriterion("iron <=", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronLike(String value) {
            addCriterion("iron like", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronNotLike(String value) {
            addCriterion("iron not like", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronIn(List<String> values) {
            addCriterion("iron in", values, "iron");
            return (Criteria) this;
        }

        public Criteria andIronNotIn(List<String> values) {
            addCriterion("iron not in", values, "iron");
            return (Criteria) this;
        }

        public Criteria andIronBetween(String value1, String value2) {
            addCriterion("iron between", value1, value2, "iron");
            return (Criteria) this;
        }

        public Criteria andIronNotBetween(String value1, String value2) {
            addCriterion("iron not between", value1, value2, "iron");
            return (Criteria) this;
        }

        public Criteria andCholesterolIsNull() {
            addCriterion("cholesterol is null");
            return (Criteria) this;
        }

        public Criteria andCholesterolIsNotNull() {
            addCriterion("cholesterol is not null");
            return (Criteria) this;
        }

        public Criteria andCholesterolEqualTo(String value) {
            addCriterion("cholesterol =", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolNotEqualTo(String value) {
            addCriterion("cholesterol <>", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolGreaterThan(String value) {
            addCriterion("cholesterol >", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolGreaterThanOrEqualTo(String value) {
            addCriterion("cholesterol >=", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolLessThan(String value) {
            addCriterion("cholesterol <", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolLessThanOrEqualTo(String value) {
            addCriterion("cholesterol <=", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolLike(String value) {
            addCriterion("cholesterol like", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolNotLike(String value) {
            addCriterion("cholesterol not like", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolIn(List<String> values) {
            addCriterion("cholesterol in", values, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolNotIn(List<String> values) {
            addCriterion("cholesterol not in", values, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolBetween(String value1, String value2) {
            addCriterion("cholesterol between", value1, value2, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolNotBetween(String value1, String value2) {
            addCriterion("cholesterol not between", value1, value2, "cholesterol");
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