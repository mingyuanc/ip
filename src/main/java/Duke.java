import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    /**
     * Default tab spacing
     */
    private static final String TAB = "     ";
    /**
     * Default Welcome Message
     */
    private static final String WELCOME_MESSAGE = TAB + "Quack Quack! I am a duck named Quack\n"
            + TAB + "What can I do for you?\n";

    /**
     * Default Exit Message
     */
    private static final String GOODBYE_MESSAGE = TAB + "Quack Quack! Quack hopes to see you again soon!\n";

    /**
     * Line Break
     */
    private static final String LINE_BREAK = "    ____________________________________________________________\n";

    /**
     * App LOGO
     */
    private static final String LOGO = "\n░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"
            +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██████████░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░████░░██████████░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░██░░░░░░░░░░██░░░░░░░░████░░██▒▒▒▒▒▒██░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░██░░██░░░░░░░░██░░░░░░░░░░░░░░██▒▒▒▒▒▒██░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░██░░░░██░░░░░░██░░░░░░░░░░░░░░████████░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░██░░░░░░░░██░░░░░░██░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░██░░░░░░░░████████████░░░░░░░░██░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░██░░░░░░░░██░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░██████░░░░░░░░░░░░░░░░████░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░████████████████░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░";

    /**
     * Quacks memory
     */
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public static void main(String[] args) {
        new Duke().run();
    }

    /**
     * Entry point of the software
     */
    private void run() {
        // Welcome Message
        print(Duke.LOGO);
        print(Duke.LINE_BREAK + Duke.WELCOME_MESSAGE + Duke.LINE_BREAK);

        this.collectCommand();

        // Good bye Message
        print(Duke.LINE_BREAK + Duke.GOODBYE_MESSAGE + Duke.LINE_BREAK);
    }

    /**
     * Handles the collection and execution of the command
     */
    private void collectCommand() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("bye")) {
            print(Duke.LINE_BREAK);
            try {
                Parser command = new Parser(input);
                switch (command.getCommand()) {
                    case LIST:
                        this.handleList();
                        break;
                    case MARK:
                    case UNMARK:
                        this.handleMark(command.getCommand() == Commands.MARK, command.getIndex() - 1);
                        break;
                    case TODO:
                    case DEADLINE:
                    case EVENT:
                        this.handleTask(command);
                        break;
                    case UNRECOGNISED:
                        this.print("Quack does not understand your command!!");
                        this.print("Quack only understands these commands: list, mark, unmark, todo, deadline, event");
                        break;

                }
            } catch (BadInputException e) {
                this.print("QUACK QUACK!! " + e.getMessage());
            } catch (NumberFormatException e) {
                this.print("QUACK QUACK!! " + e.getMessage()
                        + ", quack only understand numbers, please input a numeric value!");
            }
            this.print(Duke.LINE_BREAK);
            input = scanner.nextLine();
        }
        scanner.close();
    }

    /**
     * Handles the execution of list
     */
    private void handleList() {
        if (this.tasks.size() == 0) {
            this.print("Quack Quack, you have not entered anything yet!");
            return;
        }
        this.print("Quack Quack, here are the tasks in quack's memory:");
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
     * @throws BadInputException
     */
    private void handleMark(boolean mark, int index) throws BadInputException {

        if (this.tasks.size() == 0) {
            throw new BadInputException("Quack currently has no task remembered, why not add one now?");
        }

        // vaidate input
        if (index >= this.tasks.size()) {
            throw new BadInputException("Quack does not remember having a task: " + (index + 1) + "\n" + Duke.TAB +
                    "Quack only remember till task " + (this.tasks.size()));
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
     * Handles the creation of new tasks
     * 
     * @param param - parser object containing information on the new task.
     * @throws BadInputException
     */
    private void handleTask(Parser param) throws BadInputException {
        if (this.tasks.size() >= 100) {
            throw new BadInputException("QUACK!! quack cannot remember any more tasks!!");
        }

        Commands type = param.getCommand();
        Task newTask;
        if (type == Commands.TODO) {
            newTask = new Todo(param.getParam());

        } else if (type == Commands.DEADLINE) {
            newTask = new Deadline(param.getFlag("/by"), param.getParam());
        } else {
            newTask = new Event(param.getFlag("/from"), param.getFlag("/to"), param.getParam());
        }

        this.tasks.add(newTask);
        this.print("Quack! I have added this task:");
        this.print(newTask.toString());
        this.print("Quack! Quack is currently remembering " + this.tasks.size() + " tasks.");

    }

    /**
     * Handles the formating of string being printed
     * 
     * @param string - the string being printed
     */
    public void print(String string) {
        if (string.startsWith(Duke.LINE_BREAK)) {
            System.out.println(string);
            return;
        }
        System.out.println(Duke.TAB + string);
    }
}
