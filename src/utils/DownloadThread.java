package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadThread extends Thread {
	private String addrs,location;
	public DownloadThread(String s,String addrs,String location){
		super(s);
		this.addrs=addrs;
		this.location=location;
	}
	public void run(){
		try {
			downloadPage(this.addrs,this.location);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void downloadPage(String addrs, String location) throws IOException {
		System.out.println(addrs);
		URL url = new URL(addrs);
		URLConnection urc = url.openConnection();
		String[] pageNum=addrs.split("/");
		InputStream input = urc.getInputStream();
		File file = new File(location+"/"+pageNum[pageNum.length-1]);
		if (!file.exists()) {
			file.createNewFile();
		}else{
			return;
		}
		//===========to do: separate method==================================
		byte[] buffer = new byte[4096];
		int n = - 1;

		OutputStream output = new FileOutputStream( file );
		while ( (n = input.read(buffer)) != -1)
		{
		    if (n > 0)
		    {
		        output.write(buffer, 0, n);
		    }
		}
		output.close();
		//===========================================

	}
}
