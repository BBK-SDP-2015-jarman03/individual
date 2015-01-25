package sml;
/**
 * This is an abstract superclass for instructions that
 * take one register and one label.
 * 
 * @author joel
 */

public abstract class OneRegOneLabelInstruction extends Instruction {
	protected int register;
	protected String targetLabel;
	
	// Constructor: an instruction with label label 
	public OneRegOneLabelInstruction(String label) {
		super(label);
	}
	
	// Constructor: an instruction with label label, int register and String targetLabel
	public OneRegOneLabelInstruction(String label, int register, String targetLabel) {
		super(label);
		this.register = register;
		this.targetLabel = targetLabel;
	}
}

