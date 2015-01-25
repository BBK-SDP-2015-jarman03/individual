package sml;

/**
 * An Instruction to subtract two numbers
 * 
 * @author someone
 */

public class MulInstruction extends ThreeRegInstruction {

	public MulInstruction(String label) {
		super(label);
	}

	public MulInstruction(String label, int result, int op1, int op2) {
		super(label, result, op1, op2);
	}

	@Override
	public void execute(Machine m) {
		int value1 = m.getRegisters().getRegister(op1);
		int value2 = m.getRegisters().getRegister(op2);
		m.getRegisters().setRegister(result, value1 * value2);
	}

	@Override
	public String toString() {
		return super.toString() + " " + op1 + " * " + op2 + " to " + result;
	}

	@Override
	public String getOpcode() {
		return "mul";
	}
}
