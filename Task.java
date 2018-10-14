/**
 * @author David Lu
 * The Task class allows for you to create a Task given a name as a String and a priority level as
 * an Integer.
 */
public class Task implements Comparable<Task> {
    private int priorityLevel;
    private String taskName;

    /**
     * @param name The name of the task.
     * @param priorityLevel The priority level of the task.
     */
    public Task(String name, int priorityLevel) {
        this.taskName = name;
        this.priorityLevel = priorityLevel;
    }
    /**
     *The getName method returns the task name of the Task as a String.
     * @return the name of the task as a String value.
     */
    public String getName() {
        return taskName;
    }
    /**
     *The getPriority method returns the priority level of the Task as an Integer value.
     * @return the priority level of the task as an Integer value.
     */
    public int getPriority() {
        return priorityLevel;
    }
    /**
     *The compareTo method allows for the priority queue used in the Employee class to
     * determine that the Task object is to be sorted by an integer value. This integer value
     * comes from the difference between two tasks' priority levels.
     * @param that is a task other than the current task.
     * @return the integer difference between the priority levels of two tasks.
     */
    public int compareTo(Task that) {
        return this.priorityLevel - that.priorityLevel;
    }
}