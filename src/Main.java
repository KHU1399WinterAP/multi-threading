import java.util.Scanner;

public class Main {
	public static final Scanner input = new Scanner(System.in);
	public static boolean quit = false;
	
	public static void main(String[] args) {
		new Thread1().start();
		new Thread2().start();
		new Thread3().start();
	}
	
	public static void askToQuit() {
		System.out.println();
		System.out.print("Quit? (y/n) ");
		quit = Main.input.nextLine().compareToIgnoreCase("y") == 0;
		
		System.out.println();
		System.out.println("-".repeat(30));
		System.out.println();
	}
}

class Thread1 extends Thread {
	@Override
	public void run() {
		while (!Main.quit) {
			synchronized (Main.input) {
				if (Main.quit)
					break;
				
				System.out.print("Year: ");
				int year = Main.input.nextInt();
				Main.input.nextLine();
				
				System.out.println("Name: " + this.getName());
				System.out.println("Age : " + (1400 - year));
				
				Main.askToQuit();
			}
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("End of " + this.getName());
	}
}

class Thread2 extends Thread {
	@Override
	public void run() {
		while (!Main.quit) {
			synchronized (Main.input) {
				if (Main.quit)
					break;
				
				System.out.print("Number: ");
				int number = Main.input.nextInt();
				Main.input.nextLine();
				
				System.out.println("Name: " + this.getName());
				System.out.println("isPrime: " + isPrime(number));
				
				Main.askToQuit();
			}
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("End of " + this.getName());
	}
	
	private boolean isPrime(int number) {
		int counter = 0;
		
		for (int i = 1; i <= number; i++)
			if (number % i == 0)
				counter++;
		
		return counter == 2;
	}
}

class Thread3 extends Thread {
	int[] votes;
	
	public Thread3() {
		this.votes = new int[5];
	}
	
	@Override
	public void run() {
		while (!Main.quit) {
			synchronized (Main.input) {
				if (Main.quit)
					break;
				
				System.out.println("1) Bijan");
				System.out.println("2) Reza");
				System.out.println("3) Mohammad Hussein");
				System.out.println("4) Mahan");
				System.out.println("5) Seyed");
				
				System.out.print("Index: ");
				int index = Main.input.nextInt();
				Main.input.nextLine();
				
				votes[index - 1]++;
				
				System.out.println();
				System.out.println("Name: " + this.getName());
				System.out.println("Bijan           : " + votes[0]);
				System.out.println("Reza            : " + votes[1]);
				System.out.println("Mohammad Hussein: " + votes[2]);
				System.out.println("Mahan           : " + votes[3]);
				System.out.println("Seyed           : " + votes[4]);
				
				Main.askToQuit();
			}
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("End of " + this.getName());
	}
}
