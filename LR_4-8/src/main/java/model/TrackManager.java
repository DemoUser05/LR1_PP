package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrackManager {
    private List<Track> tracks;

    public TrackManager() {
        tracks = new ArrayList<>();
    }

    // Method to display tracks
    public void displayTracks(List<Track> tracks) {
        if (tracks.isEmpty()) {
            System.out.println("No tracks available.");
        } else {
            tracks.forEach(System.out::println); // This will call toString on each Track
        }
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public boolean removeTrackByName(String trackName) {
        return tracks.removeIf(track -> track.getName().equalsIgnoreCase(trackName));
    }

    public List<Track> searchByDuration(double minDuration, double maxDuration) {
        return tracks.stream()
                .filter(track -> track.getDuration() >= minDuration && track.getDuration() <= maxDuration)
                .collect(Collectors.toList());
    }

    public void sortTracksByStyle() {
        tracks.sort((t1, t2) -> t1.getStyle().compareTo(t2.getStyle()));
    }

    public List<Track> getTracks() {
        return tracks;
    }
}
