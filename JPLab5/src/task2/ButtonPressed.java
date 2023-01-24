package task2;

public enum ButtonPressed {
    ABC("abc"),
	DEF("def"),
	GHI("ghi"),
	JKL("jkl"),
	MNO("mno"),
	PQR("pqr"),
	STUV("stuv"),
	WXYZ("wxyz"),
	OTHER("");

	private final String letters;
	
	ButtonPressed(String string) {
		this.letters = string;
	} 
	
	@Override 
	public String toString() {
		return this.letters;
	}

}
