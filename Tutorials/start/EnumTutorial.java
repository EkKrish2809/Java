package start;

public enum EnumTutorial {
    RED("red"), GREEN("green"), BLUE("blue");

    private String value;

    EnumTutorial(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    
}
