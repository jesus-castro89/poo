package app.game;

public class Main {

    void main() {
        HangedMan game =new HangedMan();
        game.startNewGame();
        game.showIncompleteWord();
        game.playTurn();
    }
}
