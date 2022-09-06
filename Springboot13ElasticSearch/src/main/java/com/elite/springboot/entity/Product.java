package com.elite.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.lucene.analysis.core.TypeTokenFilter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "products",shards = 1,replicas = 1)
public class Product {

    //全局id
    @Id
    private Long id;
    //商品名
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String productName;

    //商品类别
    //短语，不进行分词
    @Field(type=FieldType.Keyword)
    private String productType;

    //描述
    @Field(type=FieldType.Text)
    private String productDesc;

    //价格
    @Field(type=FieldType.Double)
    private String productPrice;
}
