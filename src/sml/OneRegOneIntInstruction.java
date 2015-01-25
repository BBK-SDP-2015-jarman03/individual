package sml;
/**
 * This is an abstract superclass for instructions that
 * take one register as a destination for an integer value.
 * 
 * @author joel
 */

public abstract class OneRegOneIntInstruction extends Instruction {
	protected int register;
	protected int value;
	
	// Constructor: an instruction with label label 
	public OneRegOneIntInstruction(String label) {
		super(label);
	}
	
	public OneRegOneIntInstruction(String label, int register, int value) {
		this(label);
		this.register = register;
		this.value = value;
	}
}
