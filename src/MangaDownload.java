import type.MangaType;
import type.MangaWebSite;
import utils.downloadutil.DownloadBrain;
import factory.DownloadUtilFactory;


public class MangaDownload {
	public static void main(String[] args){
		DownloadBrain db=DownloadUtilFactory.getDownloadUtil(MangaWebSite.SFOnline);
		db.Download("../../../Dropbox/",MangaType.Gintama, 476);
		//db.Download("../../../Dropbox/",MangaType.OnePiece, "001j");
		//db.Download("../../../Dropbox/",MangaType.OnePiece, 711);
		//db.Download("../../../Dropbox/",MangaType.Naruto, 688);
		//db.Download("../../../Dropbox/",MangaType.CoNan, 850);
		//db.Download("../../../Dropbox/",MangaType.Bleach, 350);
		
		//example
		//one episode in current directory
		//db.Download("",MangaType.YingHun,461);
		//if you want to download multiple episodes using following interface
		//for example download YingHun from 455-460
		//db.Download("",MangaType.YingHun, 455,460);
	}
}
