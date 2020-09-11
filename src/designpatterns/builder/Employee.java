package designpatterns.builder;

public class Employee {

  public static class EmployeeBuilder {
    private int id;
    private String name;
    private String designation;
    private String manager;
    private String address;
    private String employmentType;
    private long salary;

    public EmployeeBuilder(int id, String name) {
      this.id = id;
      this.name = name;
    }

    public EmployeeBuilder setDesignation(String designation) {
      this.designation = designation;
      return this;
    }

    public EmployeeBuilder setManager(String manager) {
      this.manager = manager;
      return this;
    }

    public EmployeeBuilder setAddress(String address) {
      this.address = address;
      return this;
    }

    public EmployeeBuilder setEmploymentType(String employmentType) {
      this.employmentType = employmentType;
      return this;
    }

    public EmployeeBuilder setSalary(long salary) {
      this.salary = salary;
      return this;
    }

    public Employee build() {
      Employee emp = new Employee(this);
      return emp;
    }
  }

  private int id;
  private String name;
  private String designation;
  private String manager;
  private String address;
  private String employmentType;
  private long salary;

  private Employee(final EmployeeBuilder b) {
    this.id = b.id;
    this.address = b.address;
    this.designation = b.designation;
  }
}
