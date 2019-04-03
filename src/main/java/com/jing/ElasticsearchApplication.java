package com.jing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * springboot 默认支持两种技术和ES交互
 * 1.jest(默认不生效)
 * 需要导入jest的工具包（io.searchbox.client.JestClient）
 * 2.SpringData Elasticsearch
 * 		1).client节点信息clusterNodes;clusterName
 * 		2).ElasticSearchTemplate 操作es
 * 		3).编写一个ElasticsearchRepository的子接口来操作ES
 */
@SpringBootApplication
public class ElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchApplication.class, args);
	}

}
