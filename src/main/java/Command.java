/**
 * create a command class to handle the execution of the command
 */
public abstract class Command {

    /**
     * validate the index to ensure it is within range
     *
     * @param index - the index of the task in question
     * @param len   - the current length of the task list
     * @throws DukeBadInputException if the index given is not within range
     */
    public static void validateIndex(int index, int len) throws DukeBadInputException {

        // validate input
        if (len == 0) {
            throw new DukeBadInputException(
                    "Quack currently has no task remembered and cannot execute your command, add one now??");
        }

        // validate input
        if (index >= len) {
            throw new DukeBadInputException("Quack does not remember having a task: " + (index + 1) +
                    " Quack only remember till task " + (len));
        }
    }

    /**
     * Method to encapsulate the execution logic of the command
     *
     * @param taskList - the task list instance  of the current duke
     * @param ui       - the ui instance of DUKE
     * @param storage  - the storage instance to allow the command to write to the storage
     * @throws DukeBadInputException - if the input cannot be used
     */
    abstract void execute(TaskList taskList, Ui ui, Storage storage) throws DukeBadInputException;


    /**
     * Checks if the command is the exit command
     *
     * @return true if it is the exit command
     */
    abstract boolean isExit();
}
