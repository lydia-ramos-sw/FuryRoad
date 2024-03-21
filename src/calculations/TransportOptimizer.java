package calculations;

import path.Road;
import transport.ElectricScooter;
import transport.Foot;
import transport.Transport;


public class TransportOptimizer {

    public static Route calculateBestRoute(String R) {
        Route route = new Route(R);
        for (int i = 0; i < R.length(); i++) {
            TransportCalc transportRemainingSegment = new TransportCalc(new Road(R.substring(i)));
            transportRemainingSegment.calculateBestTransport();
            if (transportRemainingSegment.getTransport().equals(Transport.FOOT)) {
                route.dropsScooter(i);
                break;
            }
            route.usesElectricScooterPath();
        }
        return route;
    }

    public static long calculateByFoot(Road road) {
        return road.getAsphalt() * Foot.ALPHA_SEGMENT.getValue() +
                road.getSand() * Foot.SAND_SEGMENT.getValue();
    }

    public static long calculateByElectricScooter(Road road) {
        return road.getAsphalt() * ElectricScooter.ALPHA_SEGMENT.getValue() +
                road.getSand() * ElectricScooter.SAND_SEGMENT.getValue();
    }
}
