package pojo;

import enums.Category;
import enums.Cities;

import javax.xml.stream.Location;
import java.util.ArrayList;

public class Child {
    private Integer id;
    private Integer age;
    private Double niceScore;
    private ArrayList<Double> niceScoreHistory = new ArrayList<>();
    private String lastName;
    private String firstName;
    private Cities city;
    private ArrayList<Category> preferences = new ArrayList<>();

    private Child(ChildBuilder builder) {
        this.id = builder.id;
        this.niceScore = builder.niceScore;
        this.preferences = builder.preferences;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.age = builder.age;
        this.city = builder.city;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Cities getCity() {
        return city;
    }

    public ArrayList<Category> getPreferences() {
        return preferences;
    }

    public static class ChildBuilder {
        private Integer id;
        private Integer age;
        private Double niceScore;
        private ArrayList<Double> niceScoreHistory = new ArrayList<>();
        private String lastName;
        private String firstName;
        private Cities city;
        private  ArrayList<Category> preferences = new ArrayList<>();

        public ChildBuilder(Integer id) {
            this.id = id;
        }

        public ChildBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ChildBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ChildBuilder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public ChildBuilder withCity(Cities city) {
            this.city = city;
            return this;
        }

        public ChildBuilder withNiceScore(Double niceScore) {
            this.niceScore = niceScore;
            return this;
        }

        public ChildBuilder withPreference(ArrayList<Category> preferences) {
            this.preferences = preferences;
            return this;
        }

        public Child build() {
            return new Child(this);
        }

    }
}
