package type;

public enum MangaType {
	Gintama(0, "Utility/231/", "Gintama"), 
	OnePiece(1, "Utility/2/", "OnePiece"),
	Naruto(2,"Utility/4/","Naruto"),
	Bleach(3,"Utility/19/","Bleach"),
	CoNan(4,"Utility/333/","CoNan"),
	FairyTail(5,"Utility/348/","FairyTail");

	private int code;
	private String subAddress;
	private String title;

	public String getSubAddress() {
		return subAddress;
	}

	public String getTitle() {
		return title;
	}

	public int getCode() {
		return code;
	}

	MangaType(int i, String s, String title) {
		this.code = i;
		this.subAddress = s;
		this.title = title;
	}
}
