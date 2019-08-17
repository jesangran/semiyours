package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File originFile) {
		//현재시간 + 랜덤5자리를 이용하여 파일명 변경
		long currentTime = System.currentTimeMillis();
		Date date = new Date(currentTime);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		// 0~99999
		
		int ranNum = (int)(Math.random()*90000)+10000;
		
		String name = originFile.getName();
		String ext =null;
		int dot = name.lastIndexOf(".");
		if(dot!=-1) {
			ext = name.substring(dot);
		}else{
			ext = "";
		}
		
		//변경된 파일명 
		String fileName = sdf.format(date)+ranNum + ext;
		File newFile = new File(originFile.getParent(),fileName);
		
		
		
		return newFile;
	}
	
	
	
}
