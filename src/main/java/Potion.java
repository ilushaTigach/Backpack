import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Potion extends Item {
    private PotionType potionType;//emum

    public Potion(ClassItem classItem, String name, int size, PotionType potionTypetype) {
        super(classItem, name, size);
        this.potionType = potionTypetype;
    }

    public void setType(PotionType potionType) {
        this.potionType = potionType;
    }

    public PotionType getPotionType() {
        return potionType;
    }

    public String getTypeDescription() {// switch case

        switch (potionType) {
            case HEALING:
                return PotionType.HEALING.getDescription();
            case DEFENSE:
                return PotionType.DEFENSE.getDescription();
            case DAMAGE:
                return PotionType.DAMAGE.getDescription();
            default:
                return "Неизвестный тип";
        }
    }
}
