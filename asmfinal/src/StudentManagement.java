import java.util.Arrays;
import java.util.Random;

public class StudentManagement {
    private StudentStack students;

    public StudentManagement() {
        this.students = new StudentStack();
    }

    // Thêm một sinh viên
    public void addStudent(String id, String name, double grade) {
        students.push(new Student(id, name, grade));
    }

    // Tạo sinh viên ngẫu nhiên
    public Student generateRandomStudent() {
        Random random = new Random();
        String id = "ID" + (random.nextInt(1000) + 1); // Tạo ID ngẫu nhiên
        String name = "Student" + (random.nextInt(1000) + 1); // Tạo tên sinh viên ngẫu nhiên
        double grade = 5 + (10 - 5) * random.nextDouble(); // Tạo điểm ngẫu nhiên từ 5 đến 10

        // Làm tròn điểm đến 1 chữ số thập phân
        grade = Math.round(grade * 10.0) / 10.0;

        // Tạo đối tượng sinh viên với thông tin ngẫu nhiên
        return new Student(id, name, grade);
    }

    // Thêm nhiều sinh viên ngẫu nhiên
    public void addRandomStudents(int numberOfStudents) {
        for (int i = 0; i < numberOfStudents; i++) {
            Student randomStudent = generateRandomStudent();
            addStudent(randomStudent.getId(), randomStudent.getName(), randomStudent.getGrade()); // Thêm sinh viên vào stack
        }
        System.out.println(numberOfStudents + " random students added successfully.");
        // Hiển thị thông tin của tất cả sinh viên đã thêm
        displayAllStudents();
    }

    // Xóa một sinh viên
    public void deleteStudent(String id) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId().equals(id)) {
                found = true;
            } else {
                tempStack.push(student);
            }
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Cập nhật thông tin sinh viên
    public void updateStudent(String id, String name, double grade) {
        StudentStack tempStack = new StudentStack();
        boolean updated = false;

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId().equals(id)) {
                student = new Student(id, name, grade);  // Cập nhật sinh viên
                tempStack.push(student);
                updated = true;
            } else {
                tempStack.push(student);
            }
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (updated) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Tìm kiếm sinh viên theo ID
    public void searchStudentById(String id) {
        for (Student student : students.toArray()) {
            if (student.getId().equals(id)) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Hiển thị tất cả sinh viên
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student student : students.toArray()) {
            System.out.println(student);
        }
    }

    // Sắp xếp sinh viên theo điểm giảm dần
    public void bubbleSort() {
        Student[] studentArray = students.toArray();

        // Đo thời gian cho Bubble Sort
        long bubbleStartTime = System.nanoTime();
        bubbleSort(studentArray);
        long bubbleEndTime = System.nanoTime();
        long bubbleDuration = bubbleEndTime - bubbleStartTime;

        // Cập nhật lại stack sau khi Bubble Sort
        students = new StudentStack();
        for (Student student : studentArray) {
            students.push(student);
        }

        // Hiển thị thời gian chạy
        System.out.println("Bubble Sort runtime: " + bubbleDuration + " ns");
    }

    // Triển khai thuật toán Bubble Sort
    private void bubbleSort(Student[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].getGrade() < array[j + 1].getGrade()) {
                    // Hoán đổi nếu phần tử không đúng thứ tự
                    Student temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Sắp xếp sinh viên theo điểm giảm dần
    public void mergeSort() {
        Student[] studentArray = students.toArray();

        // Đo thời gian cho Merge Sort
        long mergeStartTime = System.nanoTime();
        mergeSort(studentArray, 0, studentArray.length - 1);
        long mergeEndTime = System.nanoTime();
        long mergeDuration = mergeEndTime - mergeStartTime;

        // Cập nhật lại stack sau khi Merge Sort
        students = new StudentStack();
        for (Student student : studentArray) {
            students.push(student);
        }

        // Hiển thị thời gian chạy
        System.out.println("Merge Sort runtime: " + mergeDuration + " ns");
    }

    // Triển khai thuật toán Merge Sort
    private void mergeSort(Student[] array, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private void merge(Student[] array, int low, int mid, int high) {
        Student[] left = Arrays.copyOfRange(array, low, mid + 1);
        Student[] right = Arrays.copyOfRange(array, mid + 1, high + 1);
        int i = 0, j = 0, k = low;
        while (i < left.length && j < right.length) {
            if (left[i].getGrade() >= right[j].getGrade()) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}