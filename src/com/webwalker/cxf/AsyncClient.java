package com.webwalker.cxf;

import java.io.StringReader;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import javax.xml.ws.Service;
import javax.xml.ws.Service.Mode;

import org.xml.sax.InputSource;

public class AsyncClient {
	private static String payload = "<ns1:sayHello xmlns:ns1='http://test/'>"
			+ "	<arg0>Test</arg0>" + "</ns1:sayHello>";

	public static class SimpleAsyncHandler implements AsyncHandler<Source> {
		public void handleResponse(Response<Source> responseSource) {
			try {
				Source response = responseSource.get();
				Transformer transformer = TransformerFactory.newInstance()
						.newTransformer();
				transformer.transform(response, new StreamResult(System.out));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {

		// AsyncCallBack
		// 服务端回调客户端
		QName serviceName = new QName("http://test/", "HelloWorldImplService");
		Service service = Service.create(new URL(
				"http://localhost:8080/HelloWorld?wsdl"), serviceName);
		QName portName = new QName("http://test/", "HelloWorldImplPort");
		final Dispatch<Source> dispatch = service.createDispatch(portName,
				Source.class, Mode.PAYLOAD);

		final Source msg = new SAXSource(new InputSource(new StringReader(
				payload)));
		final AsyncHandler<Source> handler = new SimpleAsyncHandler();
		new Thread() {
			public void run() {
				dispatch.invokeAsync(msg, handler);
			}
		}.start();
		System.out.println("I'm doing other..");

		// polling定时检查是否调用成功
		serviceName = new QName("http://test/", "HelloWorldImplService");
		service = Service.create(new URL(
				"http://localhost:8080/HelloWorld?wsdl"), serviceName);
		portName = new QName("http://test/", "HelloWorldImplPort");
		Dispatch<Source> dispatcher = service.createDispatch(portName,
				Source.class, Mode.PAYLOAD);

		Source msgs = new SAXSource(new InputSource(new StringReader(payload)));
		Response<Source> responseSource = dispatcher.invokeAsync(msgs);

		System.out.println("Sleep...");
		Thread.sleep(1000);
		System.out.println("Wake up...");

		Source response = responseSource.get();
		Transformer transformer = TransformerFactory.newInstance()
				.newTransformer();
		transformer.transform(response, new StreamResult(System.out));
	}
}
