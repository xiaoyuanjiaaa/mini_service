package com.fc.protocol.server.demo.handler;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fc.protocol.common.message.body.ProtocolResponse;
import com.fc.protocol.demo.request.EchoRequest;
import com.fc.protocol.server.demo.entity.Test;
import com.fc.protocol.server.demo.persistance.mybatis.Page;
import com.fc.protocol.server.demo.persistance.mybatis.PageQuery;
import com.fc.protocol.server.demo.service.ITestService;
import com.fc.protocol.server.demo.service.IWechatRechargeService;
import com.fc.protocol.server.handler.Handler;
import com.fc.protocol.server.handler.ReqCodeMapping;

@Component
@Handler(module = "demo")
public class DemoHandler {

	private static Logger log = LoggerFactory.getLogger(DemoHandler.class);

	@Autowired
	IWechatRechargeService wechatRechargeService;
	@Autowired
	ITestService testService;

	@ReqCodeMapping(requestClazz = EchoRequest.class)
	public ProtocolResponse echo(EchoRequest request) {
		log.info("EchoHandler------>request:{}", request);
		ProtocolResponse response = ProtocolResponse.newInstance().success().msg("ECHO测试成功").addData("number",
				request.getNumber());

		Page page = new Page();
		page.setPage(1);
		page.setRows(10);
		page.setShowTotal(true);
		PageQuery pageQuery = new PageQuery(page, new HashMap<String, Object>());
		try {
			System.out.println("===============" + testService.add(new Test(100, "肖肖", "来试试")));
			System.out.println("===============" + testService.updateByID(new Test(100, "肖1肖", "来试试1")));
			System.out.println("----------------------" + testService.getTestOpListPage(page, new HashMap<>()));
			System.out
					.println("******************" + wechatRechargeService.getRechargeOpListPage(page, new HashMap<>()));
			/*System.out.println((wechatRechargeMapper==null)+"=============");
			List<WechatRecharge> dd = wechatRechargeMapper.getRowsPage(pageQuery);
			System.out.println("================="+dd);*/
		} catch (Exception e) {
			e.printStackTrace();
		}

		int number = request.getNumber();

		if (number % 5 == 0) {
			log.info("休眠{}秒......", number);
			try {
				TimeUnit.SECONDS.sleep(number);
			} catch (InterruptedException e) {
				log.error("error:{}", e);
			}
		}

		/**
		log.info("休眠{}秒......", number);
		try {
			TimeUnit.SECONDS.sleep(number);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		//		log.info("休眠10秒......");
		//		try {
		//			TimeUnit.SECONDS.sleep(4);
		//		} catch (InterruptedException e) {
		//			e.printStackTrace();
		//		}
		log.info("EchoHandler------>response:{}", response);
		return response;
	}

}
