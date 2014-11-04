package factory;

import type.MangaWebSite;
import utils.downloadutil.DownloadBrain;
import utils.downloadutil.SFDownloadBrain;

public class DownloadUtilFactory {
	public static DownloadBrain getDownloadUtil(MangaWebSite mws){
		if(mws.getCode()==0){
			return new SFDownloadBrain();
		}
		//default brain
		return new SFDownloadBrain();
	}
}
