package calculations;

import java.util.ArrayList;
import lombok.Getter;
import path.Road;

@Getter
public class Route {

    private final ArrayList path = new ArrayList();
    private final String furyRoad;
    private final Road road;
    private boolean usesElectricScooter = false;
    private int segmentToDropElectricScooter = -1;


    public Route(String R) {
        furyRoad = R;
        road = new Road(R);
    }

    public void usesElectricScooterPath() {
        usesElectricScooter = true;
    }

    public void dropsScooter(int segmentToDropElectricScooter) {
        this.segmentToDropElectricScooter = segmentToDropElectricScooter;
    }

    public String toString() {
        Road roadByFoot = null;
        Road roadByElectricScooter = null;
        long minutesByElectronicScooter = 0;
        long minutesByFoot = 0;

        if (usesElectricScooter) {
            if (segmentToDropElectricScooter > -1) {
                roadByElectricScooter = new Road(furyRoad.substring(0, segmentToDropElectricScooter));
                roadByFoot = new Road(furyRoad.substring(segmentToDropElectricScooter));
            } else {
                roadByElectricScooter = road;
            }
        } else {
            roadByFoot = road;
        }
        minutesByFoot = (roadByFoot != null) ? TransportOptimizer.calculateByFoot(roadByFoot) : 0;
        minutesByElectronicScooter =
                (roadByElectricScooter != null) ? TransportOptimizer.calculateByElectricScooter(roadByElectricScooter)
                        : 0;

        StringBuffer sb = new StringBuffer();
        sb.append("For Fury road:'")
                .append(furyRoad)
                .append("' \n");
        if (usesElectricScooter) {
            sb.append(" person rides the electric scooter on this segment: ")
                    .append(roadByElectricScooter.getPath())
                    .append(" and takes ")
                    .append(minutesByElectronicScooter)
                    .append(" minutes \n");
        }
        if (!usesElectricScooter || segmentToDropElectricScooter > -1) {
            sb.append(" person walks by foot on this segment: ")
                    .append(roadByFoot.getPath())
                    .append(" and takes ")
                    .append(minutesByFoot)
                    .append(" minutes \n");
        }
        sb.append(" therefore Fury road takes a total of =>")
                .append(minutesByFoot + minutesByElectronicScooter);
        return sb.toString();
    }
}
