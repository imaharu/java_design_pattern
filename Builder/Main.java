public class Main {
	public static void main(String[] args){
		if(args[0].equals("plain")) {
			TextBuilder textbuilder = new TextBuilder();
			Director director = new Director(textbuilder);
			director.construct();
			String result = textbuilder.getResult();
			System.out.println(result);
		} else if (args[0].equals("html")){
			HTMLBuilder htmlbuilder = new HTMLBuilder();
			Director director = new Director(htmlbuilder);
			director.construct();
			String result = htmlbuilder.getResult();
			System.out.println(result);
		}
	}
}
