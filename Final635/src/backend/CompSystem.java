package backend;

public final class CompSystem {

	private Processor p;
	private HardDrive hd;
	private Memory memory;

	public Processor getProcessor() {
		return p;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory mem) {
		memory = mem;
	}

	public void setProcessor(Processor p1) {
		p = p1;
	}

	public void setHardDrive(HardDrive hd1) {
		hd = hd1;
	}

	public HardDrive getHardDrive() {
		return hd;
	}
}
