package model.enums;

/**
 * @author Tom
 */
public enum Color {
    BLACK("X"),
    WHITE("0");

    private final String stringRepresentation;

    public String getStringRepresentation()
    {
        return stringRepresentation;
    }

    private Color(String stringRepresentation)
    {
        this.stringRepresentation = stringRepresentation;
    }

}
