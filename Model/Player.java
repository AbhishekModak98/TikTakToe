package TikTakToe.Model;

public class Player {
    public String name;
    public String playingPiece;

    public Player (String name, String playingPiece) {
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPlayingPiece () {
        return playingPiece;
    }

    public void setPlayingPiece (String playingPiece) {
        this.playingPiece = playingPiece;
    }
}
