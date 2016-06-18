#### Spring MVC REST架构 综合项目
--- 
**项目结构**
>Spring MVC REST  
>>  REST CRUD  
　　1. REST 风格增删改查  
　　2. Convert 类型转换 input.jsp  
　　3. DateTimeFormat 数据格式化  
　　4. Validate 数据校验 input.jsp EmployeeHandler   
　　5. Spring MVC 表单标签  
>>  Converter 类型转换器：GG-gg@atguigu.com-0-105-18823451366==>employee  
>>  Exception 异常处理  
　　1. @ExceptionHandler  只在当前声明该注解的Controller中使用  
　　2. @ControllerAdvice  所有Controller中有效，当前Controller中没有声明@ExceptionHandler时该注解类将起作用  
　　3. @ResponseStatus    修饰异常类和异常方法，用于生成异常提示，当修饰某个方法时客户端将得不到正常页面  
　　4. @DefaultHandlerExceptionResolver 处理Spring特定类型的异常，具体可处理的异常可参考源代码  
　　5. SimpleMappingExceptionResolver 对异常进行全局统一处理  
>>  Interceptor 拦截器处理  
>>  International 国际化处理  
>>  JSON 处理  
>>  upload 文件上传  
>>  validator 数据校验  


