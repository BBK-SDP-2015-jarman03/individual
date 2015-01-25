package sml;
/**
 * This is an abstract superclass for instructions that
 * take one register.
 * 
 * @author joel
 */

public abstract class OneRegInstruction extends Instruction {
	protected int register;
	
	// Constructor: an instruction with label l 
	public OneRegInstruction(String label) {
		super(label);
	}
	
	public OneRegInstruction(String label, int register) {
		this(label);
		this.register = register;
	}
}
