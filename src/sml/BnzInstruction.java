package sml;

/**
 * This class ....
 * 
 * @author someone
 */

public class BnzInstruction extends Instruction {

	private int op1;
	private String targetLabel;

	public BnzInstruction(String label, String op) {
		super(label, op);
	}

	public BnzInstruction(String label, int op1, String targetLabel) {
		this(label, "bnz");
		this.op1 = op1;
		this.targetLabel = targetLabel;
	}

	@Override
	public void execute(Machine m) {
		int value1 = m.getRegisters().getRegister(op1);
		if (value1 != 0) {
			m.setPc(m.getLabels().indexOf(targetLabel));
		}
	}

	@Override
	public String toString() {
		return super.toString() + " " + op1 + " to " + targetLabel;
	}
}
