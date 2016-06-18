#### Spring MVC REST架构 综合项目
--- 
**项目结构**
>Spring MVC REST  
>>  REST CRUD
    1. REST 风格增删改查  
    2. Convert 类型转换  
    3. DateTimeFormat 数据格式化  
    4. Validate 数据校验 input.jsp EmployeeHandler   
    5. Spring MVC 表单标签


---
#### Spring MVC 表单标签
**WHY Spring MVC 表单标签：**  
```
  1. 快速开发表单页面，不用使用JSTL标签循环实现  
  2. 方便实现表单值得回显
```
注意： 1.可以通过 modelAttribute 属性指定绑定的模型属性
　　　２.若没有指定该属性，则默认从 request 域对象中读取 command 的表单 bean
　　　３.如果该属性值也不存在，则会发生错误。
<!--
			1. 数据类型转换
			2. 数据类型格式化
			3. 数据校验.
			1). 如何校验 ? 注解 ?
			①. 使用 JSR 303 验证标准
			②. 加入 hibernate validator 验证框架的 jar 包
			③. 在 SpringMVC 配置文件中添加 <mvc:annotation-driven />
			④. 需要在 bean 的属性上添加对应的注解
			⑤. 在目标方法 bean 类型的前面添加 @Valid 注解
			2). 验证出错转向到哪一个页面 ?
			注意: 需校验的 Bean 对象和其绑定结果对象或错误对象时成对出现的，它们之间不允许声明其他的入参
			3). 错误消息 ? 如何显示, 如何把错误消息进行国际化
			-->
				<!--  
            		default-servlet-handler 将在 SpringMVC 上下文中定义一个 DefaultServletHttpRequestHandler,
            		它会对进入 DispatcherServlet 的请求进行筛查, 如果发现是没有经过映射的请求,
            		就将该请求交由 WEB 应用服务器默认的
            		Servlet 处理. 如果不是静态资源的请求，才由 DispatcherServlet 继续处理
            
            		一般 WEB 应用服务器默认的 Servlet 的名称都是 default.
            		若所使用的 WEB 服务器的默认 Servlet 名称不是 default，则需要通过 default-servlet-name 属性显式指定
            		
            	-->
            	<!--  
                		国际化需求:
                		   1. 在页面上能够根据浏览器语言设置的情况，对文本, 时间, 数值进行本地化处理
                		   2. 可以在 bean 中，获取国际化资源文件 Locale 对应的消息
                		   3. 可以通过超链接切换 Locale, 而不再依赖于浏览器的语言设置情况
                		
                		国际化实现:
                		   1. 使用 JSTL 的 fmt 标签
                		   2. 在 bean 中注入 ResourceBundleMessageSource 的示例, 使用其对应的 getMessage 方法即可
                		   3. 配置 LocalResolver 和 LocaleChangeInterceptor
                	-->	
@ExceptionHandler  只在当前声明该注解的Controller中使用
@ControllerAdvice  所有Controller中有效，当Controller中没有声明@ExceptionHandler时，将调用ControllerAdvice卡类型处理
@ResponseStatus    修饰异常类和异常方法，用于生成异常提示，当修饰某个方法时客户端将得不到正常页面
@DefaultHandlerExceptionResolver 处理Spring特定类型的异常，具体可处理的异常可参考源代码
SimpleMappingExceptionResolver 对异常进行全局统一处理
