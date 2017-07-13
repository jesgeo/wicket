package my.wicket.app;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import my.wicket.app.hello.Hello;

public class MyApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return Hello.class; //return default page
	}

}
