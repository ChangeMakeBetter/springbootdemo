package com.yang.springbootdemo.redis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BillLockMgr {

  public void lock(String key, String requestId, int timeout, int expireTime, int waitInterval)
    throws Exception {
    try {
      int takeTime = 0;
      while (true) {
        RedisCache cache = RedisCache.getInstance();
        if (takeTime >= timeout) {
          log.debug("锁定超时");
          throw new Exception("锁定超时");
        }
        String lockValue = (String) cache.getValue(key);
        if (requestId.equals(lockValue)) {
          return;
        }
        if (StringUtils.isBlank(lockValue)) {
          boolean ok = cache.putValue(key, requestId, expireTime);
          if (ok) {
            return;
          }
          log.debug("当前缓存锁不存在，插入锁失败");
        }
        Thread.sleep(waitInterval);
        log.debug("等待:" + waitInterval);
        takeTime += waitInterval;
      }
    } catch (Exception e) {
      log.error("锁异常", e);
      throw new Exception("锁定异常", e);
    }
  }

  public boolean release(String lockKey) {
    RedisCache cache = RedisCache.getInstance();
    String lockValue = (String) cache.getValue(lockKey);
    if (StringUtils.isBlank(lockValue)) {
      return true;
    }
    RedisPOJO result = cache.remove(lockKey);
    if (result != null) {
      return true;
    }
    log.error("释放锁[{}]失败,result:{}, lockValue:{}", lockKey, result, lockValue);
    return false;
  }
}
