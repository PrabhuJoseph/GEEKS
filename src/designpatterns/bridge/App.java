package designpatterns.bridge;

public class App {

  interface Shape {
    void draw();
  }

  interface Color {
    void applyColor();
  }

  static class Triangle implements Shape {
    private Color color;
    Triangle(Color color) {
      this.color = color;
    }
    public void draw() {
      System.out.print("TRIANGLE");
      color.applyColor();
    }
  }

  static class Rectangle implements Shape {
    Color color;
    Rectangle(Color color) {
      this.color = color;
    }
    public void draw() {
      System.out.print("RECTANGLE");
      color.applyColor();
    }
  }

  static class Yellow implements Color {
    public void applyColor() {
      System.out.println(" YELLOW");
    }
  }

  static class Red implements Color {
    public void applyColor() {
      System.out.println(" RED");
    }
  }

  public static void main(String[] args) {
    Shape triangle = new Triangle(new Yellow());
    triangle.draw();
  }

}
