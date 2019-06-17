package com.vitaliy.training.finalProject.model;

public class Coefficient {
    private Long idСoefficient;
    private double coef0;
    private double coef1;
    private double coef2;
    private double coef3;
    private String sex;

    public Coefficient(Long idСoefficient, double coef0, double coef1, double coef2, double coef3, String sex) {
        this.idСoefficient = idСoefficient;
        this.coef0 = coef0;
        this.coef1 = coef1;
        this.coef2 = coef2;
        this.coef3 = coef3;
        this.sex = sex;
    }

    public Coefficient() {
    }

    public Long getIdСoefficient() {
        return idСoefficient;
    }

    public void setIdСoefficient(Long idСoefficient) {
        this.idСoefficient = idСoefficient;
    }

    public double getCoef0() {
        return coef0;
    }

    public void setCoef0(double coef0) {
        this.coef0 = coef0;
    }

    public double getCoef1() {
        return coef1;
    }

    public void setCoef1(double coef1) {
        this.coef1 = coef1;
    }

    public double getCoef2() {
        return coef2;
    }

    public void setCoef2(double coef2) {
        this.coef2 = coef2;
    }

    public double getCoef3() {
        return coef3;
    }

    public void setCoef3(double coef3) {
        this.coef3 = coef3;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Coefitients{" +
                "idСoefficient=" + idСoefficient +
                ", coef0=" + coef0 +
                ", coef1=" + coef1 +
                ", coef2=" + coef2 +
                ", coef3=" + coef3 +
                ", sex='" + sex + '\'' +
                '}';
    }
}
