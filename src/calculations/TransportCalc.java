package calculations;

import lombok.Getter;
import path.Road;
import path.Terrain;
import transport.Transport;

@Getter
public class TransportCalc {

    Road road;
    long minutes;
    Transport transport;

    public TransportCalc(Road road) {
        this.road = road;
    }

    public void calculateBestTransport() {
        long minutesByFoot = TransportOptimizer.calculateByFoot(road);
        long minutesByElectricScooter = TransportOptimizer.calculateByElectricScooter(road);
        if (minutesByElectricScooter <= minutesByFoot || road.getFirstSegment().equals(Terrain.A)) {
            minutes = minutesByElectricScooter;
            transport = Transport.ELECTRIC_SCOOTER;
        } else {
            minutes = minutesByFoot;
            transport = Transport.FOOT;
        }
    }
}
