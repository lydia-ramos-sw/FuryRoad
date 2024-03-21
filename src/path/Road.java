package path;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Road {

    private String path;
    private long asphalt;
    private long sand;

    public Road(String path) {
        this.path = path;
        this.asphalt = path.chars().filter(c -> c == 'A').count();
        this.sand = path.chars().filter(c -> c == 'S').count();
    }

    public Terrain getFirstSegment() {
        return (path.substring(0, 1).equals(Terrain.S.toString())) ? Terrain.S : Terrain.A;
    }
}
