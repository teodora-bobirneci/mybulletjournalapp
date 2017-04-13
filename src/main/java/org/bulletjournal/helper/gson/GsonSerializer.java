package org.bulletjournal.helper.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Wrapper over gson in order to exclude certain fields from being serialized/deserialized. This is because we have
 * circular references inside the model.
 *
 * @author Teodora Bobirneci
 */
public class GsonSerializer {

    private static Gson gson = new GsonBuilder().setPrettyPrinting()
            .setExclusionStrategies(new GsonExclusionStrategy()).create();

    public static <T> String serializeToJson(T src){
        return gson.toJson(src);
    }

    public static <T> T deserializeJson(String json, Class<T> clasz){
        return gson.fromJson(json, clasz);
    }
}
