package type;

public enum MangaWebSite {
	//IMH(1,"http://www.imanhua.com/"),
	SFOnline(0,"http://comic.sfacg.com/");
	
	private int code;
	private String address;
	
	public String getAddress() {
		return address;
	}

	MangaWebSite(int c,String a){
		this.code=c;
		this.address=a;
	}

	public int getCode() {
		return code;
	}
}
