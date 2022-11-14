package DefiningClassesEx1;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<OpinionPoll> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String personalData = sc.nextLine();
            String currName = personalData.split(" ")[0];
            int currAge = Integer.parseInt(personalData.split(" ")[1]);
            if(currAge > 30){
                OpinionPoll person = new OpinionPoll(currName, currAge);
                people.add(person);
            }
        }

        people.stream().sorted((e1, e2)  -> e1.getName().compareTo(e2.getName()))
                .forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
}
