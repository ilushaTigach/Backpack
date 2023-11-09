import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Potion extends Item {
    private Type type;//emum

    public Potion(ClassItem classItem, String name, int size, Type type) {
        super(classItem, name, size);
        this.type = type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public String getTypeDescription() {// switch case

        switch (type) {
            case HEALING:
                return Type.HEALING.getDescription();
            case DEFENSE:
                return Type.DEFENSE.getDescription();
            case DAMAGE:
                return Type.DAMAGE.getDescription();
            default:
                return "Неизвестный тип";

                // Уберу потом!
//        Type type1;
//        boolean a = type == 1;
//        boolean b = type == 2;
//        boolean c = type == 3;
//        if (a) {
//            type1 = Type.HEALING;
//        } else if (b) {
//            type1 = Type.DEFENSE;
//        } else {
//            type1 = Type.DAMAGE;
//        }
//        return type1.getDescription();
        }
    }
}
