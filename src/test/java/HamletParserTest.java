import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    @Test
    public void testChangeHamletToLeon() {
        // given
        HamletParser hamletParser = new HamletParser();
        String hamletText = hamletParser.getHamletData();
        String expectedText = hamletText.replaceAll("Hamlet", "Leon");

        // when
        hamletParser.changeHamletToLeon();

        // then
        String actualText = hamletParser.getHamletData();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void testChangeHoratioToTariq() {
        // given
        HamletParser hamletParser = new HamletParser();
        String hamletText = hamletParser.getHamletData();
        String expectedText = hamletText.replaceAll("Horatio", "Tariq");

        // when
        hamletParser.changeHoratioToTariq();

        // then
        String actualText = hamletParser.getHamletData();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void testFindHoratio() {

    }

    @Test
    public void testFindHamlet() {
    }
}