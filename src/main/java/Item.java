public class Item {
    private String classItem;
    private String name;
    private int size;

    public Item(String classItem, String name, int size) {
        this.classItem = classItem;
        this.name = name;
        this.size = size;
    }

    public Item() {
    }

    public Item setClassItem(String classItem1) { // сделать через enam

        String weapon = new String("Weapon");
        String armor = new String("Armor");
        String potion = new String("Potion");
        boolean w = classItem1.equalsIgnoreCase(weapon);
        boolean a = classItem1.equalsIgnoreCase(armor);
        boolean p = classItem1.equalsIgnoreCase(potion);
        if (w == false & a == false & p == false) {
            System.out.println("Класс введён не верно");
            System.exit(0);
        } else {
            classItem = classItem1;
        }

        return this;
    }

    public Item setName(String itemName) {
        if (itemName.isEmpty()) {
            System.out.println("Название не введено");
            System.exit(0);
        } else {
            name = itemName;
        }
        return this;
    }

    public Item setSize(int itemSize) {
        if (itemSize < 0) {
            System.out.println("Размер не назначен");
            System.exit(0);
        } else {
            size = itemSize;
        }
        return this;
    }

    public String getClassItem() {
        return classItem;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }


}
