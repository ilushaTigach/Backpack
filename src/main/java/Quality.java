public enum Quality {
    SHIT("Говно"), BAD("Плохо"), ORDINARY("Обычное"), RARE("Редкое"), EPIC("Эпическое");
    private String description;
    Quality(String description){
        this.description = description;
    }
    public String getDescription(){
        return  description;
    }
}