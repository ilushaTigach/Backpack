public class Potion extends Item {
    private int type;
    public Potion(String classItem, String name, int size, int type) {
        super(classItem, name, size);
        this.type = type;
    }

    public Potion() {
    }

    public void setType(int typeSize) throws TypeException {

        if (typeSize < 0) {
            throw new TypeException("Некорректное число");

        }
        type =  typeSize;
    }

    public int getType() {
        return type;
    }

    public String getTypeDescription() {
        Type type1;
        boolean a = type == 1;
        boolean b = type == 2;
        boolean c = type == 3;
        if (a) {
            type1 = Type.HEALING;
        } else if (b) {
            type1 = Type.DEFENSE;
        } else {
            type1 = Type.DAMAGE;
        }
        return type1.getDescription();
    }
}
