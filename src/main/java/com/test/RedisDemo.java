package com.test;

import java.util.ArrayList;
import java.util.List;

import com.entity.UserEntity;
import com.util.SerUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public class RedisDemo {

	public static void main(String[] args) {
		ListAdd();
	}

	public static void ListAdd() {
		// redis的路径ip
		String h = " ";
		// 密码
		String passwd = " ";

		/**
		 * 引入类 将redis服务器的ip地址进行一个加入
		 */
		JedisShardInfo jedisShardInfo = new JedisShardInfo(h);
		/**
		 * 设置一个redis的密码 如果没有设置的密码的话 则可能会出现 NOAUTH Authentication required. 身份验证出现问题
		 */
		jedisShardInfo.setPassword(passwd);
		Jedis jedis = new Jedis(jedisShardInfo);

		ArrayList<UserEntity> arrayList = new ArrayList<>();
		UserEntity user = new UserEntity("a", "男", 18, "四川");
		UserEntity user1 = new UserEntity("a1", "男", 18, "四川");
		UserEntity user2 = new UserEntity("a2", "男", 18, "四川");
		UserEntity user3 = new UserEntity("a3", "男", 18, "四川");

		arrayList.add(user);
		arrayList.add(user1);
		arrayList.add(user2);
		arrayList.add(user3);

		jedis.set("user".getBytes(), SerUtil.serialize(arrayList));
		byte[] bytes = jedis.get("user".getBytes());

		List<UserEntity> deserialize = (List<UserEntity>) SerUtil.noserialize(bytes);

		System.err.println(deserialize);
	}

	public static void UserAdd() {
		String h = " ";
		String passwd = " ";
		UserEntity user = new UserEntity("王五", "男", 18, "四川");
		/**
		 * 引入类 将redis服务器的ip地址进行一个加入
		 */
		JedisShardInfo jedisShardInfo = new JedisShardInfo(h);
		/**
		 * 设置一个redis的密码 如果没有设置的密码的话 则可能会出现 NOAUTH Authentication required. 身份验证出现问题
		 */
		jedisShardInfo.setPassword(passwd);
		Jedis jedis = new Jedis(jedisShardInfo);

		/**
		 * 添加一个redis数据 key为demo
		 */
		// 将user对象序列化
		jedis.set("user".getBytes(), SerUtil.serialize(user));

		/**
		 * 从redis获取到redis key 反序列化输出
		 */
		byte[] bytes = jedis.get("user".getBytes());

		UserEntity deserialize = (UserEntity) SerUtil.noserialize(bytes);

		System.err.println(deserialize);
	}
}
