package tk.craftxbox.main;

import java.util.Scanner;

import javax.script.ScriptException;

import tk.craftxbox.cmdlib.CommandStore;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		CommandStore cs = new CommandStore();
		while(true) {
			String in = s.nextLine();
			if(cs.commands.get(in) != null)
				try {
					try {
						System.out.println(cs.exec(in.split(" ")[0], in.substring(in.split(" ")[0].length() + 1).split(" ")));

					} catch (StringIndexOutOfBoundsException e) {
						System.out.println(cs.exec(in.split(" ")[0],null));
					}
				} catch (ScriptException e) {
					e.printStackTrace();
				}
			if(in.startsWith("exit")) break;
			if(in.startsWith("reload")) cs.reload();
		}
		s.close();
	}
}
