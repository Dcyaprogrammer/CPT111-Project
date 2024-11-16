package xjtlu.cpt111.assignment.quiz;
import java.util.Scanner;

public class TopicSelection {
    public static String selectTopic(){
        System.out.println("Select a topic from this list:");
        System.out.println("1. Computer Science");
        System.out.println("2. Electrical Engineering");
        System.out.println("3. Mathematics");
        System.out.println("4. English");
        Scanner scanner = new Scanner(System.in);
        String topic = scanner.nextLine();
        return topic;
    }
}
