/*
 *
 * Copyright 2017-2018 Nitrite author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.dizitart.no2.collection;

import org.dizitart.no2.Document;
import org.dizitart.no2.NitriteContext;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.exceptions.ValidationException;
import org.dizitart.no2.store.NitriteMap;

import static org.dizitart.no2.exceptions.ErrorCodes.VE_CONTEXT_NULL;
import static org.dizitart.no2.exceptions.ErrorCodes.VE_MAP_STORE_NULL;
import static org.dizitart.no2.exceptions.ErrorMessage.errorMessage;

/**
 * A factory class to create a {@link NitriteCollection}.
 *
 * @since 1.0
 * @author Anindya Chatterjee.
 */
public class CollectionFactory {
    /**
     * Opens or creates a {@link NitriteCollection}.
     *
     * @param mapStore the map store
     * @param context  the {@link NitriteContext}
     * @return the {@link NitriteCollection}.
     */
    public static NitriteCollection open(NitriteMap<NitriteId, Document> mapStore,
                                         NitriteContext context) {
        if (mapStore == null) {
            throw new ValidationException(errorMessage("mapStore cannot be null", VE_MAP_STORE_NULL));
        }

        if (context == null) {
            throw new ValidationException(errorMessage("context cannot be null", VE_CONTEXT_NULL));
        }

        return new DefaultNitriteCollection(mapStore, context);
    }
}
