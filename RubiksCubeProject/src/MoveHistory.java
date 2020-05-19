import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoveHistory {
    public List<String> moveHistory;

    public MoveHistory() {
        List<String> moveHistory = new ArrayList<>();
        this.moveHistory = moveHistory;
    }

    public List<String> getMoveHistoryList() {
        return moveHistory;
    }

    public void addToMoveHistory(MoveHistory moveHistory, String stringToAddToMoveHistory) {
        moveHistory.getMoveHistoryList().add(stringToAddToMoveHistory);
        System.out.println(stringToAddToMoveHistory);
    }
}
