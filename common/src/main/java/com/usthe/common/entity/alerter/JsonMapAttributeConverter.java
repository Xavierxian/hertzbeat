package com.usthe.common.entity.alerter;

import com.google.gson.reflect.TypeToken;
import com.usthe.common.util.GsonUtil;

import javax.persistence.AttributeConverter;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * json 互转map对象字段为数据String字段
 *
 *
 */
public class JsonMapAttributeConverter implements AttributeConverter<Map<String, String>, String> {

    @Override
    public String convertToDatabaseColumn(Map<String, String> attribute) {
        return GsonUtil.toJson(attribute);
    }

    @Override
    public Map<String, String> convertToEntityAttribute(String dbData) {
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        return GsonUtil.fromJson(dbData, type);
    }
}
