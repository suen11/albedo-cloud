///*
// *  Copyright (c) 2019-2020, 冷冷 (somewhere0813@gmail.com).
// *  <p>
// *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
// *  you may not use this file except in compliance with the License.
// *  You may obtain a copy of the License at
// *  <p>
// * https://www.gnu.org/licenses/lgpl.html
// *  <p>
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.albedo.java.modules.codegen;
//
//import com.albedo.java.common.security.annotation.EnablePigFeignClients;
//import com.albedo.java.common.security.annotation.EnablePigResourceServer;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.SpringApplication;
//import org.springframework.cloud.client.SpringCloudApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.core.env.Environment;
//
//import java.net.InetAddress;
//
///**
// * @author somewhere
// * @date 2019/2/1
// * 代码生成模块
// */
//@EnablePigFeignClients
//@EnablePigResourceServer
//@SpringCloudApplication
//@Slf4j
//public class AlbedoCodeGenApplicationOld {
//
//	static String SERVER_PORT = "server.port";
//	static String SPRING_APPLICATION_NAME = "spring.application.name";
//
//
//	public static void main(String[] args) throws Exception {
//		SpringApplication app = new SpringApplication(AlbedoCodeGenApplicationOld.class);
//		final ApplicationContext applicationContext = app.run(args);
//		Environment env = applicationContext.getEnvironment();
//
//		log.info("\n----------------------------------------------------------\n\t" +
//				"Application '{}' is running! Access URLs:\n\t" +
//				"Local: \t\thttp://localhost:{}\n\t" +
//				"External: \thttp://{}:{}\n----------------------------------------------------------",
//			env.getProperty(SPRING_APPLICATION_NAME),
//			env.getProperty(SERVER_PORT),
//			InetAddress.getLocalHost().getHostAddress(),
//			env.getProperty(SERVER_PORT));
//	}
//}
