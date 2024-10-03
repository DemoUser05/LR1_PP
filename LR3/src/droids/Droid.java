package src.droids;

import java.util.Random;

public abstract class Droid {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int damage;

    protected int armor;
    protected double accuracy;
    protected double criticalChance;
    protected int regeneration;

    public Droid(String name, int health, int damage, int armor, double accuracy, double criticalChance, int regeneration) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.armor = armor;
        this.accuracy = accuracy;
        this.criticalChance = criticalChance;
        this.regeneration = regeneration;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    // Метод перевірки, чи дроїд живий
    public boolean isAlive() {
        return health > 0;
    }

    //Метод для отримання пошкоджень
    public void takeDamage(int incomingDamage) {
        int reducedDamage = incomingDamage - armor;
        if (reducedDamage < 0) reducedDamage = 0;
        health -= reducedDamage;
        if (health < 0) health = 0;
    }

    //Метод для регенерації здоров'я
    public void regenerate() {
        health += regeneration;
        if (health > maxHealth) {
            health = maxHealth;
        }
        System.out.println(name + " відновлює " + regeneration + " здоров'я.");
    }

    //Метод для атаки іншого дроїда
    public void attack(Droid target) {
        Random random = new Random();
        if (random.nextDouble() <= accuracy) {
            int attackDamage = damage;
            if (random.nextDouble() <= criticalChance) {
                attackDamage *= 2;
                System.out.println(name + " завдав критичного удару!");
            }
            target.takeDamage(attackDamage);
            System.out.println(name + " атакує " + target.getName() + " і наносить " + attackDamage + " шкоди.");
        } else {
            System.out.println(name + " промахнувся!");
        }
    }

    //метод для спеціальної здатності
    public abstract void useSpecialAbility(Droid target);
}
