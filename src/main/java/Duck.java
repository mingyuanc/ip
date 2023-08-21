import java.util.ArrayList;
import java.util.Scanner;

public class Duck {

    /**
     * Default tab spacing
     */
    private static final String TAB = "     ";
    /**
     * Default Welcome Message
     */
    private static final String WELCOME_MESSAGE = TAB + "Quack Quack! I am a duck named Quack\r\n"
            + TAB + "What can I do for you?\r\n";

    /**
     * Default Exit Message
     */
    private static final String GOODBYE_MESSAGE = TAB + "Quack Quack! Quack hopes to see you again soon!\r\n";

    /**
     * Line Break
     */
    private static final String LINE_BREAK = "    ____________________________________________________________\r\n";

    /**
     * App LOGO
     */
    private static final String LOGO = "\r\n░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\r\n"
            +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██████████░░░░░░░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░████░░██████████░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░░░░░██░░░░░░░░░░██░░░░░░░░████░░██▒▒▒▒▒▒██░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░░░██░░██░░░░░░░░██░░░░░░░░░░░░░░██▒▒▒▒▒▒██░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░░░██░░░░██░░░░░░██░░░░░░░░░░░░░░████████░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░██░░░░░░░░██░░░░░░██░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░██░░░░░░░░████████████░░░░░░░░██░░░░░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░██░░░░░░░░██░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░░░░░██████░░░░░░░░░░░░░░░░████░░░░░░░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░░░░░░░░░░░████████████████░░░░░░░░░░░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\r\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░";

    private ArrayList<Task> tasks = new ArrayList<Task>();

    public static void main(String[] args) {
        new Duck().run();
    }

    /**
     * Entry point of the software
     */
    public void run() {
        // Welcome Message
        print(Duck.LOGO);
        print(Duck.LINE_BREAK + Duck.WELCOME_MESSAGE + Duck.LINE_BREAK);

        this.collectCommand();

        // Good bye Message
        print(Duck.LINE_BREAK + Duck.GOODBYE_MESSAGE + Duck.LINE_BREAK);
    }

    /**
     * Handles the collection and execution of the command
     */
    public void collectCommand() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("bye")) {
            print(Duck.LINE_BREAK);
            String[] parsedInput = input.split(" ");
            switch (parsedInput[0]) {
                case "list":
                    handleList();
                    break;
                case "mark":
                    handleMark(true, Integer.valueOf(parsedInput[1]) - 1);
                    break;
                case "unmark":
                    handleMark(false, Integer.valueOf(parsedInput[1]) - 1);
                    break;
                default:
                    if (this.tasks.size() >= 99) {
                        this.print("Quack Quack, I cant remember anymore things!");
                        break;
                    }
                    this.tasks.add(new Task(input, this.tasks.size()));
                    this.print("Quack has added: " + input);

            }

            print(Duck.LINE_BREAK);
            input = scanner.nextLine();
        }
        scanner.close();
    }

    /**
     * Handles the execution of list
     */
    public void handleList() {
        if (this.tasks.size() == 0) {
            this.print("Quack Quack, you have not entered anything yet!");
            return;
        }

        for (int i = 0; i < this.tasks.size(); i++) {
            this.print((i + 1) + "." + this.tasks.get(i));
        }
    }

    /**
     * Handles the execution of mark and unmark
     * 
     * @param mark  - a boolean value to indicate to mark or unmark the task, true
     *              for mark
     * @param index - the index of the task in question
     */
    public void handleMark(boolean mark, int index) {

        // vaidate input
        if (index >= this.tasks.size()) {
            this.print("QUACK QUACK!! quack does not remember having a task: " + (index + 1));
            this.print("Quack only remember till task " + (this.tasks.size() - 1));
            return;
        }

        Task task = this.tasks.get(index);
        // only toggle if mark != completed as if they are the same then theres no
        // effect
        String resp;
        if (mark != task.isCompleted()) {
            task.toggleCompleted();
            resp = mark ? "Quack! Congrat for finishing the task!" : "Quack, I've marked this task as not done yet :(";
        } else {
            resp = mark ? "Quack! This task is already done QUACK!"
                    : "Quack! you cant unmark something that isnt done yet!!";
        }
        this.print(resp);
        this.print(task.toString());

    }

    /**
     * Handles the formating of string being printed
     * 
     * @param string - the string being printed
     */
    public void print(String string) {
        if (string.startsWith(Duck.LINE_BREAK)) {
            System.out.println(string);
            return;
        }
        System.out.println(Duck.TAB + string);
    }
}
