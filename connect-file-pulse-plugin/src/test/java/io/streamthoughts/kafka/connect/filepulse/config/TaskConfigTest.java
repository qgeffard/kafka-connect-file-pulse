/*
 * Copyright 2019-2021 StreamThoughts.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.streamthoughts.kafka.connect.filepulse.config;

import io.streamthoughts.kafka.connect.filepulse.filter.AppendFilter;
import io.streamthoughts.kafka.connect.filepulse.filter.RecordFilter;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class TaskConfigTest {

    @Test
    public void should_configure_filter_given_on_failure() {
        final TaskConfig config = new TaskConfig(new HashMap<String, String>() {{
            put(CommonConfig.OUTPUT_TOPIC_CONFIG, "Test");
            put(CommonConfig.INTERNAL_REPORTER_CLUSTER_BOOTSTRAP_SERVER, "dummy:1234");
            put(TaskConfig.FILE_INPUT_PATHS_CONFIG, "/tmp");
            put(CommonConfig.FILTER_CONFIG, "Test");
            put(CommonConfig.FILTER_CONFIG + ".Test.type", AppendFilter.class.getName());
            put(CommonConfig.FILTER_CONFIG + ".Test." + AppendFilterConfig.APPEND_FIELD_CONFIG, "field");
            put(CommonConfig.FILTER_CONFIG + ".Test." + AppendFilterConfig.APPEND_VALUE_CONFIG, "value");
            put(CommonConfig.FILTER_CONFIG + ".Test." + AppendFilterConfig.ON_FAILURE_CONFIG, "Failure");
            put(CommonConfig.FILTER_CONFIG + ".Failure.type", AppendFilter.class.getName());
            put(CommonConfig.FILTER_CONFIG + ".Failure." + AppendFilterConfig.APPEND_FIELD_CONFIG, "error");
            put(CommonConfig.FILTER_CONFIG + ".Failure." + AppendFilterConfig.APPEND_VALUE_CONFIG, "value");
        }});

        final List<RecordFilter> filters = config.filters();
        Assert.assertEquals(1, filters.size());
        Assert.assertNotNull(filters.get(0).onFailure());
    }
}