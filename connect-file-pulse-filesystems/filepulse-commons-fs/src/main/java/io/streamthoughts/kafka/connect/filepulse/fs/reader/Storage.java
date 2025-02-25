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
package io.streamthoughts.kafka.connect.filepulse.fs.reader;

import io.streamthoughts.kafka.connect.filepulse.source.FileObjectMeta;
import org.apache.kafka.common.Configurable;

import java.io.InputStream;
import java.net.URI;
import java.util.Map;

public interface Storage extends Configurable {

    /**
     * {@inheritDoc}
     */
    @Override
    default void configure(final Map<String, ?> configs) { }

    /**
     *
     * @param uri    the file object {@link URI}.
     * @return       the {@link FileObjectMeta}.
     */
    FileObjectMeta getObjectMetadata(final URI uri);

    /**
     * Checks whether the given object exists and is accessible under this storage.
     *
     * @param uri    the file object {@link URI}.
     * @return       {@code true} if the object exist, otherwise {@code false}.
     */
    boolean exists(final URI uri);

    /**
     * Gets a {@link InputStream} for the given object.
     *
     * @param uri    the file object {@link URI}.
     * @return       new {@link {@link InputStream}.
     */
    InputStream getInputStream(final URI uri) throws Exception;
}
