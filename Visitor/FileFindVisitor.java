import java.util.ArrayList;
import java.util.Iterator;

class FileFindVisitor extends Visitor {
	private ArrayList<File> dir = new ArrayList<File>();
	private String filetype;
	public FileFindVisitor(String filetype) {
		this.filetype = filetype;
	}
	public Iterator getFoundFiles() {
		return dir.iterator();
	}
	public void visit(File file) {
		if(file.getName().endsWith(filetype)){
			dir.add(file);
		}
	}
	public void visit(Directory directory){
		Iterator it = directory.iterator();
		while(it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.accept(this);
		}
	}
}
