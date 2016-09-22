package com.hebut.upload;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
* @ClassName: FileUpload
* @author YangXuan
* @date Aug 4, 2013 1:27:00 PM
*
*/
@Controller
public class FileUpload extends HttpServlet {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 1L;
	private final String uploadLocation = "fileupload\\";
	private final String imageLocation = "images\\";
	private final String otherLocation = "others\\";
	private final String imageThumnailLoation = "thumnail\\";

	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	@ResponseBody
	public String upload(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

	/*	MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 获取前台传值
		String[] userNames = multipartRequest.getParameterValues("userName");
		String[] contents = multipartRequest.getParameterValues("content");
		String userName = "";
		String content = "";
		if (userNames != null) {
			userName = userNames[0];
			System.out.println("userName:" + userName);
		}
		if (contents != null) {
			content = contents[0];
			System.out.println("content:" + content);
		}
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		// 上传到服务端的路径
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ uploadLocation;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String ymd = sdf.format(new Date());

		String originalFileName = null;
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			// 上传文件名
			System.out.println("key: " + entity.getKey());
			System.out.println("value: " + entity.getValue());

			MultipartFile mf = entity.getValue();
			originalFileName = mf.getOriginalFilename();
			String fileExt = originalFileName.substring(
					originalFileName.lastIndexOf(".") + 1).toLowerCase();

			// new file name
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
			String newFileName = df.format(new Date()) + "_"
					+ System.currentTimeMillis() + "." + fileExt;

			// 是image则进入此处开始执行
			if (fileExt.equals("jpg") || fileExt.equals("png")) {

				// 创建image文件夹，字目录按日期来分
				String uploadFolder = ctxPath + imageLocation + ymd + "/";
				File imageFile = new File(uploadFolder);
				if (!imageFile.exists()) {
					imageFile.mkdirs();
				}
				String uploadFileLocation = uploadFolder + newFileName;
				if (this.htmlUpload(mf.getInputStream(), uploadFileLocation)) {
					System.out.println(" ------- image upload success");

					// 如果图片上传成功，那么就要生成缩略图
					String thumnailFileName = "thum_" + newFileName;
					String uploadFolder2 = ctxPath + imageLocation
							+ imageThumnailLoation + ymd + "/";
					File imageThumnailFile = new File(uploadFolder2);
					if (!imageThumnailFile.exists()) {
						imageThumnailFile.mkdirs();
					}
					BufferedImage bi = ImageIO.read(mf.getInputStream());
					if (bi != null) {
						String uploadFileLocation2 = uploadFolder2
								+ thumnailFileName;
						if (this.uploadJPGfile(bi, uploadFileLocation2)) {
							System.out
									.println(" ------- generate thumnail success");
						} else {
							System.out
									.println(" ------- generate thumnail fail");
						}
					}
					return "image file upload success";
				} else {
					System.out.println(" ------- image upload fail");
					return "image file upload fail";
				}
			}
			// 不是image则调到此处开始执行
			else {
				// 创建others文件夹，字目录按日期来分
				String uploadFolder3 = ctxPath + otherLocation + ymd + "/";
				File otherFile = new File(uploadFolder3);
				if (!otherFile.exists()) {
					otherFile.mkdirs();
				}
				String uploadFileLocation = uploadFolder3 + newFileName;
				if (this.htmlUpload(mf.getInputStream(), uploadFileLocation)) {
					System.out.println(" ------- other upload success");
					return "other file upload success";
				} else {
					System.out.println(" ------- other upload fail");
					return "other file upload fail";
				}
			}

		}*/
		return null;
	}

	/**
	* @Title: htmlUpload
	* @param @param inputStream	传进一个流
	* @param @param uploadFile		服务端输出的路径和文件名
	* @return boolean    返回类型
	* @throws
	*/
	private boolean htmlUpload(InputStream inputStream, String uploadFile) {
		try {
			byte[] buff = new byte[4096]; // 缓冲区
			FileOutputStream output = new FileOutputStream(uploadFile); // 输出流
			int bytecount = 1;
			while ((bytecount = inputStream.read(buff, 0, 4096)) != -1) { // 当input.read()方法，不能读取到字节流的时候，返回-1
				output.write(buff, 0, bytecount); // 写入字节到文件
			}
			output.flush();
			output.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	* @Title: uploadJPGfile
	* @param @param img
	* @param @param uploadFileLocation2	服务端输出的路径和文件名
	* @return boolean    返回类型
	* @throws
	*/
	public boolean uploadJPGfile(BufferedImage img, String uploadFileLocation2) {
		try {
			// 转为jpg标准格式//
			if (img != null) {
				int new_w = 150;
				int new_h = 100;
				BufferedImage tag = new BufferedImage(new_w, new_h,
						BufferedImage.TYPE_INT_RGB);
				tag.getGraphics().drawImage(img, 0, 0, new_w, new_h, null); // 绘制缩小后的图
				FileOutputStream out = new FileOutputStream(uploadFileLocation2);
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				encoder.encode(tag);
				out.close();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("异常错误！");
			return false;
		}
	}
}
