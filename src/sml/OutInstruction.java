package sml;

/**
 * An instruction that prints out the contents of a register.
 * 
 * @author someone
 */

public class OutInstruction extends OneRegInstruction {

	public OutInstruction(String label) {
		super(label);
	}

	public OutInstruction(String label, int register) {
		super(label, register);
	}

	@Override
	public void execute(Machine m) {
		int value1 = m.getRegisters().getRegister(register);
		System.out.println("Out: " + value1);
	}

	@Override
	public String toString() {
		return super.toString() + " " + register;
	}

	@Override
	public String getOpcode() {
		return "out";
	}
}