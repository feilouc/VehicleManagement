lib文件夹中是mysql8.0.23的jar包，可以自己上官网下载
8.0版本之后换了新的驱动
出现 PublicKeyRetrieval 问题，密钥不允许公开
解决方法：在string url = String url = "jdbc:mysql://127.0.0.1:3306/Vehicle_Management?useSSL=false&&allowPublicKeyRetrieval=true";
加上allowPublicKeyRetrieval=true之后问题解决，而且之后连接也不会出现问题。
image是图片包，源码放在src包中
建议下一个windowbuilder插件来搭配使用方便可视化操作