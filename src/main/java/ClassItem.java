import lombok.Getter;

@Getter
public enum ClassItem {
    WEAPON("Weapon"), ARMOR("Armor"), POTION("Potion");

    private String description;

    ClassItem(String description){
        this.description = description;
    }


}
