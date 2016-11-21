package test;

import java.util.Scanner;

import org.rosuda.JRI.Rengine;

public class RSample {

	static void print(String s) {
		System.err.println(s);
	}

	static void eval(Rengine r, String s) {
		r.eval(s, false);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String input;

		if (!Rengine.versionCheck()) {
			System.err.println("** Version mismatch - Java files don't match library version.");
			System.exit(1);
		}

		print("creating Rengine");

		Rengine re = new Rengine(args, false, null);

		print("Rengine created, waiting for R");

		// the engine creates R is a new thread, so we should wait until it's
		// ready
		if (!re.waitForR()) {
			System.out.println("Cannot load R");
			return;
		}

		print("R is running");
		print("Enter command for R (exit by typing \"end\")");
		while(true){
			  input = stdIn.nextLine();
			  if(input.equals("end"))
				  break;
			  System.out.println(re.eval(input));
		}

		print("stopping Rengine");

		re.end(); // stop the Rengine

		return;
	}
}
