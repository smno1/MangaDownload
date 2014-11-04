package utils.downloadutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import type.MangaType;
import type.MangaWebSite;
import utils.DownloadThread;

public class SFDownloadBrain extends DownloadBrain {
	static final String PIC_ADDRS = "http://pic3.sfacg.com";

	@Override
	public void Download(String location, MangaType mt, int startEp, int endEp) {
		for (int i = startEp; i <= endEp; Download(location, mt, i), i++)
			;
	}

	@Override
	public <T> void Download(String location, MangaType mt, T episode) {
		String jsAddrs = MangaWebSite.SFOnline.getAddress()
				+ mt.getSubAddress() + episode + ".js";
		String fileLocation = location + mt.getTitle() + "/" + episode;
		try {
			String contents = getJSContents(jsAddrs);
			int picNum = getPicNum(contents);
			File dir = new File(fileLocation);
			dir.mkdirs();
			for (int i = 0; i < picNum; i++) {
				DownloadThread t = new DownloadThread("Thread" + i, PIC_ADDRS
						+ getPicSubAddrs(contents, i), fileLocation);
				t.start();
				// downloadPage(PIC_ADDRS + getPicSubAddrs(contents, i),
				// fileLocation);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fileLocation);
	}

	private String getJSContents(String jsAddrs) throws IOException {
		URL url = new URL(jsAddrs);
		URLConnection urc = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				urc.getInputStream()));
		String inputLine, contents = "";
		while ((inputLine = br.readLine()) != null)
			contents += inputLine;
		return contents;
	}

	private int getPicNum(String contents) throws Exception {
		return Integer.parseInt((String) findSubStringViaRegex(
				"picCount = (\\d*);", contents, "can't find picCount "));
	}

	private String getPicSubAddrs(String contents, int pageNum)
			throws Exception {
		return (String) findSubStringViaRegex("picAy\\[" + pageNum
				+ "\\] = \"(.*?)\"", contents, "can't find page " + pageNum);
	}

	private Object findSubStringViaRegex(String regex, String contents,
			String errorMessage) throws Exception {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(contents);
		if (!matcher.find()) {
			throw new Exception(errorMessage);
		}
		return matcher.group(1);
	}

}
