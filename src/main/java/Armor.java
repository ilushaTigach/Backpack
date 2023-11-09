import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter

public class Armor extends Item {
    private int quality;

    public Armor(ClassItem classItem, String name, int size, int quality) {
        super(classItem, name, size);
        this.quality = quality;
    }



    public void setQuality(int qualitySize) throws Exception {

        if (qualitySize < 0 | qualitySize > 10) {
            throw new Exception();
        }
        quality = Randomizer.random() + qualitySize;
    }

    public String getQualityDescription() {
        Quality quality1;
        if (quality > 0 & quality < 4) {
            quality1 = Quality.SHIT;
        } else if (quality < 8) {
            quality1 = Quality.BAD;
        } else if (quality < 12) {
            quality1 = Quality.ORDINARY;
        } else if (quality < 17) {
            quality1 = Quality.RARE;
        } else {
            quality1 = Quality.EPIC;
        }
        return quality1.getDescription();
    }
}
