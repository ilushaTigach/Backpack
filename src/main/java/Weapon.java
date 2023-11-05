public class Weapon extends Item {
    private int quality;

    public Weapon(String classItem, String name, int size, int quality) {
        super(classItem, name, size);
        this.quality = quality;
    }

    public Weapon() {
    }


    public void setQuality(int qualitySize) throws QualityException {

        if (qualitySize < 0) {
            throw new QualityException("Некорректное число");

        }
        quality = Randomizer.random + qualitySize;
    }

    public int getQuality() {
        return quality;
    }

    public String getQualityDescription() {
        Quality quality1;
        boolean a = quality > 0 & quality < 4;
        boolean b = quality < 8;
        boolean c = quality < 12;
        boolean d = quality < 17;
        if (a) {
            quality1 = Quality.SHIT;
        } else if (b) {
            quality1 = Quality.BAD;
        } else if (c) {
            quality1 = Quality.ORDINARY;
        } else if (d) {
            quality1 = Quality.RARE;
        } else {
            quality1 = Quality.EPIC;
        }
        return quality1.getDescription();
    }
}
