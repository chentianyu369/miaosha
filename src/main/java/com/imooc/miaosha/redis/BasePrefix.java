package com.imooc.miaosha.redis;

//在redis的key中加前缀空间防止key不一样
public abstract class BasePrefix implements KeyPrefix{
	
	private int expireSeconds;//过期时间
	
	private String prefix;//前缀

	//默认0代表永不过期
	public BasePrefix(String prefix) {//0代表永不过期
		this(0, prefix);
	}
	
	public BasePrefix(int expireSeconds, String prefix) {
		this.expireSeconds = expireSeconds;
		this.prefix = prefix;
	}
	
	public int expireSeconds() {//默认0代表永不过期
		return expireSeconds;
	}

	//设置前缀,不同的类名
	public String getPrefix() {
		String className = getClass().getSimpleName();
		return className+":" + prefix;
	}

}
