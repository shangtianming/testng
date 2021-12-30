package pojo;

import lombok.Data;

@Data
public class User {
    private int age;
    private int weight;
    private String home;

    public User() {
    }

    public User(int age, int weight, String home) {
        this.age = age;
        this.weight = weight;
        this.home = home;
    }
}
