package model;

public class AnimalImpl extends Animal implements SoundListener, Runnable {
	
	public AnimalImpl(String name, String sound) {
		super(name, sound);
	}

    @Override
    public void run() {
        // You can implement the behavior when this AnimalImpl is run as a thread
        while(true) {
            // Here, the thread can "do something" or just sleep
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

	@Override
	public void onSoundMade(Rooster rooster) {
		super.makeSound();
	}

}
