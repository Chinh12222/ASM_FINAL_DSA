public class StudentStack {
    private Node top;  // Top of the stack
    private int size;  // Size of the stack

    public StudentStack() {
        this.top = null;
        this.size = 0;
    }

    // Add a student to the stack
    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Remove and return the top student from the stack
    public Student pop() {
        if (isEmpty()) {
            return null;  // Stack is empty
        }
        Student removedStudent = top.student;
        top = top.next;  // Move the top pointer to the next node
        size--;
        return removedStudent;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get the size of the stack
    public int size() {
        return size;
    }

    // Convert the stack to an array
    public Student[] toArray() {
        Student[] students = new Student[size];
        Node current = top;
        int index = 0;
        while (current != null) {
            students[index++] = current.student;
            current = current.next;
        }
        return students;
    }
}