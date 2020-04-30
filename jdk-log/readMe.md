JDKLog是JDK官方提供的一个记录日志的方式，
优点：直接在JDK中就可以使用
缺点：功能比较太过于简单，不支持占位符显示，拓展性比较差

========================
msg处理即简单的设置->返回
[java.util.logging.LogRecord]
public String getMessage() {return message;}
public void setMessage(String message) {this.message = message;}

日志级别有:
[java.util.logging.Level]
从高到低: OFF(较少使用) > SEVERE > WARNING > INFO(默认) > CONFIG > FINE > FINER > FINEST > ALL(较少使用)