/**
 * 自动Controller注册
 * <p>
 * 执行逻辑：
 * 1：import AutoControllerScannerRegistrar
 * 2：执行AutoControllerScanner扫描所有带有AppController的类，记录到AutoControllerMetadataManager
 * 3：Spring执行Mapping的时候，会扫描到AutoControllerMapping（本身也是一个Controller），因此会执行其中的static区块
 * 该区块会读取AutoControllerMetadataManager，读取后注册Controller到Spring
 *
 * @author yangyanze
 * @date 2019/11/13
 */
package com.qzing.ddd.classic.demo.core.controller.automapping;