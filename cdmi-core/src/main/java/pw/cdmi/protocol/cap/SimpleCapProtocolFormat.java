package pw.cdmi.protocol.cap;

public abstract class SimpleCapProtocolFormat {
    private String pattern = "00-0-0-0000-000";

    public SimpleCapProtocolFormat(String pattern) {
        this.pattern = pattern;
    }

    public int length() {
        return this.pattern.replace("-","").length();
    }
}
