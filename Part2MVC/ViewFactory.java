package Part2MVC;

public class ViewFactory {
	static SafeView safeview;
	
	public static SafeView getSingleton() {
		if (safeview == null) {
			safeview = new ConsoleView();
		}
		return safeview;
	}
	
	public static void setSafeView(SafeView newview) {
		safeview = newview;
	}
	

}
