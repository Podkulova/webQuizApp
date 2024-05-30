package engine.model;

public class Quiz {
    private String title;
    private String text;
    private String[] options;

    // Konstruktor
    public Quiz(String title, String text, String[] options) {
        this.title = title;
        this.text = text;
        this.options = options;
    }

    // Gettery
    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }
}
