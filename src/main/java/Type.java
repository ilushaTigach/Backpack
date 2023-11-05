public enum Type {

    HEALING("Лечение"), DEFENSE("Защита"), DAMAGE("Увеличение урона");
    private String description;
    Type(String description){
        this.description = description;
    }
    public String getDescription(){
        return  description;
    }
}
