public class Student {
    private String id;  // ID sinh viên (String)
    private String name;  // Tên sinh viên
    private double grade;  // Điểm sinh viên

    // Constructor để tạo đối tượng sinh viên
    public Student(String id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Phương thức getter để lấy ID sinh viên
    public String getId() {
        return id;
    }

    // Phương thức setter để cập nhật ID sinh viên
    public void setId(String id) {
        this.id = id;
    }

    // Phương thức getter để lấy tên sinh viên
    public String getName() {
        return name;
    }

    // Phương thức setter để cập nhật tên sinh viên
    public void setName(String name) {
        this.name = name;
    }

    // Phương thức getter để lấy điểm sinh viên
    public double getGrade() {
        return grade;
    }

    // Phương thức setter để cập nhật điểm sinh viên
    public void setGrade(double grade) {
        this.grade = grade;
    }

    // Phương thức tính thứ hạng dựa trên điểm (theo bảng mới)
    public String getRanking() {
        if (grade >= 9.0) {
            return "Excellent";
        } else if (grade >= 7.5) {
            return "Very Good";
        } else if (grade >= 6.5) {
            return "Good";
        } else if (grade >= 5.0) {
            return "Medium";
        } else {
            return "Fail";
        }
    }

    // Phương thức toString để hiển thị thông tin sinh viên
    @Override
    public String toString() {
        // Sử dụng String.format để đảm bảo điểm được hiển thị với 2 chữ số thập phân
        return "ID: " + id + ", Name: " + name + ", Grade: " + String.format("%.2f", grade) + ", Rank: " + getRanking();
    }
}