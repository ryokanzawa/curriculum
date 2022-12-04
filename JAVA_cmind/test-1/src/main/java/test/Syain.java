package test;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;

@Component
@SessionScope
//@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Syain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
