import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser() {
        this.hamletData = loadFile();
    }

    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData() {
        return hamletData;
    }

    public void changeHamletToLeon() {
       Pattern pattern = Pattern.compile("\\bHamlet|Hamlets\\b");
       Matcher matcher = pattern.matcher(hamletData);
        hamletData =  matcher.replaceAll("Leon");
    }

    public void changeHoratioToTariq() {
        Pattern pattern = Pattern.compile("\\bHoratio|Horatios\\b");
        Matcher matcher = pattern.matcher(hamletData);
        hamletData = matcher.replaceAll("Tariq");
    }

    public String changeName(String nameToFind, String nameToReplaceWith) {
        Pattern pattern = Pattern.compile("\\w+(\\W)?");

        Matcher matcher = pattern.matcher(nameToFind);

        String result = "";

        while (matcher.find()) {
            String name = matcher.group();
            if (name.equals(nameToFind)) {
                result += nameToReplaceWith;
            } else {
                result += name;
            }
        }


        return result;

    }

    public Boolean findHoratio(String hamletData) {
        Pattern pattern1 = Pattern.compile("Hamlet | HAMLET");
//        Pattern pattern2 = Pattern.compile("HAMLET");
        return (pattern1.matcher(hamletData).find());
//
    }

    public boolean findHamlet(String hamletData) {
        Pattern pattern1 = Pattern.compile("Hamlet | HAMLET");
//        Pattern pattern2 = Pattern.compile("HAMLET");
        return (pattern1.matcher(hamletData).find());
    }
}
