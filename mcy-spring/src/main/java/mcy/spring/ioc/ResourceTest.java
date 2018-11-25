package mcy.spring.ioc;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ResourceTest {

	public static void main(String[] args) throws IOException {
		String filePath = "/Users/Kydu1024/IdeaProjects/spring-framework/mcy-spring/src/main/resources/conf/file1.text";
		WritableResource res1 = new PathResource(filePath);
		Resource res2 = new ClassPathResource("conf/file1.text");

		OutputStream stream1 = res1.getOutputStream();
		stream1.write("欢迎光临\n小春论坛".getBytes());
		stream1.close();

		InputStream ins1 = res1.getInputStream();
		InputStream ins2 = res2.getInputStream();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i;
		while ((i = ins1.read()) != -1) {
			baos.write(i);
		}
		System.out.println(baos.toString());

		System.out.println("res1:" + res1.getFilename());
		System.out.println("res2:" + res2.getFilename());

		System.out.println("-----------------");
		Resource res3 = new ClassPathResource("conf/file1.text");
		EncodedResource encodedResource = new EncodedResource(res3, "UTF-8");
		String read = FileCopyUtils.copyToString(encodedResource.getReader());
		System.out.println(read);

		System.out.println("-----------------");
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		//加载所有beans目录下的.java文件
		Resource[] resources = resourcePatternResolver.getResources("classpath*:mcy/**/*.java");
		for (Resource resoure : resources) {
			System.out.println(resoure.getDescription());
		}
	}
}
