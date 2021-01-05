package pw.cdmi.core;

public class Option<T> {
    private String key;
    private T value;

    public Option(String key, T value){
        this.key = key;
        this.value = value;
    }
    public String getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

}
