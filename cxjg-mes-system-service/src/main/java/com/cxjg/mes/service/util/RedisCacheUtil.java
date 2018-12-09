package com.cxjg.mes.service.util;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * redis的操作工具
 * @author Administrator
 *
 * @param <T>
 */
@Service("redisCacheUtil")
public class RedisCacheUtil<T> {
	
	@SuppressWarnings("rawtypes")
	@Resource
    private RedisTemplate redisTemplate;

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key   缓存的键值
     * @param value 缓存的值
     * @return 缓存的对象
     */
    @SuppressWarnings("hiding")
	public <T> ValueOperations<String, T> setCacheObject(String key, T value) {
        @SuppressWarnings("unchecked")
		ValueOperations<String, T> operation = redisTemplate.opsForValue();
        operation.set(key, value);
        return operation;
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
    @SuppressWarnings({ "hiding", "unchecked" })
	public <T> T getCacheObject(String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 缓存List数据
     *
     * @param key      缓存的键值
     * @param dataList 待缓存的List数据
     * @return 缓存的对象
     */
    @SuppressWarnings({ "hiding", "unchecked" })
	public <T> ListOperations<String, T> setCacheList(String key, List<T> dataList) {
        @SuppressWarnings("rawtypes")
		ListOperations listOperation = redisTemplate.opsForList();
        if (null != dataList) {
            int size = dataList.size();
            for (int i = 0; i < size; i++) {
                listOperation.rightPush(key, dataList.get(i));
            }
        }
        return listOperation;
    }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    @SuppressWarnings("hiding")
	public <T> List<T> getCacheList(String key) {
        List<T> dataList = new ArrayList<T>();
        @SuppressWarnings("unchecked")
		ListOperations<String, T> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size(key);

        for (int i = 0; i < size; i++) {
            dataList.add(listOperation.index(key,i));
        }
        return dataList;
    }

    /**
     * 缓存Set
     *
     * @param key     缓存键值
     * @param dataSet 缓存的数据
     * @return 缓存数据的对象
     */
    @SuppressWarnings({ "hiding", "unchecked" })
	public <T> BoundSetOperations<String, T> setCacheSet(String key, Set<T> dataSet) {
        BoundSetOperations<String, T> setOperation = redisTemplate.boundSetOps(key);
        Iterator<T> it = dataSet.iterator();
        while (it.hasNext()) {
            setOperation.add(it.next());
        }
        return setOperation;
    }

    /**
     * 获得缓存的set
     *
     * @param key
     * @return
     */
    public Set<T> getCacheSet(String key) {
        Set<T> dataSet = new HashSet<T>();
        @SuppressWarnings("unchecked")
		BoundSetOperations<String, T> operation = redisTemplate.boundSetOps(key);
        Long size = operation.size();
        for (int i = 0; i < size; i++) {
            dataSet.add(operation.pop());
        }
        return dataSet;
    }

    /**
     * 缓存Map
     *
     * @param key
     * @param dataMap
     * @return
     */
    @SuppressWarnings({ "hiding", "unchecked" })
	public <T> HashOperations<String, String, T> setCacheMap(String key, Map<String, T> dataMap) {
        @SuppressWarnings("rawtypes")
		HashOperations hashOperations = redisTemplate.opsForHash();
        if (null != dataMap) {
            for (Map.Entry<String, T> entry : dataMap.entrySet()) {
                hashOperations.put(key, entry.getKey(), entry.getValue());
            }
        }
        return hashOperations;
    }
    
    /**
     * 缓存Map
     *
     * @param key
     * @param dataMap
     * @return
     */
    @SuppressWarnings({ "hiding", "unchecked" })
	public <T> HashOperations<String, String, T> setCacheMapKeys(String key, String hashKey, T value) {
        @SuppressWarnings("rawtypes")
		HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put(key, hashKey, value);
        return hashOperations;
    }

    /**
     * 缓存Map
     *
     * @param key
     * @param dataMap
     * @return
     */
    @SuppressWarnings({ "hiding", "unchecked" })
	public <T> HashOperations<String, String, List<T>> setCacheMapKeysValues(String key, String hashKey, List<T> value) {
        @SuppressWarnings("rawtypes")
		HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put(key, hashKey, value);
        return hashOperations;
    }
    
    
    /**
     * 获得缓存的Map
     *
     * @param key
     * @return
     */
    @SuppressWarnings("hiding")
	public <T> Map<String, T> getCacheMap(String key) {
        @SuppressWarnings("unchecked")
		Map<String, T> map = redisTemplate.opsForHash().entries(key);
        return map;
    }
    
    /**
     * 根据大小key获取对象
     * @param k
     * @param hk
     * @return
     */
    public T getCatchObject(String k, String hk){
    	@SuppressWarnings("unchecked")
		Map<String, T> map = redisTemplate.opsForHash().entries(k);
    	return map.get(hk);
    }
    
    /**
     * 根据大小key获取对象
     * @param k
     * @param hk
     * @return
     */
    public List<T> getCatchObjectValus(String k, String hk){
    	@SuppressWarnings("unchecked")
		Map<String, List<T>> map = redisTemplate.opsForHash().entries(k);
    	return map.get(hk);
    }
    
    /**
     * 根据大小key获取对象
     * @param k
     * @param hk
     * @return
     */
    public Map<String, List<T>> getCatchObjectMap(String k){
    	@SuppressWarnings("unchecked")
		Map<String, List<T>> map = redisTemplate.opsForHash().entries(k);
    	return map;
    }


    /**
     * 缓存Map
     *
     * @param key
     * @param dataMap
     * @return
     */
    @SuppressWarnings({ "hiding", "unchecked" })
	public <T> HashOperations<String, Integer, T> setCacheIntegerMap(String key, Map<Integer, T> dataMap) {
        @SuppressWarnings("rawtypes")
		HashOperations hashOperations = redisTemplate.opsForHash();
        if (null != dataMap) {
            for (Map.Entry<Integer, T> entry : dataMap.entrySet()) {
                hashOperations.put(key, entry.getKey(), entry.getValue());
            }
        }
        return hashOperations;
    }

    /**
     * 获得缓存的Map
     *
     * @param key
     * @return
     */
    @SuppressWarnings("hiding")
	public <T> Map<Integer, T> getCacheIntegerMap(String key) {
        @SuppressWarnings("unchecked")
		Map<Integer, T> map = redisTemplate.opsForHash().entries(key);
        return map;
    }
    
    /**
     * 删除缓存
     * @param key
     * @param hashKey
     */
    @SuppressWarnings("unchecked")
	public Boolean delete(Object key, Object hashKey){
    	Long deleteNum = redisTemplate.opsForHash().delete(key, hashKey);
    	if(deleteNum > 0){
    		return Boolean.TRUE;
    	}else{
    		return Boolean.FALSE;
    	}
    }
	
	/**
     * 缓存List数据
     *
     * @param key      缓存的键值
     * @param data 待缓存的数据
     * @return 缓存的对象
     */
    public <T> ListOperations<String, T> setCacheQueue(String key, T data) {
        ListOperations listOperation = redisTemplate.opsForList();
        listOperation.rightPush(key, data);
        return listOperation;
    }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public <T> T getCacheQueue(String key) {
        ListOperations<String, T> listOperation = redisTemplate.opsForList();
        T result = listOperation.leftPop(key);
        return result;
    }
    
    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public Integer getCacheQueueIndex(String key, T data) {
        ListOperations<String, T> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size(key);
        Integer result = 0;
        for(int i=0; i<size; i++){
        	T currentData = listOperation.index(key, i);
        	if(data.equals(currentData)){
        		result = i + 1;
        		break;
        	}
        }
        return result;
    }
}
