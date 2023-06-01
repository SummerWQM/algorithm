#!/bin/zsh
top 找到java 进程 cpu 最好的

# 通过ps 定位 最好的线程
ps -mp 16268 -o THREAD,tid,time

# 计算16进制线程id
printf "%x\n" tid

# 通过堆栈工具， 导出 进程 对应的线程 堆栈信息， 取30行数据
jstack 1 |  grep 3330 -A 30