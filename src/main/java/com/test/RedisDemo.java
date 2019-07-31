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
		// redis��·��ip
		String h = " ";
		// ����
		String passwd = " ";

		/**
		 * ������ ��redis��������ip��ַ����һ������
		 */
		JedisShardInfo jedisShardInfo = new JedisShardInfo(h);
		/**
		 * ����һ��redis������ ���û�����õ�����Ļ� ����ܻ���� NOAUTH Authentication required. �����֤��������
		 */
		jedisShardInfo.setPassword(passwd);
		Jedis jedis = new Jedis(jedisShardInfo);

		ArrayList<UserEntity> arrayList = new ArrayList<>();
		UserEntity user = new UserEntity("a", "��", 18, "�Ĵ�");
		UserEntity user1 = new UserEntity("a1", "��", 18, "�Ĵ�");
		UserEntity user2 = new UserEntity("a2", "��", 18, "�Ĵ�");
		UserEntity user3 = new UserEntity("a3", "��", 18, "�Ĵ�");

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
		UserEntity user = new UserEntity("����", "��", 18, "�Ĵ�");
		/**
		 * ������ ��redis��������ip��ַ����һ������
		 */
		JedisShardInfo jedisShardInfo = new JedisShardInfo(h);
		/**
		 * ����һ��redis������ ���û�����õ�����Ļ� ����ܻ���� NOAUTH Authentication required. �����֤��������
		 */
		jedisShardInfo.setPassword(passwd);
		Jedis jedis = new Jedis(jedisShardInfo);

		/**
		 * ���һ��redis���� keyΪdemo
		 */
		// ��user�������л�
		jedis.set("user".getBytes(), SerUtil.serialize(user));

		/**
		 * ��redis��ȡ��redis key �����л����
		 */
		byte[] bytes = jedis.get("user".getBytes());

		UserEntity deserialize = (UserEntity) SerUtil.noserialize(bytes);

		System.err.println(deserialize);
	}
}
