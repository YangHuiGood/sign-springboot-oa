package cn.tedu.sign.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.aip.util.Base64Util;
import com.fasterxml.jackson.core.JsonProcessingException;

import cn.tedu.common.util.UUIDUtil;


@RestController
@RequestMapping("/face")
public class FaceController {
	
	/**
	 * 注册人脸，返回路径
	 * @throws IOException 
	 * @throws JsonProcessingException 
	 */
	@RequestMapping("/regist")
	public String faceRegist(@RequestBody String image) throws JsonProcessingException, IOException{
		System.out.println(image);
	    String fileName = UUIDUtil.getUUID().toString()+(new Date()).getTime()+".png";
	    String[] info=image.split(",");
	    for(String str:info){
	    	System.out.println(str);
	    }
	    String path=info[2];
	    String img=info[1];
	    System.out.println(path);
	    System.out.println(img);
	    Boolean flag = GenerateImage(img, path, fileName);
	    String result = "";
	    if (flag) {
	        result ="http://image.oa.com/"+fileName;
	    }
	    System.out.println(result);
	    return result;
		
	}
	
	
	/**
	 * 生成回传图片
	 * @param imgStr
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	
	public boolean GenerateImage(String imgStr, String filePath, String fileName) {
	    try {
	        if (imgStr == null) {
	            return false;
	        }
	        Base64Util decoder = new Base64Util();
	        byte[] b = decoder.decode(imgStr);
	        
	        File file = new File(filePath);
	        if (!file.exists()) {
	            file.mkdirs();
	        }
	        OutputStream out = new FileOutputStream(filePath+"/"+ fileName);
	        out.write(b);
	        out.flush();
	        out.close();
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
}
