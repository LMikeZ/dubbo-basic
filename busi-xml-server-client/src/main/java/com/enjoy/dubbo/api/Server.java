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

package com.enjoy.dubbo.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.enjoy.service.OrderService;
import com.enjoy.service.OrderServiceImpl;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        ServiceConfig<OrderService> config = new ServiceConfig<>();
        config.setApplication(new ApplicationConfig("busi-provider"));
        config.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        config.setInterface(OrderService.class);
        config.setRef(new OrderServiceImpl());
        config.export();

        System.out.println("first-dubbo-provider is running.");
        System.in.read();
    }
}