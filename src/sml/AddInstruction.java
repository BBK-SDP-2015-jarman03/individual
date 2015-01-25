package sml;

/**
 * An instruction that add two numbers.
 * 
 */

public class AddInstruction extends ThreeRegInstruction {

	public AddInstruction(String label) {
		super(label);
	}

	public AddInstruction(String label, int result, int op1, int op2) {
		super(label, result, op1, op2);
	}

	@Override
	public void execute(Machine m) {
		int value1 = m.getRegisters().getRegister(op1);
		int value2 = m.getRegisters().getRegister(op2);
		m.getRegisters().setRegister(result, value1 + value2);
	}

	@Override
	public String toString() {
		return super.toString() + " " + op1 + " + " + op2 + " to " + result;
	}

	@Override
	public String getOpcode() {
		return "add";
	}
}
