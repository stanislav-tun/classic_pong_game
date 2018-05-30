package model.observer;

public interface ISubject {
	
	public void signUpObserver(IObserver o);
	public void deleteObserver(IObserver o);
	public void notifyObserver();

}
