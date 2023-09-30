package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import model.Rooster;
import model.AnimalImpl;

public class Controller {
	private Rooster rooster;
    private List<Thread> animalThreads = new ArrayList<>();
    private int countdown = 24;
    
	public void createFarm() {
	    Scanner scan = new Scanner(System.in);
	    int index = 0;
	    System.out.println("Welcome to the farm! What is the rooster's name again?");
	    String name = scan.nextLine();
	    rooster = new Rooster(name);
    	System.out.println("That's right, it's " + rooster.getName() + ". What animals are you here to see? (Enter up to 5 one-by-one and -1 when finished)");
	    while(index < 5) {
	    	System.out.print("Enter animal species: ");
	    	String animal = scan.nextLine();
	    	if (animal.equals("-1")) {
	    		break;
	    	}
	    	System.out.print("What sound does this animal make: ");
	    	String sound = scan.nextLine();
	    	if (sound.equals("-1")) {
	    		break;
	    	}
            AnimalImpl animalImpl = new AnimalImpl(animal, sound);
            rooster.addSoundListener(animalImpl);

            Thread animalThread = new Thread(animal);
            animalThreads.add(animalThread);
            animalThread.start();
            }
	    
	    System.out.println("Press enter to initiate sunrise!");
	    scan.nextLine();
	    scan.close();
	    rooster.makeSound();
	    startCountdown();
	}
	
    public void startCountdown() {
        Timer timer = new Timer();
        TimerTask countdownTask = new TimerTask() {
            @Override
            public void run() {
            	if (countdown == 8) {
            		System.out.print("\nTime for bed. See you in the morning!");
            	} else if (countdown >= 0){
            		System.out.print("\rTime remaining: " + countdown + " hours");
            	}
                countdown--;
                if (countdown < 0) {
                    System.out.println("");
                    rooster.makeSound();
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(countdownTask, 400, 400);
    }
	
}
