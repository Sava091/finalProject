package com.vitaliy.training.finalProject.model;

public class Client {
    private Long id;
    private String name;
    private String password;
    private int age;
    private double height;
    private double weight;
    private Activity activity;
    private Sex sex;
    private Long coefId;
    private Long clientMealId;

    public Client() {
    }

    public Client(Long id, String name, String password, int age, double height, double weight,
                  Activity activity, Sex sex, Long coefId, Long clientMealId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.activity = activity;
        this.sex = sex;
        this.coefId = coefId;
        this.clientMealId = clientMealId;
    }

    public Long getCoefId() {
        return coefId;
    }

    public void setCoefId(Long coefId) {
        this.coefId = coefId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Long getClientMealId() {
        return clientMealId;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClientMealId(Long clientMealId) {
        this.clientMealId = clientMealId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", activity=" + activity +
                ", sex=" + sex +
                ", coefId=" + coefId +
                ", clientMealId=" + clientMealId +
                '}';
    }
}
