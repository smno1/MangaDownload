package test;

import org.junit.Test;

import type.MangaType;
import utils.downloadutil.SFDownloadBrain;

public class SFDownloadBrainTest {
	@Test
	public void testDownload(){
		SFDownloadBrain sfdb=new SFDownloadBrain();
		sfdb.Download("",MangaType.Gintama, 116);
		sfdb.Download("",MangaType.Gintama, 417, 418);
	}
}
