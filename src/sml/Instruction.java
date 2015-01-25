package sml;

/**
 * This class is the superclass of the classes for machine instructions
 * 
 * @author someone
 */

public abstract class Instruction {
	protected String label;
	
	// Constructor: an instruction with label label 

	public Instruction(String label) {
		this.label = label;
	}
	
	//returns the opcode for the instruction
	public abstract String getOpcode();

	// = the representation "label: opcode" of this Instruction

	@Override
	public String toString() {
		return label + ": " + getOpcode();
	}

	// Execute this instruction on machine m.

	public abstract void execute(Machine m);
}
