package test;

import org.junit.Test;

import factory.DownloadUtilFactory;
import type.MangaType;
import type.MangaWebSite;
import utils.downloadutil.DownloadBrain;
import utils.downloadutil.SFDownloadBrain;

public class SFDownloadBrainTest {
	@Test
	public void testDownload(){
		DownloadBrain db=DownloadUtilFactory.getDownloadUtil(MangaWebSite.SFOnline);
		//db.Download("../../../Dropbox/",MangaType.Gintama, 477);
		//db.Download("../../../Dropbox/",MangaType.OnePiece, "001j");
		//db.Download("../../../Dropbox/",MangaType.OnePiece, 711);
		//db.Download("../../../Dropbox/",MangaType.Naruto, 688);
		//db.Download("../../../Dropbox/",MangaType.CoNan, 850);
		//db.Download("../../../Dropbox/",MangaType.Bleach, 350);
		
		//example
		//one episode in current directory
		db.Download("",MangaType.FairyTail,800);
		//if you want to download multiple episodes using following interface
		//for example download YingHun from 455-460
		//db.Download("",MangaType.YingHun, 455,460);
	}
}
