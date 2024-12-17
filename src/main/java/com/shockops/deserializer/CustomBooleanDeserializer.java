package com.shockops.deserializer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomBooleanDeserializer extends JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext ctx) throws IOException {

        List<String> trues = Arrays.asList("1", "true");
        List<String> falses = Arrays.asList("0", "false");

        if (trues.contains(p.getText())) {
            return Boolean.TRUE;
        } else if (falses.contains(p.getText())) {
            return Boolean.FALSE;
        }
        return null;
    }
}
