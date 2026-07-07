public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    // a-z
    public boolean isLowercase() {
        return message.matches("[a-z]+");
    }

    // a-z && A-Z
    public boolean isLowercaseAndUppercase() {
        return message.matches("(?=.*[A-Z])(?=.*[a-z])[A-Za-z]+");
    }

    // a-z && A-Z && 0-9
    public boolean isLowercaseAndUppercaseAndNumber() {
        return message.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z0-9]+");
    }


}
