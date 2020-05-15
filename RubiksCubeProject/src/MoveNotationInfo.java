import java.util.HashMap;
import java.util.Map;

public class MoveNotationInfo {

    private String notation;
    private LayerNotation layerNotation;
    private TurnDirection turnDirection;

    public MoveNotationInfo (String notation, LayerNotation layerNotation, TurnDirection turnDirection){
        this.notation = notation;
        this.layerNotation = layerNotation;
        this.turnDirection = turnDirection;
    }

    public String getNotation () {
        return this.notation;
    }

    public LayerNotation getLayerNotation () {
        return this.layerNotation;
    }

    public TurnDirection getTurnDirection () {
        return this.turnDirection;
    }
}
