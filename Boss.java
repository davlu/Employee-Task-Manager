import java.util.Scanner;
/**
 * The Boss class is what the "Boss" will be seeing. It allows for the boss to manage an employee and to manage tasks
 * for that specific employee.
 * @author David Lu
 */
public class Boss {
    /**
     * The main() method allows for the Boss to choose what he wants to do. First, we use a scanner to get the input
     * of the Employee's name that the boss is interested in managing. Then, we give the boss 10 options that he can
     * choose from. Scanning for his response which should be an integer parsable string value, he can call on 9
     * of the instantiated object methods(only after creating a task) that are supported by the Employee and Task classes.
     * If he wants to quit, he can type '10' to exit the program.
     *
     * @param args Commandline String argument.
     */
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        System.out.println("What is the name of the employee?");
        String name = input.nextLine();
        Employee employee = new Employee(name);
        int i=0;
        while(i<10) {
            System.out.println("Hi. Choose a numerical option: \n" +
                    "1. Add a task:\t\t\t Assign a new task to an employee, given its name and priority level.\n" +
                    "2. View next task:\t\t Display the highest-priority task that the employee should complete next.\n" +
                    "3. View all tasks:\t\t Display a list of all incomplete tasks in any order of your choosing.\n" +
                    "4. Complete a task:\t\t Move the highest-priority task from the taskList to the completedTasks to " +
                    "await either approval or rejection by the boss.\n" +
                    "5. Review a task:\t\t Display the most recently completed task awaiting approval/rejection by the boss.\n" +
                    "6. Review all tasks:\t\t Display a list of all completed tasks awaiting approval/rejection by the boss.\n" +
                    "7. Approve a task:\t\t Move the most recently completed task from the completedTasks the employee's workRecord.\n" +
                    "8. Reject a task:\t\t Move the most recently completed task from the completedTasks the employee's taskList.\n" +
                    "9. View work record:\t\t Display a chronological listing of all of an employee's approved tasks.\n" +
                    "10. Quit:\t\t\t Exit the program.");
            System.out.println("Response: ");
            String response = input.nextLine();
            int intResponse = Integer.parseInt(response);
            if(intResponse>10||intResponse<1){
                System.out.println("Error. Choose an option from 1-10");
            }
            switch(response){
                case "1":
                    System.out.println("Give the name of the task: ");
                    String taskName = input.nextLine();
                    System.out.println("Give the priority level of the task: ");
                    Integer priorityLevel = input.nextInt();
                    input.nextLine();
                    employee.addTask(taskName, priorityLevel);
                    break;
                case "2":
                    System.out.println(employee.getTask());
                    break;
                case "3":
                    employee.reviewAllTasks();
                    break;
                case "4":
                    employee.completedTask();
                    break;
                case "5":
                    System.out.println(employee.reviewRecentCompletedTask());
                    break;
                case "6":
                    System.out.println(employee.reviewAllCompletedTasks());
                    break;
                case "7":
                    employee.approveTask();
                    break;
                case "8":
                    employee.rejectTask();
                    break;
                case "9":
                    System.out.println(employee.viewWorkRecord());
                    break;
                case "10":
                    i = 10;
                    break;
            }
        }
    }
}