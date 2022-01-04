package pojo;

import enums.Category;
import enums.Cities;

import java.util.ArrayList;

public class Child {
    private Integer id;
    private String lastName;
    private String firstName;
    private Cities city;
    private Integer age;
    private ArrayList<Category> giftsPreferences = new ArrayList<>();
    private Double averageScore;
    private ArrayList<Double> niceScoreHistory = new ArrayList<>();
    private Double assignedBudget;
    private ArrayList<Gift> receivedGifts = new ArrayList<>();

    public Child() { }

    private Child(ChildBuilder builder) {
        this.id = builder.id;
        this.averageScore = builder.avgNiceScore;
        this.giftsPreferences = builder.preferences;
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

    public Double getAverageScore() {
        return averageScore;
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

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setNiceScoreHistory(ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public void setGiftsPreferences(ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public void setAssignedBudget(Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public static class ChildBuilder {
        private Integer id;
        private Integer age;
        private Double avgNiceScore;
        private ArrayList<Double> niceScoreHistory = new ArrayList<>();
        private String lastName;
        private String firstName;
        private Cities city;
        private  ArrayList<Category> preferences = new ArrayList<>();
        private Double allocatedBudget;
        private ArrayList<Gift> receivedGifts = new ArrayList<>();

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
            this.avgNiceScore = niceScore;
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

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id + ", " + "\n" +
                "lastName='" + lastName + '\'' + ", " + "\n" +
                "firstName='" + firstName + '\'' + ", " + "\n" +
                "city=" + city + ", " + "\n" +
                "age=" + age + "\n" +
                "preferences=" + giftsPreferences + ", " + "\n" +
                "avgNiceScore=" + averageScore + ", " + "\n" +
                "niceScoreHistory=" + niceScoreHistory + ", " + "\n" +
                "allocatedBudget=" + assignedBudget + ", " + "\n" +
                "receivedGifts=" + receivedGifts + "\n" +
                '}';
    }
}
