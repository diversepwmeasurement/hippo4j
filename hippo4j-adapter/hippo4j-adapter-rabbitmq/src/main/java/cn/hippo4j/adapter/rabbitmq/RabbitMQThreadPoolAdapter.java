/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.hippo4j.adapter.rabbitmq;

import cn.hippo4j.adapter.base.ThreadPoolAdapter;
import cn.hippo4j.adapter.base.ThreadPoolAdapterParameter;
import cn.hippo4j.adapter.base.ThreadPoolAdapterState;
import cn.hippo4j.common.config.ApplicationContextHolder;
import cn.hippo4j.common.toolkit.ReflectUtil;
import com.rabbitmq.client.impl.ConsumerWorkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * RabbitMQ thread-pool adapter.
 */
@Slf4j
public class RabbitMQThreadPoolAdapter implements ThreadPoolAdapter, ApplicationListener<ApplicationStartedEvent> {

    private static final String RABBITMQ = "RabbitMQ";

    @Override
    public String mark() {
        return RABBITMQ;
    }

    @Override
    public ThreadPoolAdapterState getThreadPoolState(String identify) {
        return null;
    }

    @Override
    public boolean updateThreadPool(ThreadPoolAdapterParameter threadPoolAdapterParameter) {
        return false;
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        ConsumerWorkService bindingLifecycle = ApplicationContextHolder.getBean(ConsumerWorkService.class);
        ReflectUtil.getFieldValue(bindingLifecycle, "inputBindings");

    }
}
