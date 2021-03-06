/*
 * Copyright 2016 higherfrequencytrading.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.openhft.chronicle.bytes;

import junit.framework.TestCase;

public class PointerBytesStoreTest extends TestCase {

    public void testWrap() throws IllegalArgumentException {
        NativeBytesStore<Void> nbs = NativeBytesStore.nativeStore(10000);

        PointerBytesStore pbs = BytesStore.nativePointer();
        pbs.set(nbs.address(nbs.start()), nbs.realCapacity());

        long nanoTime = System.nanoTime();
        pbs.writeLong(0L, nanoTime);

        assertEquals(nanoTime, nbs.readLong(0L));
    }
}