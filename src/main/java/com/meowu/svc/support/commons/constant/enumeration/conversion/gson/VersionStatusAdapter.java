package com.meowu.svc.support.commons.constant.enumeration.conversion.gson;

import com.google.gson.*;
import com.meowu.starter.commons.utils.adapter.TypeAdapter;
import com.meowu.svc.support.commons.constant.enumeration.VersionStatus;

import java.lang.reflect.Type;
import java.util.Objects;

public class VersionStatusAdapter implements TypeAdapter<VersionStatus>{

    @Override
    public Class<VersionStatus> getType() {
        return VersionStatus.class;
    }

    @Override
    public JsonElement serialize(VersionStatus status, Type type, JsonSerializationContext jsonSerializationContext) {
        return Objects.isNull(status) ? null : new JsonPrimitive(status.getValue());
    }

    @Override
    public VersionStatus deserialize(JsonElement element, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return Objects.isNull(element) ? null : VersionStatus.getByValue(element.getAsString());
    }
}
