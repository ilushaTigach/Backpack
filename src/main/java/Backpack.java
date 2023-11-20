import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private int sizeBackpack = 10;

    public List<Item> items = new ArrayList<>();

    public int freePlace() {
        int usedPlace = 0;
        for(Item item : items){
            usedPlace += item.getSize();
        }
        return  sizeBackpack - usedPlace;
    }

    public void addItemInBackpack(Item item){
        int itemSize = item.getSize();
        int renainingPlace = freePlace();
        if (itemSize <= renainingPlace){
            items.add(item);
            System.out.println("Предмет добавлен в рюкзак");
        } else {
            System.out.println("Недостаточно места в рюкзаке");
        }

    }
    public void removeItemsFromBackpack(Item item){
        items.clear();
        System.out.println("Рюкзак опусташён");
    }
    public void takeItemFromBackpack(){
        System.out.println("Содержимое рюкзака: ");
        for(Item item: items){
            System.out.println(item.getName());
        }
        System.out.println("Заполнение рюкзака: " + (sizeBackpack - freePlace()) + "/" + sizeBackpack);
    }
}
