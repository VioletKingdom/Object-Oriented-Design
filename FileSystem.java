/*
clarification:
in-memory
consists of different types : txt, gif, java, directory
class API: create, remove, update, search, Is, sort, moveFiles

use cases:
1 need to know file, directories size
2 allow to create, delete, move files and directories
3 how many files under the current directory

                                   root
                      /              \             \
                   file1           file2        directory1
                   /\               /\            /\ 



looks like a k-nary tree

*/

public asbtract class Entity{
	private String name;
	private long size;
	private Date createdAt;
	private Date updatedAt;
	private Entity parent;
	public boolean isFile;

	// getter and setter
	public abstract long getSize();
	public abstract String getAbsolutePath(); 
}

public class File extends Entity {
	private String content;
	@Override
	public long getSize() {
		return this.size;
	}

	@Override
	public String getAbsolutePath(){
		List<String> paths = new ArrayList<>();
		while (this.getParent != null){
			String file_name = this.getName();
			paths.add(file_name);
			this = this.parent;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = paths.size()-1; i >= 0; i--){
			sb.append("/").append(paths.get(i));
		}
		return sb.toString();
	}
}

public class Directory extends Entity {
	TreeSet<Entity> children;
	@Override
	public long getSize(){
		long size = 0;
		for (Entity e : children){
			size += e.getSize();
		}
		return size;
	}

	@Override
	public String getAbsolutePath(){
		List<String> paths = new ArrayList<>();
		while (this.parent != null){
			String file_name = this.getName();
			paths.add(file_name);
			this = this.parent;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = paths.size()-1; i >= 0; i--){
			sb.append("/").append(paths.get(i));
		}
		return sb.toString();
	}
}

public class FileSystem{
	public Entity root;
	public FileSystem(Config config){
		root = new Directory(...config...);
	}
	public List<String> ls(String path){
		String[] p = path.split("/");
		Entity cur = root;
		for (int i = 0; i < p.length; i++){
			if (p[i].empty()) continue;
			// look up -> cur.getChildren().contains(p[i]);
			// if look up failed, early return
			cur = cur.getChildren.get(p[i]);
			// construct absolute path
			if (cur.isFile) return cur.getAbsolutePath();
			for (iterate all children under cur node){
				...
			}
		}
	}

	public void mkdir(String path){
		String[] p = path.split("/");
		Entity cur = root;
		for (int i = 0; i < p.length; i++){
			if (p[i].empty()) continue;

			cur = cur.getChildern.get(p[i]);
		}
	}

	public void addContentToFile(String filePath, String content){

	}

	public String readContentFromFile(String filePath){
		
	}

}

