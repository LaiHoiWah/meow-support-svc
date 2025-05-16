package com.meowu.svc.support.commons.constant.converter.gson;

import com.google.gson.*;
import com.meowu.starter.commons.utils.adapter.TypeAdapter;
import com.meowu.svc.support.commons.constant.RecordStatus;

import java.lang.reflect.Type;
import java.util.Objects;

public class RecordStatusTypeAdapter implements TypeAdapter<RecordStatus>{

    @Override
    public Class<RecordStatus> getType(){
        return RecordStatus.class;
    }

    @Override
    public JsonElement serialize(RecordStatus status, Type type, JsonSerializationContext jsonSerializationContext){
        return Objects.isNull(status) ? null : new JsonPrimitive(status.getValue());
    }

    @Override
    public RecordStatus deserialize(JsonElement element, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException{
        return Objects.isNull(element) ? null : RecordStatus.getByValue(element.getAsString());
    }
}
