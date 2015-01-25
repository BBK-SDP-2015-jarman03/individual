package sml;

/**
 * An instruction to make the statement labeled "targetLabel" the 
 * next one to execute, if the contents of the given register is not zero 
 * 
 * @author someone
 */

public class BnzInstruction extends OneRegOneLabelInstruction {

	public BnzInstruction(String label) {
		super(label);
	}

	public BnzInstruction(String label, int register, String targetLabel) {
		super(label, register, targetLabel);
	}

	@Override
	public void execute(Machine m) {
		int value1 = m.getRegisters().getRegister(register);
		if (value1 != 0) {
			m.setPc(m.getLabels().indexOf(targetLabel));
		}
	}

	@Override
	public String toString() {
		return super.toString() + " " + register + " to " + targetLabel;
	}

	@Override
	public String getOpcode() {
		return "bnz";
	}
}
