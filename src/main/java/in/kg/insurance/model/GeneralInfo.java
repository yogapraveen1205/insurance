package in.kg.insurance.model;

public class GeneralInfo {

    private String name;
    private String gender;
    private int age;
    private CurrentHealth currentHealth;
    private Habits habits;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CurrentHealth getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(CurrentHealth currentHealth) {
        this.currentHealth = currentHealth;
    }

    public Habits getHabits() {
        return habits;
    }

    public void setHabits(Habits habits) {
        this.habits = habits;
    }
}
