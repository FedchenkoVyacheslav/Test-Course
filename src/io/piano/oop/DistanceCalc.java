package io.piano.oop;

class DistanceCalc {
    private double distance;

    DistanceCalc(int x1, int y1, int x2, int y2) {
        distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
    double getDistance() {
        return distance;
    }
}
