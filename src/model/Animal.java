package model;

//Abstraction
public abstract class Animal implements AnimalInterface {
 private String name;
 private String sound;

 public Animal(String name, String sound) {
     this.name = name;
     this.sound = sound;
 }

 public String getName() {
     return name;
 }
 
 public String getSound() {
	 return sound;
 }
 
 public void makeSound() {
	 System.out.println(name + ": " + sound + "!");
 }
 
}
