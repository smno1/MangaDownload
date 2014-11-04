package utils.downloadutil;

import type.MangaType;

public abstract class DownloadBrain {
	
	public abstract <T> void Download(String location,MangaType mt,T episode);
	public abstract void Download(String location,MangaType mt,int startEp,int endEp);
}
