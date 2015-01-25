package sml;
/**
 * This is an abstract superclass for instructions that
 * take three registers: a destination and two operands.
 * 
 * @author joel
 */

public abstract class ThreeRegInstruction extends Instruction {
	protected int op1;
	protected int op2;
	protected int result;

	// Constructor: an instruction with label label 
	public ThreeRegInstruction(String label) {
		super(label);
	}
	
	public ThreeRegInstruction(String label, int result, int op1, int op2) {
		super(label);
		this.result = result;
		this.op1 = op1;
		this.op2 = op2;
	}
}
