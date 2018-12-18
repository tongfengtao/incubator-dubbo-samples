/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.apache.dubbo.samples.governance;

import org.apache.dubbo.samples.governance.api.AmericanService;
import org.apache.dubbo.samples.governance.api.CatService;
import org.apache.dubbo.samples.governance.api.ChineseService;
import org.apache.dubbo.samples.governance.api.DogService;
import org.apache.dubbo.samples.governance.api.LionService;
import org.apache.dubbo.samples.governance.api.TigerService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FrontendConsumer {

    private static ExecutorService executorService = Executors.newFixedThreadPool(3);

    private static long interval = 5000;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo-demo-consumer.xml"});
        context.start();

        while (true) {
            try {
//                cat(context);
                dog(context);
//                tiger(context);
//                lion(context);
                chinese(context);
                american(context);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

    }

    public static void cat(ClassPathXmlApplicationContext context) {
        executorService.submit(() -> {
            while (true) {
                CatService catService = (CatService) context.getBean("catService");
                System.out.println(catService.cat());
                Thread.sleep(interval);
            }
        });
    }

    public static void dog(ClassPathXmlApplicationContext context) {
        executorService.submit(() -> {
            while (true) {
                DogService dogService = (DogService) context.getBean("dogService");
                System.out.println(dogService.dog());
                Thread.sleep(interval);
            }
        });
    }

    public static void lion(ClassPathXmlApplicationContext context) {
        executorService.submit(() -> {
            while (true) {
                LionService lionService = (LionService) context.getBean("lionService");
                System.out.println(lionService.lion());
                Thread.sleep(interval);
            }
        });
    }

    public static void tiger(ClassPathXmlApplicationContext context) {
        executorService.submit(() -> {
            while (true) {
                TigerService tigerService = (TigerService) context.getBean("tigerService");
                System.out.println(tigerService.tiger());
                Thread.sleep(interval);
            }
        });
    }

    public static void chinese(ClassPathXmlApplicationContext context) {
        executorService.submit(() -> {
            while (true) {
                ChineseService chineseService = (ChineseService) context.getBean("chineseService");
                System.out.println(chineseService.eat());
                Thread.sleep(interval);
            }
        });
    }

    public static void american(ClassPathXmlApplicationContext context) {
        executorService.submit(() -> {
            while (true) {
                AmericanService americanService = (AmericanService) context.getBean("americanService");
                System.out.println(americanService.eat());
                Thread.sleep(interval);
            }
        });
    }


}