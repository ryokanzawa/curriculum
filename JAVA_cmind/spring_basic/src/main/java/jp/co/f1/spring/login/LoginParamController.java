package jp.co.f1.spring.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginParamController {
	@RequestMapping("/loginParam1")
	public String loginParam1(@RequestParam String id, @RequestParam String pass)
	{
		if(id.equals("") || pass.equals("")) {
			return "ログインに失敗しました";
		}
		return "ログインに成功しました(ID :" + id + " PASS " + pass + ") ";
	}
	
}
