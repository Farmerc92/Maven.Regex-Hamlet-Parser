import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;
    private String leonRegex = "[^e][Ll][Ee][Oo][Nn]'?s?";
    private String tariqRegex = "[Tt][Aa][Rr][Ii][Qq]'?s?";

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        int actual = 472;
        hamletParser.changeHamletToLeon();
        Pattern pattern = Pattern.compile(leonRegex);
        Matcher matcher = pattern.matcher(hamletParser.getHamletData());
        int expected = 0;
        while (matcher.find()){
            expected++;
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq(){
        int actual = 158;
        hamletParser.changeHoratioToTariq();
        Pattern pattern = Pattern.compile(tariqRegex);
        Matcher matcher = pattern.matcher(hamletParser.getHamletData());
        int expected = 0;
        while (matcher.find()){
            expected++;
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        int actual = hamletParser.horatioNumbers();
        int expected = 158;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        int actual = hamletParser.hamletNumbers();
        int expected = 472;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testChangeHamlet(){
        hamletParser.changeHamlet();

        int actual = 158;
        hamletParser.changeHoratioToTariq();
        Pattern pattern = Pattern.compile(tariqRegex);
        Matcher matcher = pattern.matcher(hamletParser.getHamletData());
        int expected = 0;
        while (matcher.find()){
            expected++;
        }
        Assert.assertEquals(expected, actual);

        int actual1 = 472;
        hamletParser.changeHamletToLeon();
        Pattern pattern1 = Pattern.compile(leonRegex);
        Matcher matcher1 = pattern1.matcher(hamletParser.getHamletData());
        int expected1 = 0;
        while (matcher1.find()){
            expected1++;
        }
        Assert.assertEquals(expected1, actual1);
    }
}