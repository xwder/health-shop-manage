package com.cqust.pojo;

public class TFoodnutrition {
    private Integer id;

    private Integer foodid;

    private String eatpart;

    private String energy;

    private String watercontent;

    private String protein;

    private String fat;

    private String dietaryfiber;

    private String carbohydrate;

    private String vitaminsa;

    private String vitaminsb1;

    private String vitaminsb2;

    private String vitaminsc;

    private String vitaminse;

    private String niacin;

    private String na;

    private String calcium;

    private String iron;

    private String cholesterol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public String getEatpart() {
        return eatpart;
    }

    public void setEatpart(String eatpart) {
        this.eatpart = eatpart == null ? null : eatpart.trim();
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy == null ? null : energy.trim();
    }

    public String getWatercontent() {
        return watercontent;
    }

    public void setWatercontent(String watercontent) {
        this.watercontent = watercontent == null ? null : watercontent.trim();
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein == null ? null : protein.trim();
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat == null ? null : fat.trim();
    }

    public String getDietaryfiber() {
        return dietaryfiber;
    }

    public void setDietaryfiber(String dietaryfiber) {
        this.dietaryfiber = dietaryfiber == null ? null : dietaryfiber.trim();
    }

    public String getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(String carbohydrate) {
        this.carbohydrate = carbohydrate == null ? null : carbohydrate.trim();
    }

    public String getVitaminsa() {
        return vitaminsa;
    }

    public void setVitaminsa(String vitaminsa) {
        this.vitaminsa = vitaminsa == null ? null : vitaminsa.trim();
    }

    public String getVitaminsb1() {
        return vitaminsb1;
    }

    public void setVitaminsb1(String vitaminsb1) {
        this.vitaminsb1 = vitaminsb1 == null ? null : vitaminsb1.trim();
    }

    public String getVitaminsb2() {
        return vitaminsb2;
    }

    public void setVitaminsb2(String vitaminsb2) {
        this.vitaminsb2 = vitaminsb2 == null ? null : vitaminsb2.trim();
    }

    public String getVitaminsc() {
        return vitaminsc;
    }

    public void setVitaminsc(String vitaminsc) {
        this.vitaminsc = vitaminsc == null ? null : vitaminsc.trim();
    }

    public String getVitaminse() {
        return vitaminse;
    }

    public void setVitaminse(String vitaminse) {
        this.vitaminse = vitaminse == null ? null : vitaminse.trim();
    }

    public String getNiacin() {
        return niacin;
    }

    public void setNiacin(String niacin) {
        this.niacin = niacin == null ? null : niacin.trim();
    }

    public String getNa() {
        return na;
    }

    public void setNa(String na) {
        this.na = na == null ? null : na.trim();
    }

    public String getCalcium() {
        return calcium;
    }

    public void setCalcium(String calcium) {
        this.calcium = calcium == null ? null : calcium.trim();
    }

    public String getIron() {
        return iron;
    }

    public void setIron(String iron) {
        this.iron = iron == null ? null : iron.trim();
    }

    public String getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol == null ? null : cholesterol.trim();
    }
}