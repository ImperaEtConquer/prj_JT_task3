package view;

public class View {
	
	public void printMessage(String message) {
		System.out.println(message);
	}
	
	public void printErrorMessage() {
		System.err.println(Messages.ERROR);	
	}
	
	public void printInputMessage(String inputVariable) {
		printMessage(concatStrings(inputVariable));
	}
	
	private String concatStrings(String inputVariable) {
		StringBuilder sb = new StringBuilder();
		sb.append(Messages.PLEASE_INPUT).append(GlobalConstants.SPACE).append(inputVariable).append(GlobalConstants.DOT);
		return sb.toString();
	}
	
	
}
