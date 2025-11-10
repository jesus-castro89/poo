package app.game;

public class Main {

    void main() {
//        HangedMan game =new HangedMan();
//        game.startNewGame();
//        game.showIncompleteWord();
//        game.playTurn();
        String test="aeiouáéíóúüñ";
        String test2="_ ".repeat(test.length()).trim();
        IO.println(test);
        IO.println(test2);
        // Validamos en el segundo texto si existe la vocal a, con acentos y diéresis
        for(int i=0;i<test.length();i++){
            char letter=test.charAt(i);
            if("aá".indexOf(letter)!=-1){

                IO.println("La letra '"+letter+"' es una 'a' o 'á'");
                String replaced= test2;
                replaced=replaced.substring(0,i)+"a"
                        +replaced.substring(i+1);
            }
        }
    }
}
