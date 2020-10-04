package sample;

public class MoveResult {

    private MoveType type;

    private Piece killedPiece;

    public MoveType getType() {
        return type;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public MoveResult(MoveType t) {
        this(t, null);
    }

    public MoveResult(MoveType type, Piece p) {
        this.killedPiece = p;
        this.type = type;
    }
}
