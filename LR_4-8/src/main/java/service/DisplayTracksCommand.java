package service;

import model.TrackManager;

public class DisplayTracksCommand implements Command {
    private TrackManager trackManager;

    public DisplayTracksCommand(TrackManager trackManager) {
        this.trackManager = trackManager;
    }

    @Override
    public void execute() {
        System.out.println("All tracks:");
        trackManager.displayTracks(trackManager.searchByDuration(0, Double.MAX_VALUE));
    }
}
