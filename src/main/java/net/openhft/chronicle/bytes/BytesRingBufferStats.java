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

/**
 * @author Rob Austin.
 */
public interface BytesRingBufferStats {
    /**
     * each time the ring is read, this logs the number of bytes in the write buffer, calling this
     * method resets these statistics,
     *
     * @return Long.MAX_VALUE if no read calls were made since the last time this method was called.
     */
    long minNumberOfWriteBytesRemaining();

    /**
     * @return the total capacity in bytes
     */
    long capacity();

    long getAndClearReadCount();

    long getAndClearWriteCount();

    long maxCopyTimeNs();
}
