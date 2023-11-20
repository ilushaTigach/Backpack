import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class Armor extends Item {
    private Quality quality;//enum

    public Armor(ClassItem classItem, String name, int size, Quality quality) {
        super(classItem, name, size);
        this.quality = quality;
    }

    public void setQuality(int qualitySize) throws Exception {

        if (qualitySize < 0 | qualitySize > 10) {
            throw new Exception();
        }
        int randomQuality = Randomizer.random() + qualitySize;
        quality = determineQuality(randomQuality);
    }

    private Quality determineQuality(int value) {//switch case
        switch (value) {
            case 1:
            case 2:
            case 3:
                return Quality.SHIT;
            case 4:
            case 5:
            case 6:
            case 7:
                return Quality.BAD;
            case 8:
            case 9:
            case 10:
            case 11:
                return Quality.ORDINARY;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                return Quality.RARE;
            default:
                return Quality.EPIC;
        }
    }

    public Quality getQuality() {
        return quality;
    }

    public String getQualityDescription() {
        return quality.getDescription();
    }
}

