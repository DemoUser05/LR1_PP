package service;

import model.TrackManager;

public class SortTracksByStyleCommand implements Command {
    private TrackManager trackManager;

    public SortTracksByStyleCommand(TrackManager trackManager) {
        this.trackManager = trackManager;
    }

    @Override
    public void execute() {
        trackManager.sortTracksByStyle();
        System.out.println("Tracks sorted by style:");
        trackManager.displayTracks(trackManager.searchByDuration(0, Double.MAX_VALUE));
    }
}
