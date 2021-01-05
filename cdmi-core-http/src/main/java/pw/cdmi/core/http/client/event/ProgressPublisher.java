/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package pw.cdmi.core.http.client.event;

public class ProgressPublisher {
    
    public static void publishProgress(
            final ProgressListener listener, 
            final ProgressEventType eventType) {
        if (listener == ProgressListener.NOOP || listener == null || 
                eventType == null) {
            return;
        }
        listener.progressChanged(new ProgressEvent(eventType));
    }
    
    public static void publishRequestContentLength(
            final ProgressListener listener,
            final long bytes) {
        publishByteCountEvent(listener, ProgressEventType.REQUEST_CONTENT_LENGTH_EVENT, bytes);
    }
    
    public static void publishRequestBytesTransferred(
            final ProgressListener listener,
            final long bytes) {
        publishByteCountEvent(listener, ProgressEventType.REQUEST_BYTE_TRANSFER_EVENT, bytes);
    }
    
    public static void publishResponseContentLength(
            final ProgressListener listener,
            final long bytes) {
        publishByteCountEvent(listener, ProgressEventType.RESPONSE_CONTENT_LENGTH_EVENT, bytes);
    }
    
    public static void publishResponseBytesTransferred(
            final ProgressListener listener,
            final long bytes) {
        publishByteCountEvent(listener, ProgressEventType.RESPONSE_BYTE_TRANSFER_EVENT, bytes);
    }
    
    private static void publishByteCountEvent(
            final ProgressListener listener,
            final ProgressEventType eventType, 
            final long bytes) {
        if (listener == ProgressListener.NOOP || listener == null || bytes <= 0) {
            return;
        }
        listener.progressChanged(new ProgressEvent(eventType, bytes));
    }
}
