import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Stack;

/**
 * The Employee class allows for tasks to be stored and moved around(as well as removing/adding)
 * in virtual work/completed task records and to-do task lists.
 * @author David Lu
 */
public class Employee{
    private String employeeName;
    private PriorityQueue<Task> workRecord = new PriorityQueue<Task>();
    private ArrayList<Task> taskList = new ArrayList<Task>();
    private ArrayList<String> workRecordHolder = new ArrayList<String>();
    private Stack<Task> completedTasks = new Stack<Task>();

    /**
     * @param name The name of the employee.
     */
    public Employee(String name){
        this.employeeName = name;
        this.taskList = taskList;
        this.workRecord = workRecord;
        this.completedTasks = completedTasks;
    }

    /**
     * The addTask method allows for the employee to be assigned a task. This task is then added to an
     * arrayList called "taskList".
     * @param name The name of the task to be added.
     * @param priorityLevel The priority level of the task to be added.
     */
    public void addTask(String name, int priorityLevel){
        taskList.add(new Task(name, priorityLevel));
    }

    /**
     * The getTask method works by looping through all values of the taskList. Whichever value ends up being
     * the largest in terms of priority level will be the task that gets returned.
     * @return Returns the name of the highest priority task that the employee needs to complete.
     */
    public String getTask(){
        int val = 0;
        int index = 0;
        for(int i =0; i<taskList.size();i++){
            if(taskList.get(i).getPriority()>val){
                val = taskList.get(i).getPriority();
                index = i;
            }
        }
        return taskList.get(index).getName();
    }

    /**
     * The reviewAllTasks method iterates through all elements of taskList and then outputs these elements
     * as a string for the Boss to look over.
     */
    public void reviewAllTasks(){
        String content = "";
        for(int i =0; i<taskList.size(); i++) {
            if(i==taskList.size()-1){
                content+=(taskList.get(i).getName());
                break;
            }
            content+=(taskList.get(i).getName()+",");
        }
        System.out.println(content);
    }

    /**
     * The completedTask method takes the first element, the highest priority task, from taskList and then
     * adds it into a stack called "completedTasks". This highest priority task is then removed from taskList.
     */
    public void completedTask(){
        completedTasks.add(taskList.get(0));
        taskList.remove(0);
    }

    /**
     * The reviewRecentCompletedTask method calls .peek() on the completedTasks stack for the most recent task and then
     * returns the name of that task as a String.
     * @return The return value of reviewRecentCompletedTask() is the name of the topmost value: the most recent
     * task.
     */
    public String reviewRecentCompletedTask(){
        return completedTasks.peek().getName();
    }

    /**
     * The reviewAllCompletedTasks method iterates through all elements awaiting boss approval/rejection
     * in the stack completedTasks and returns them as a string.
     * @return The return is a String representation called 'content' of all elements in the completedTasks stack.
     */
    public String reviewAllCompletedTasks() {
        String content = "";
        for (int i = 0; i < completedTasks.size(); i++) {
            if (i == completedTasks.size() - 1) {
                content += (completedTasks.get(i).getName());
                break;
            }
            content += (completedTasks.get(i).getName() + ",");
        }
        return content;
    }

    /**
     * The approveTask method calls a .pop operation on the completedTasks stack and adds the most recently completed task
     * into a priority queue called "workRecord".
     */
    public void approveTask(){
        workRecord.add(completedTasks.pop());
    }

    /**
     * The rejectTask method calls a .pop operation on the completedTasks stack and adds the most recently completed task
     * back into taskList.
     */
    public void rejectTask(){
        taskList.add(completedTasks.pop());
    }

    /**
     * The viewWorkRecord method works by calling a .poll operation on workRecord. Because a priority queue doesn't allow
     * direct index access, we have to use a loop that iterates an integer i from the size of workRecord down to 0 with
     * each loop "polling" the topmost value of workRecord. We have an arrayList that takes in all of these
     * polled values called "workRecordHolder". Finally, because workRecordHolder is able to be iterated through,
     * we iterate through each index of workRecordHolder and return their names as a String.
     * @return The return is a String representation of the contents of "workRecord" in chronological order.
     */
    public String viewWorkRecord(){
        String content = "";
        for(int i = workRecord.size()-1; i >-1; i--){
            workRecordHolder.add(workRecord.poll().getName());
        }
        for(int i = workRecordHolder.size()-1; i>-1; i--) {
            if(i==0) {
                content+=workRecordHolder.get(i);
                break;
            }
            content +=(workRecordHolder.get(i)+",");
        }
        return content;
    }
}