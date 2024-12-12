class Node {
    Student student;  // Student data
    Node next;        // Reference to the next node

    public Node(Student student) {
        this.student = student;
        this.next = null;
    }
}