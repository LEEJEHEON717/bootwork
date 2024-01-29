package com.khit.board.jsondata;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiJson {

	public static void main(String[] args) {
		try {
			//지진 해일 대피소 데이터 테스트
			String serviceKey = "https://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List?serviceKey=e%2FdwMCtondcOWd9nggOD9uG06gt3c6p5aqokquWC9vMeCnmr%2FcjE10ZMQEx7iTQ43jsL1xsQzlKzQ8BsJBls8g%3D%3D&pageNo=1&numOfRows=10&type=json";
			String url = 
				url += "?serbiceKey=" + serviceKey;
				url += "pageNo=1";
				url += "&numOfRows=20";
				url += "type=json";
			//데이터를 받기 위해서 URL 클래스의 객체 생성
			URL requesstUrl = new URL(url);
			
			//openConnection()을 이용한 연결
			HttpURLConnection = (HttpURLConnection)requesstUrl.openConnection();
					conn.setRequestMethod("GET"); //대문자로 명시함
					
			//응답 상태 코드(200, 403,404, 500)
			int status = conn.getResponseCode();
			System.out.print(status);
			
			//버퍼: 입출력소도 향상을 위해서 데이터를 일시적으로 메모리 영역에 모아두는
			//BufferReader(보조스트림) : 기반스트림(생성자) - InputStream
			InputStreamReader isr = new InputStreamReader(conn.getInput);
			BufferedReader br = new BufferedReader(isr);
			
			String responseText = "";
			String line; //한 행에 있는 데이터
			while((line = br.readLine())  != null) {
				responseText += line;
			}
			System.out.println(responseText);
			
			br.close();  bt 종료
			conn.disconnect(); //연결 종료
			
			return responseText
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (ProtocolExceprion e) {
				e.printStackTrace();
			}
			
			System.out.println(url);
	}
	

}
