/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.uengine.web.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Jackson JSON Utility.
 *
 * @author Seungpil, Park
 * @since 0.1
 */
public class JsonUtils {

    /**
     * Jackson JSON Object Mapper
     */
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 지정한 Object를 Jackson JSON Object Mapper를 이용하여 JSON으로 변환한다.
     *
     * @param obj JSON으로 변환할 Object
     * @return JSON String
     * @throws IOException JSON으로 변환할 수 없는 경우
     */
    public static String marshal(Object obj) throws IOException {
        return objectMapper.writeValueAsString(obj);
    }

    public static Map marshal(String json) throws IOException {
        return objectMapper.readValue(json, Map.class);
    }

    /**
     * 지정한 Object를 Jackson JSON Object Mapper를 이용하여 JSON으로 변환한다.
     *
     * @param obj JSON으로 변환할 Object
     * @return JSON String
     * @throws IOException JSON으로 변환할 수 없는 경우
     */
    public static String format(Object obj) throws IOException {
        String json = objectMapper.writeValueAsString(obj);
        return JsonFormatterUtils.prettyPrint(json);
    }

    public static Map unmarshal(String json) throws IOException {
        // Role을 잘못 정의하는 경우 "null" 등이 들어오는 경우가 있음.
        if ("\"null\"".equals(json)) {
            return new HashMap();
        }
        return objectMapper.readValue(json, Map.class);
    }

    public static List unmarshalToList(String json) throws IOException {
        return objectMapper.readValue(json, List.class);
    }

}
