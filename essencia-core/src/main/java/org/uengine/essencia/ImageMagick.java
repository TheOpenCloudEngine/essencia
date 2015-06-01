package org.uengine.essencia;

public class ImageMagick {

	public void convertFile(String fromFile, String toFile){
		  
		try {
			// 주의점!! /usr/local/share/fonts/NanumMyeongjo.ttf 경로에 ttf 파일이 있어야함.. 
			/**
			 * 리눅스에서 ImageMagick 설치
			 * apt-get install imagemagick
			 * apt-get install html2ps
			 * /usr/local/share/fonts/NanumMyeongjo.ttf 파일 넘기기.( 한글 처리를 위하여 폰트 적용 )
			 */
//			String cmd = "/usr/bin/convert -stroke white -font /usr/local/share/fonts/NanumMyeongjo.ttf " + fromFile + " " + toFile;
//			System.out.println("===================");
//			System.out.println(cmd);
//			System.out.println("===================");
			/**
			 * 아래 cmd 는 window 용
			 * 해당경로에 ImageMagick-6.8.7-Q16 버전으로 설치해 주세요
			 */
			String cmd = "c:/ImageMagick-6.8.8-Q16/convert.exe -stroke white -font Malgun-Gothic " + fromFile + " " + toFile;
			Process p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
//            System.out.println(p.exitValue());
            p.destroy();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
