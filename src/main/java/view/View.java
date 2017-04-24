package view;

public class View {
	
	public void printMessage(String message) {
		System.out.println(message);
	}
	
	public void printErrorMessage(String errorMessage) {
		System.err.println(errorMessage);	
	}
	
	public String createInputMessage(String inputVariable) {
		StringBuilder sb = new StringBuilder();
		
	}
	
	private String concatStrings(String...strings) {
		StringBuilder sb = new StringBuilder();
		for (String s : strings) {
			sb.append(s);
		}
		return sb.toString();
	}
	
	
}
