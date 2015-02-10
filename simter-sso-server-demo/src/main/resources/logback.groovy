// http://logback.qos.ch/manual/groovy.html
// http://logback.qos.ch/translator/asGroovy.html
import ch.qos.logback.core.*;
import ch.qos.logback.core.encoder.*;
import ch.qos.logback.core.read.*;
import ch.qos.logback.core.rolling.*;
import ch.qos.logback.core.status.*;
import ch.qos.logback.classic.net.*;

scan("2 seconds")
appender("console", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
       // pattern = "%d{HH:mm:ss.SSS} %p [%thread] %c{0}.%M:%L - %msg%n"
        //pattern = "%d{HH:mm:ss.SSS} %level [%thread] %c{0}.%M:%L - %msg%n"
        pattern = "%d{HH:mm:ss.SSS} %level [%thread] %replace(%caller{1}){'\\r|\\n|\\r\\n|Caller\\+0\\t\\sat\\s',''} - %msg%n"
    }
}

appender("rollingFile", RollingFileAppender) {
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "logback.%d{yyyyMMdd}.log"
        maxHistory = 30
    }
    encoder(PatternLayoutEncoder) {
        // %d:日期;%thread:线程名;%-5level：级别,从左显示5个字符宽度;%msg:日志消息;%n:换行符
        pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50}.%method:%line - %msg%n"
    }
    triggeringPolicy(SizeBasedTriggeringPolicy) {
        maxFileSize = "10MB"
    }
}

// 默认日志级别: TRACE < DEBUG < INFO < WARN < ERROR
root(WARN, ["console", "rollingFile"])

// 自定义日志级别
logger("org.simter", DEBUG)