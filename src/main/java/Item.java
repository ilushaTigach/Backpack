import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Item {
    private ClassItem classItem;
    private String name;
    private int size;


    public Item setClassItem(ClassItem classItem) throws Exception {
        this.classItem = classItem;
        return this;
    }

    public Item setName(String itemName) throws Exception {
        if (itemName.isEmpty()) {
            throw new Exception();
        } else {
            name = itemName;
        }
        return this;
    }

    public Item setSize(int itemSize) throws Exception {
        if ((itemSize >= 1) && (itemSize <= 10)) {
            size = itemSize;
        } else {
            throw new Exception();
        }
        return this;
    }
}
