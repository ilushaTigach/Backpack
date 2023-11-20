import lombok.Getter;

@Getter
public enum PotionType {

    HEALING("Лечение"), DEFENSE("Защита"), DAMAGE("Увеличение урона");

    private String description;

    PotionType(String description) {
        this.description = description;
    }


}
