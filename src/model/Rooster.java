package model;

import java.util.ArrayList;
import java.util.List;

public class Rooster extends Animal {
    private List<SoundListener> listeners;

	public Rooster(String name) {
		super(name, "Cock-a-doodle-doo");
		listeners = new ArrayList<>();
	}

	@Override
	public void makeSound() {
		super.makeSound();
        notifyListeners();
	}
	
    public void addSoundListener(SoundListener listener) {
        listeners.add(listener);
    }

    public void removeSoundListener(SoundListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (SoundListener listener : listeners) {
            listener.onSoundMade(this);
        }
    }
}
