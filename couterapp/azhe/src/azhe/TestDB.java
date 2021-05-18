package azhe;

import java.util.logging.Logger;

public class TestDB {
	private static final Logger logger 
	    = LoggerFactory.getLogger(TestDB.class);
	
	private AppDao appDao ;
 
	private ApplicationContext ctx;
 
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:/applicationContext*.xml",
		});
		appDao = (AppDao)  ctx.getBean("appDao");
	}
 
	@Test
	public void getAllApp() {
        List<App> list = appDao.getAllApp();
        for(App app : list){
        	System.out.println(app.toString());
        }
        
	}
	
	@Ignore("ignore")
	@Test
	public void hasExisted(){
		logger.info(String.valueOf(appDao.hasExisted("app2")));
	}
	
	@Ignore("ignore")
	@Test
	public void deleteByAppID(){
		logger.info(String.valueOf(appDao.deleteAppByID("app_apk_1")));
	}
	
	@Ignore("ignore")
	@Test
	public void updateApp(){
		App app = new App();
		app.setAppID("°¢Ê²¶Ù");
		app.setName("goodµÄ");
		appDao.updateApp(app);
	}
	
}