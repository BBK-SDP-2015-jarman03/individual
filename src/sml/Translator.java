package sml;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
public class Translator {

	// word + line is the part of the current line that's not yet processed
	// word has no whitespace
	// If word and line are not empty, line begins with whitespace
	private String line = "";
	private Labels labels; // The labels of the program being translated
	private ArrayList<Instruction> program; // The program to be created
	private String fileName; // source file of SML code

	private static final String SRC = "src";

	public Translator(String fileName) {
		this.fileName = SRC + "/" + fileName;
	}

	// translate the small program in the file into lab (the labels) and
	// prog (the program)
	// return "no errors were detected"
	public boolean readAndTranslate(Labels lab, ArrayList<Instruction> prog) {

		try (Scanner sc = new Scanner(new File(fileName))) {
			// Scanner attached to the file chosen by the user
			labels = lab;
			labels.reset();
			program = prog;
			program.clear();

			try {
				line = sc.nextLine();
			} catch (NoSuchElementException ioE) {
				return false;
			}

			// Each iteration processes line and reads the next line into line
			while (line != null) {
				// Store the label in label
				String label = scan();

				if (label.length() > 0) {
					Instruction ins = getInstruction(label);
					if (ins != null) {
						labels.addLabel(label);
						program.add(ins);
					}
				}

				try {
					line = sc.nextLine();
				} catch (NoSuchElementException ioE) {
					return false;
				}
			}
		} catch (IOException ioE) {
			System.out.println("File: IO error " + ioE.getMessage());
			return false;
		}
		return true;
	}

	// line should consist of an MML instruction, with its label already
	// removed. Translate line into an instruction with label label
	// and return the instruction
	public Instruction getInstruction(String label) {
		
		if (line.equals("")) {
			return null;
		}

		String ins = scan();
		String className = "sml." + capitalize(ins) + "Instruction";
		Class<?> cls;
		try {
			cls = Class.forName(className);
			if (ThreeRegInstruction.class.isAssignableFrom(cls)) {
				Constructor<?> c = cls.getConstructor(String.class,
						Integer.TYPE, Integer.TYPE, Integer.TYPE);
				return (Instruction) c.newInstance(label, scanInt(), scanInt(),
						scanInt());
			} else if (OneRegOneIntInstruction.class.isAssignableFrom(cls)) {
				Constructor<?> c = cls.getConstructor(String.class,
						Integer.TYPE, Integer.TYPE);
				return (Instruction) c.newInstance(label, scanInt(), scanInt());
			} else if (OneRegOneLabelInstruction.class.isAssignableFrom(cls)) {
				Constructor<?> c = cls.getConstructor(String.class,
						Integer.TYPE, String.class);
				return (Instruction) c.newInstance(label, scanInt(), scan());
			} else if (OneRegInstruction.class.isAssignableFrom(cls)) {
				Constructor<?> c = cls.getConstructor(String.class,
						Integer.TYPE);
				return (Instruction) c.newInstance(label, scanInt());
			} else {
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
				
	/*
	 * Return the first word of line and remove it from line. If there is no
	 * word, return ""
	 */
	
	private String scan() {
		line = line.trim();
		if (line.length() == 0)
			return "";

		int i = 0;
		while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '\t') {
			i = i + 1;
		}
		String word = line.substring(0, i);
		line = line.substring(i);
		return word;
	}

	// Return the first word of line as an integer. If there is
	// any error, return the maximum int
	private int scanInt() {
		String word = scan();
		if (word.length() == 0) {
			return Integer.MAX_VALUE;
		}

		try {
			return Integer.parseInt(word);
		} catch (NumberFormatException e) {
			return Integer.MAX_VALUE;
		}
	}
	
	private String capitalize(String line) {
		  return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}
}