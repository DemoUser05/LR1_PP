package src.droids;

public class MedicDroid extends Droid {

    public MedicDroid(String name) {
        super(name, 100, 15,  5, 0.9, 0.1, 20);
    }

    @Override
    public void useSpecialAbility(Droid ally) {
        System.out.println(name + " використовує спеціальну здатність: Лікування союзника!");
        ally.regenerate();
        System.out.println(ally.getName() + " відновлює здоров'я завдяки " + name);
    }
}
