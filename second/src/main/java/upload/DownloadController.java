package upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.MyWebConfig;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {
	
	// c:/upload 파일리스트 출력
	@RequestMapping("/filelist")
	public ModelAndView downloadlist() {
		ModelAndView mv = new ModelAndView();
//		File f = new File("c:/upload");
		File f = new File(MyWebConfig.savePath);
		String[] filelist = f.list();
		mv.addObject("filelist", filelist);
		mv.setViewName("upload/filelist");
		
		return mv;
	}
	
	@RequestMapping("/filedownload")
	public void filedownload(String onefile, HttpServletResponse response) throws IOException {
//		File f = new File("c:/upload/" + onefile);
		File f = new File(MyWebConfig.savePath + onefile);
		int f_length = (int)f.length();		// byte 단위이다. long 타입으로 반환되기에 int로 형변환 해야 한다.
	
		// 응답할 컨텐츠의 다운로드 파일
		// 컨텐츠 길이 필요한 이유 : 이 때까지 다운로드 하라고 정해줘야 한다.
		response.setContentType("application/download");
		response.setContentLength(f_length);
		response.setHeader("Content-Disposition", "attachment;filename=\"" + onefile + "\"");
		
		OutputStream out = response.getOutputStream();
		FileInputStream f_in = new FileInputStream(f);
		FileCopyUtils.copy(f_in, out);
		f_in.close();
		out.close();
		
	}
	
}
