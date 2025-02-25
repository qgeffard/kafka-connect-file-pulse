/*
 * Copyright 2019-2020 StreamThoughts.
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
package io.streamthoughts.kafka.connect.filepulse.fs;

import io.streamthoughts.kafka.connect.filepulse.source.FileObjectMeta;
import org.apache.kafka.common.Configurable;

import java.util.Collection;
import java.util.Map;

/**
 * The {@code FileSystemListing} is used to list the object files that exists under a specific file-system.
 */
public interface FileSystemListing extends Configurable {

    /**
     * Configure this class with the given key-value pairs
     */
    @Override
    void configure(final Map<String, ?> configs);

    /**
     * Lists all files existing into the specified input directory.
     *
     * @return      the list of all files found.
     */
    Collection<FileObjectMeta> listObjects();

    /**
     * Sets the filter to apply on each file during directory listing.
     * @param filter    the filter to apply.
     */
    void setFilter(final FileListFilter filter);

}
