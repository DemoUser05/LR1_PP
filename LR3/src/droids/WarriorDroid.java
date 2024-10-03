package src.droids;

public class WarriorDroid extends Droid {

    public WarriorDroid(String name) {
        super(name, 120, 25, 10, 0.8, 0.2, 0);
    }

    @Override
    public void useSpecialAbility(Droid target) {
        System.out.println(name + " використовує спеціальну здатність: Вибуховий удар!");
        target.takeDamage(damage * 3);
        System.out.println(target.getName() + " отримує потрійний удар від " + name);
    }
}
