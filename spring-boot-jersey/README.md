# IDEA下要注意spring-boot静态资源加载不成功或者jsp访问不成功的问题

> {"status":404,"error":"Not Found","message":"/WEB-INF/views/jsp/login.jsp","timeStamp":"Wed Oct 18 18:03:02 CST 2017","trace":null}

1. 必须在pom.xml中加入以下依赖

```xml
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
        <scope>provided</scope>
    </dependency>
```    

如果加了这个依赖还是不能解析jsp，则把上面依赖中的`<scope>provided</scope>`删除掉。

    
2. 最重要是在 Run - Edit Configurations - Working directory 中设置为当前maven模块所在目录，或者是：
    
```    
    $MODULE_DIR$    
```

## 不这么设置，访问静态资源或者jsp页面时抛出如下错误:

Whitelabel Error Page

This application has no explicit mapping for /error, so you are seeing this as a fallback.

Sun May 28 21:17:12 CST 2017
There was an unexpected error (type=Not Found, status=404).
No message available

## 或者是

{"status":404,"error":"Not Found","message":"No message available","timeStamp":"Sun May 28 20:18:50 CST 2017","trace":null}