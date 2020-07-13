import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println("Making root entries...");
			Directory rootdir = new Directory("root");
			Directory bindir = new Directory("bin");
			Directory tmpdir = new Directory("tmp");
			Directory usrdir = new Directory("usr");
			rootdir.add(bindir);
			rootdir.add(tmpdir);
			rootdir.add(usrdir);
			bindir.add(new File("vi.html", 10000));
			bindir.add(new File("latex.java", 10000));
			bindir.add(new File("index.html", 10000));
			rootdir.accept(new ListVisitor());

			FileFindVisitor ffv = new FileFindVisitor(".html");
			rootdir.accept(ffv);

			Iterator it = ffv.getFoundFiles();
			while(it.hasNext()){
				File file = (File)it.next();
				System.out.println(file.getName());
			}
		} catch (FileTreatmentException e) {
			e.printStackTrace();	
		}
	}
}
