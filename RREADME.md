使用的elasticsearch的docker版本是6.4.3，如果出现下面的问题，**因为版本不兼容**
```
NoNodeAvailableException: None of the configured nodes are available: [{#transport#-1}
```

具体可以查阅[https://github.com/spring-projects/spring-data-elasticsearch](https://github.com/spring-projects/spring-data-elasticsearch)

使用的springboot版本为2.1.3版本



在启动docker的时候，使用的命令为

需要使用一下,

```
sysctl -w vm.max_map_count=262144
```

不然会提示你下面的错误

```
max virtual memory areas vm.max_map_count [65530] likely too low, increase to at least [262144]
```

设置好以后，使用下面的命令

```
docker run -e ES_JAVA_OPTS="-Xms256m -Xmx256m" -d -p 9200:9200 -p 9300:9300 --name ES1 elasticsearch:6.4.3
```

需要使用-e是因为es默认启动是需要2G的，而在创建docker是默认内存是1G，导致启动会失败，所以需要你修改参数

```
-e ES_JAVA_OPTS="-Xms256m -Xmx256m"
```

提示的错误为
```
Java HotSpot(TM) 64-Bit Server VM warning: INFO: os::commit_memory(0x0000000085330000, 2060255232, 0) failed; error='Cannot allocate memory' 
```