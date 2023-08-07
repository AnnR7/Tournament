import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testPlayerFirstWin(){
        Player Anna = new Player(1,"Анна", 500);
        Player Misha = new Player(2, "Миша", 300);

        Game game = new Game();

        game.register(Anna);
        game.register(Misha);
        int expected = 1;
        int actual = game.round("Анна", "Миша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerSecondWin(){
        Player Anna = new Player(1,"Анна", 100);
        Player Misha = new Player(2, "Миша", 600);

        Game game = new Game();

        game.register(Anna);
        game.register(Misha);
        int expected = -1;
        int actual = game.round("Анна", "Миша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlayersStrengthEquals(){
        Player Anna = new Player(1,"Анна", 200);
        Player Misha = new Player(2, "Миша", 200);

        Game game = new Game();

        game.register(Anna);
        game.register(Misha);
        int expected = 0;
        int actual = game.round("Анна", "Миша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerFirstNotExist(){
        Player Anna = new Player(1,"Анна", 100);
        Player Misha = new Player(2, "Миша", 700);

        Game game = new Game();

        game.register(Anna);
        game.register(Misha);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Оля", "Миша")
        );
    }

    @Test
    public void testPlayerSecondNotExist(){
        Player Anna = new Player(1,"Анна", 100);
        Player Misha = new Player(2, "Миша", 700);

        Game game = new Game();

        game.register(Anna);
        game.register(Misha);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Анна", "Коля")
        );
    }
}