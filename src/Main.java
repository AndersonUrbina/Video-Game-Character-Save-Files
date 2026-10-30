import jdk.jshell.JShellConsole;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.XMLFormatter;

public class Main {
    //Main Method
    public static void main(String[] args) {
        System.out.println("Game character Save Files");

        //Make a list of characters
        List<GameCharacter> characters = new ArrayList<>();

        //Make Characters
        characters.add(new GameCharacter("John", "Pizza Salesman", 5, 100, 20, 170));
        characters.add(new GameCharacter("Medo", "Luxury Bed Tester", 4, 130, 18, 250));
        characters.add(new GameCharacter("Robert", "Retired Soldier", 6, 120, 25, 280));

        //Print out all characters
        System.out.println("characters: ");
        for (GameCharacter character : characters) {
            System.out.println(character);
        }

        // Save to Xml and Json
        System.out.println();
        System.out.println("Saving character data: ");

        try{
            saveAsJson(characters, "characters.json");
            System.out.println("characters.json, Successfully saved!");

            saveAsXml(characters, "characters.xml");
            System.out.println("characters.xml, Successfully saved!");

            System.out.println();
            readAndDisplayFile("characters.json", "Reading JSON File: ");

            System.out.println();
            readAndDisplayFile("characters.xml", "Reading XML File: ");

        } catch (FileNotFoundException e) {
            System.out.println("File Error: " + e.getMessage());
        }

    }

    // Save to XML Method:
    public static void saveAsXml(List<GameCharacter> characters, String fileName) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(fileName);

        writer.println("<characters>");

        for (GameCharacter character : characters){
            writer.println("  <character>");

            writer.println("    <name>" + escapeXml(character.getName()) + "</name>");
            writer.println("    <characterClass>" + escapeXml(character.getCharacterClass()) + "</characterClass>");
            writer.println("    <level>" + character.getLevel() + "</level>");
            writer.println("    <health>" + character.getHealth() + "</health>");
            writer.println("    <attackPower>" + character.getAttackPower() + "</attackPower>");
            writer.println("    <gold>" + character.getGold() + "</gold>");

            writer.println("  </character>");
        }

        writer.println("</characters>");
        writer.close();
    }

    //Save as JSON Method:
    public static void saveAsJson(List<GameCharacter> characters, String fileName) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(fileName);

        writer.println("[");

        for (int i =0; i < characters.size(); i++) {
            GameCharacter character = characters.get(i);

            writer.println(" {");

            writer.println("   \"name\": \"" + escapeJSON(character.getName()) + "\",");
            writer.println("   \"characterClass\": \"" + character.getCharacterClass() + "\", ");
            writer.println("   \"level\": " + character.getLevel() + ",");
            writer.println("   \"health\": " + character.getHealth() + ",");
            writer.println("   \"attackPower\": " + character.getAttackPower() + ",");
            writer.println("   \"gold\": " + character.getGold());

            writer.println(" }");

            if (i < characters.size() -1)
                writer.println(",");
            else
                writer.println("]");
        }
        writer.close();
    }

    //Method read display the files
    public static void readAndDisplayFile(String fileName, String heading) throws FileNotFoundException {
        System.out.println(heading);

        File file = new File(fileName);
        Scanner fileReader = new Scanner(file);

        while (fileReader.hasNextLine())
            System.out.println(fileReader.nextLine());

        fileReader.close();
    }

    //Helper Methods
    public static String escapeXml(String text) {
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }

    public static String escapeJSON(String text) {
        return text.replace("\\", "\\\\")
                .replace("\"", "\\\"");
    }

}
