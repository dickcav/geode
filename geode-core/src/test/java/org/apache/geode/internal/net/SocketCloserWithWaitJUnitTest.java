/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.geode.internal.net;

import java.util.concurrent.TimeUnit;

import org.junit.experimental.categories.Category;

import org.apache.geode.test.junit.categories.MembershipTest;

/**
 * Tests SocketCloser with a wait time. The default SocketCloser does not wait. This test configures
 * a closer much like the one used by CacheClientNotifier.
 */
@Category({MembershipTest.class})
public class SocketCloserWithWaitJUnitTest extends SocketCloserJUnitTest {

  @Override
  protected SocketCloser createSocketCloser() {
    return new SocketCloser(SocketCloser.ASYNC_CLOSE_POOL_KEEP_ALIVE_SECONDS, 1, // max threads
        1, TimeUnit.NANOSECONDS);
  }
}
