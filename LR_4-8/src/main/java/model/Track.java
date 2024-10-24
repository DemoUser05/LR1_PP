package model;

public class Track {
    private String name;
    private double duration;
    private String style;

    public Track(String name, double duration, String style) {
        this.name = name;
        this.duration = duration;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }

    public String getStyle() {
        return style;
    }

    @Override
    public String toString() {
        return "Track: " + name + " (" + style + ") - " + duration + " mins";
    }
}
