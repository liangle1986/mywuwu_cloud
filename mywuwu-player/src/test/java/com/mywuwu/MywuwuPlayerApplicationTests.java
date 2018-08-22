package com.mywuwu;

import com.mywuwu.qiniu.service.IQiniuMediaUtilService;
import com.qiniu.api.auth.AuthException;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MywuwuPlayerApplicationTests {

	@Autowired
	IQiniuMediaUtilService utilService;
	@Test
	public void contextLoads() throws AuthException, JSONException {
		utilService.uploadFile(new File("C:/Users/Administrator/Desktop/QQ图片20180813210454.jpg"));
	}

}
