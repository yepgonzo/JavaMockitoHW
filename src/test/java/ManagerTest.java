import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    Manager manager = new Manager();

    @Test
    public void addSomeFilms() {

        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");

        String[] actual = manager.findAll();
        String[] expected = {"film1", "film2", "film3"};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void addOneFilm() {

        manager.addFilm("film1");

        String[] actual = manager.findAll();
        String[] expected = {"film1"};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilms() {

        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        manager.addFilm("film4");
        manager.addFilm("film5");
        manager.addFilm("film6");
        manager.addFilm("film7");
        manager.addFilm("film8");
        manager.addFilm("film9");
        manager.addFilm("film10");
        manager.addFilm("film11");
        manager.addFilm("film12");
        manager.addFilm("film13");
        manager.addFilm("film14");
        manager.addFilm("film15");

        String[] expected = {
                "film15",
                "film14",
                "film13",
                "film12",
                "film11",
                "film10",
                "film9",
                "film8",
                "film7",
                "film6"
        };
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsEqualLimit() {
        Manager manager = new Manager(3);

        manager.addFilm("film13");
        manager.addFilm("film14");
        manager.addFilm("film15");

        String[] expected = {"film15", "film14", "film13"};
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsOverLimit() {
        Manager manager = new Manager(5);

        manager.addFilm("film10");
        manager.addFilm("film11");
        manager.addFilm("film12");
        manager.addFilm("film13");
        manager.addFilm("film14");
        manager.addFilm("film15");

        String[] expected = { "film15", "film14", "film13", "film12", "film11" };
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsLessLimit() {
        Manager manager = new Manager(5);

        manager.addFilm("film13");
        manager.addFilm("film14");
        manager.addFilm("film15");

        String[] expected = { "film15", "film14", "film13" };
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }
}