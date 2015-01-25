package sml;

/**
 * This class ....
 * 
 * @author someone
 */

public class LinInstruction extends OneRegOneIntInstruction {

	public LinInstruction(String label) {
		super(label);
	}

	public LinInstruction(String label, int register, int value) {
		super(label, register, value);
	}

	@Override
	public void execute(Machine m) {
		m.getRegisters().setRegister(register, value);
	}

	@Override
	public String toString() {
		return super.toString() + " register " + register + " value is " + value;
	}

	@Override
	public String getOpcode() {
		return "lin";
	}
}
