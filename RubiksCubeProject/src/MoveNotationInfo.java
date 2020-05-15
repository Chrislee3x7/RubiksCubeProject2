import java.util.HashMap;
import java.util.Map;

public class MoveNotationInfo {

    private String notation;
    private LayerNotation layerNotation;
    private TurnDirection turnDirection;



    private static MoveNotationInfo U = new MoveNotationInfo("U", LayerNotation.U, TurnDirection.CLOCKWISE);
    private static MoveNotationInfo u = new MoveNotationInfo("U'", LayerNotation.U, TurnDirection.COUNTERCLOCKWISE);
    private static MoveNotationInfo L = new MoveNotationInfo("L", LayerNotation.L, TurnDirection.CLOCKWISE);
    private static MoveNotationInfo l = new MoveNotationInfo("L'", LayerNotation.L, TurnDirection.COUNTERCLOCKWISE);
    private static MoveNotationInfo F = new MoveNotationInfo("F", LayerNotation.F, TurnDirection.CLOCKWISE);
    private static MoveNotationInfo f = new MoveNotationInfo("F'", LayerNotation.F, TurnDirection.COUNTERCLOCKWISE);
    private static MoveNotationInfo R = new MoveNotationInfo("R", LayerNotation.R, TurnDirection.CLOCKWISE);
    private static MoveNotationInfo r = new MoveNotationInfo("R'", LayerNotation.R, TurnDirection.COUNTERCLOCKWISE);
    private static MoveNotationInfo B = new MoveNotationInfo("B", LayerNotation.B, TurnDirection.CLOCKWISE);
    private static MoveNotationInfo b = new MoveNotationInfo("B'", LayerNotation.B, TurnDirection.COUNTERCLOCKWISE);
    private static MoveNotationInfo D = new MoveNotationInfo("D", LayerNotation.D, TurnDirection.CLOCKWISE);
    private static MoveNotationInfo d = new MoveNotationInfo("D'", LayerNotation.D, TurnDirection.COUNTERCLOCKWISE);
    private static MoveNotationInfo M = new MoveNotationInfo("M", LayerNotation.M, TurnDirection.CLOCKWISE);
    private static MoveNotationInfo m = new MoveNotationInfo("M'", LayerNotation.M, TurnDirection.COUNTERCLOCKWISE);
    private static MoveNotationInfo E = new MoveNotationInfo("E", LayerNotation.E, TurnDirection.CLOCKWISE);
    private static MoveNotationInfo e = new MoveNotationInfo("E'", LayerNotation.E, TurnDirection.COUNTERCLOCKWISE);
    private static MoveNotationInfo S = new MoveNotationInfo("S", LayerNotation.S, TurnDirection.CLOCKWISE);
    private static MoveNotationInfo s = new MoveNotationInfo("S'", LayerNotation.S, TurnDirection.COUNTERCLOCKWISE);
    private static MoveNotationInfo X = new MoveNotationInfo("x", LayerNotation.X, TurnDirection.CLOCKWISE);
    private static MoveNotationInfo x = new MoveNotationInfo("x'", LayerNotation.X, TurnDirection.COUNTERCLOCKWISE);
    private static MoveNotationInfo Y = new MoveNotationInfo("y", LayerNotation.Y, TurnDirection.CLOCKWISE);
    private static MoveNotationInfo y = new MoveNotationInfo("y'", LayerNotation.Y, TurnDirection.COUNTERCLOCKWISE);
    private static MoveNotationInfo Z = new MoveNotationInfo("z", LayerNotation.Z, TurnDirection.CLOCKWISE);
    private static MoveNotationInfo z = new MoveNotationInfo("z'", LayerNotation.Z, TurnDirection.COUNTERCLOCKWISE);

    public static MoveNotationInfo[] notationList = new MoveNotationInfo[24];

    {
        notationList[0] = U;
        notationList[1] = u;
        notationList[2] = L;
        notationList[3] = l;
        notationList[4] = F;
        notationList[5] = f;
        notationList[6] = R;
        notationList[7] = r;
        notationList[8] = B;
        notationList[9] = b;
        notationList[10] = D;
        notationList[11] = d;
        notationList[12] = M;
        notationList[13] = m;
        notationList[14] = E;
        notationList[15] = e;
        notationList[16] = S;
        notationList[17] = s;
        notationList[18] = X;
        notationList[19] = x;
        notationList[20] = Y;
        notationList[21] = y;
        notationList[22] = Z;
        notationList[23] = z;
    }

    public MoveNotationInfo (String notation, LayerNotation layerNotation, TurnDirection turnDirection){
        this.notation = notation;
        this.layerNotation = layerNotation;
        this.turnDirection = turnDirection;
    }

    public static Map<String, MoveNotationInfo> moveNotationInfoMap = new HashMap<>();
    {
        for (MoveNotationInfo notationInfo : notationList) {
            moveNotationInfoMap.put(notationInfo.getNotation(), notationInfo);
        }
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
