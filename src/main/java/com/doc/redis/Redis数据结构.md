[原文链接](https://www.cnblogs.com/hunternet/p/12695738.html)
### Redis 的数据类型

#### ZSET 有序集合

##### 使用的算法
```shell
01. 跳表，时间复杂度 (log(N)) 每两个节点，抽取一层
```

#### 集合 SET (无序，无重复)
一个集合最多可以存储232-1个元素
##### 集合与列表差别
```shell
列表可以存储重复元素，集合只能存储非重复元素;
列表是按照元素的先后顺序存储元素的，而集合则是无序方式存储元素的。
```
##### 使用场景
```shell
集合类型比较典型的使用场景是标签（tag）

给用户添加标签。

sadd user:1:tags tag1 tag2 tag5
sadd user:2:tags tag2 tag3 tag5
...
sadd user:k:tags tag1 tag2 tag4

给标签添加用户


sadd tag1:users user:1 user:3
sadd tag2:users user:1 user:2 user:3
...
sadd tagk:users user:1 user:2
使用sinter命令，可以来计算用户共同感兴趣的标签
sinter user:1:tags user:2:tags
```

#### 列表
```shell
列表（list）类型是用来存储多个有序的字符串，
列表中的每个字符串称为元素(element)，
一个列表最多可以存储232-1个元素。在Redis中，
可以对列表两端插入（push）和弹出（pop），
还可以获取指定范围的元素列表、获取指定索引下标的元素等
```
#### Hash
```shell
hset hget
```
### 字符串
```shell
 字符串对象是 Redis 中最基本的数据类型,
也是我们工作中最常用的数据类型。redis中的键都是字符串对象，
而且其他几种数据结构都是在字符串对象基础上构建的。
字符串对象的值实际可以是字符串、数字、甚至是二进制
，最大不能超过512MB 。


set \get mset mget
```

