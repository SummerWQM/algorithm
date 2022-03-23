### Kafka

#### topics
##### 多个分区
```shell
01. 一个主体，可以设置多个分区
02. 分区给每个消息分配唯一顺序ID
03. 通过ID做消费偏移量记录 ack 
04. 可配置数据保留策略,到期丢弃
Kafka的性能跟存储的数据量的大小无关， 所以将数据存储很长一段时间是没有问题的。

05. 每个分区可以配置多个副本，来容错。
06. 每个分区有一个 leader 机器，0个 或多个 服务器 充当 followers



```

##### 分区leader\followers

```shell

01. leader 处理所有读取和写入分区的请求。
02. followers 被动从leader 拷贝数据。
03. 如果leader失败了，将选取新的leader 从 followers 中。

```
#### 消费者
```shell
01. 消费者-消费群(consumer group ) 同一个消息在同一个消费群下
唯一消费

02. 不同的消费群，将都会收到消息。

```

#### 分区leader 选举算法
```shell

```