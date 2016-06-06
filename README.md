# p5api
##1、SSH整合\<br>
##2、整合struts2\<br>
##3、返回json数据\<br>
###壹、导入struts里面的json包
*       commons-beanutils-1.9.2.jar
*		commons-collections-3.2.2.jar
*		commons-lang-2.4.jar
*		ezmorph-1.0.6.jar
*		json-lib-2.3-jdk15.jar
*		commons-logging-1.1.3.jar
*		struts2-json-plugin-2.3.28.1.jar  注意版本匹配
		
###贰、struts配置
		extends struts-default,json-default
		
		<result type="json">
					<param name="root">result</param>  result 为Action的变量，返回的值，自动转换为json,需要setter和getter方法
	    </result>