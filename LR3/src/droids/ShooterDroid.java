package src.droids;

public class ShooterDroid extends Droid {

    public ShooterDroid(String name) {
        super(name, 80, 35, 2, 0.95, 0.5, 5);
    }

    @Override
    public void useSpecialAbility(Droid target) {
        System.out.println(name + " використовує спеціальну здатність: Смертельний постріл!");
        target.takeDamage(damage * 4);
        System.out.println(target.getName() + " отримує смертельний постріл від " + name);
    }
}
