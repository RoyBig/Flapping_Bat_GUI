package flapping_bat.model.enums;

public enum Colors {
    BLACK("#000000"),
    GREY("#808080"),
    WHITE("#FFFFFF"),
    INDYGO("#4B0082"),
    STATE_BLUE("#6A5ACD"),
    DARK("#271159"),
    PURPLE("#330066"),
    DARK_PURPLE("#330033"),
    ORANGE("#fca22b");

    private final String hex;

    Colors(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }
}

